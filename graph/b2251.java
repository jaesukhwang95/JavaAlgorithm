package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b2251 {
	
	
	public static class Water
	{
		int a;
		int b;
		int c;
		Water(int a, int b, int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	static boolean [][][] visit = new boolean [201][201][201];
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Queue<Water> q = new LinkedList<Water>();
		visit[0][0][C] = true;
		q.offer(new Water(0,0,C));
		while(!q.isEmpty())
		{
			Water w = q.poll();
			int a = w.a;
			int b = w.b;
			int c = w.c;
			
			if(a==0)
			{
				ans.add(c);
			}
			
			//a->b
			if(a+b<B){
				if(!visit[0][a+b][c])
				{
					q.offer(new Water(0, a+b, c));
					visit[0][a+b][c] = true;
				}
			}
			else{
				if(!visit[a+b-B][B][c])
				{
					q.offer(new Water(a+b-B, B, c));
					visit[a+b-B][B][c] = true;
				}
			}
			//b->a
			if(a+b<A){
				if(!visit[a+b][0][c])
				{
					q.offer(new Water(a+b, 0, c));
					visit[a+b][0][c] = true;
				}
			}
			else{
				if(!visit[A][a+b-A][c])
				{
					q.offer(new Water(A, a+b-A, c));
					visit[A][a+b-A][c] = true;
				}
			}
			//a->c
			if(a+c<C){
				if(!visit[0][b][a+c])
				{
					q.offer(new Water(0, b, a+c));
					visit[0][b][a+c] = true;
				}
			}
			else{
				if(!visit[a+c-C][b][C])
				{
					q.offer(new Water(a+c-C, b, C));
					visit[a+c-C][b][C] = true;
				}
			}
			//c->a
			if(a+c<A){
				if(!visit[a+c][b][0])
				{
					q.offer(new Water(a+c, b, 0));
					visit[a+c][b][0] = true;
				}
			}
			else{
				if(!visit[A][b][a+c-A])
				{
					q.offer(new Water(A, b, a+c-A));
					visit[A][b][a+c-A] = true;
				}
			}
			//b->c
			if(b+c<C){
				if(!visit[a][0][b+c])
				{
					q.offer(new Water(a, 0, b+c));
					visit[a][0][b+c] = true;
				}
			}
			else{
				if(!visit[a][b+c-C][C])
				{
					q.offer(new Water(a, b+c-C, C));
					visit[a][b+c-C][C] = true;
				}
			}
			//c->b
			if(b+c<B){
				if(!visit[a][b+c][0])
				{
					q.offer(new Water(a, b+c, 0));
					visit[a][b+c][0] = true;
				}
			}
			else{
				if(!visit[a][B][b+c-B])
				{
					q.offer(new Water(a, B, b+c-B));
					visit[a][B][b+c-B] = true;
				}
			}
		}
		Collections.sort(ans);
		for(int e: ans)
		{
			System.out.print(e+" ");
		}
		System.out.println();
	}
}
