package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b12869 {
	
	public static int [] damage = {9,3,1};
	
	public static int attackTwo(int [] scvHealth, int maxHealth)
	{
		int cnt = 0;
		boolean [][] visit = new boolean [maxHealth+1][maxHealth+1];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<2; i++)
		{
			q.offer(scvHealth[i]);
		}
		q.offer(cnt);
		visit[scvHealth[0]][scvHealth[1]] = true;
		int nowCnt = 0;
		Loop: while(!q.isEmpty())
		{
			int [] polledScvHealth = new int [2];
			for(int i=0; i<2; i++)
				polledScvHealth[i] = q.poll();
			nowCnt = q.poll();
			System.out.println(polledScvHealth[0]+" "+polledScvHealth[1]+"xxxxx");
			if(polledScvHealth[0]-9>0 || polledScvHealth[1]-3>0)
			{
				System.out.println(polledScvHealth[0]+" "+polledScvHealth[1]);
				if(polledScvHealth[0]-9<=0 && polledScvHealth[1]-3<=0)
				{
					System.out.println(polledScvHealth[0]+" "+polledScvHealth[1]+"yyyyy");
					break Loop;
				}
				if(polledScvHealth[0]-9<=0)
				{
					polledScvHealth[0] = 9;
				}
				if(polledScvHealth[1]-3<=0)
				{
					polledScvHealth[1] = 3;
				}
				if(!visit[polledScvHealth[0]-9][polledScvHealth[1]-3])
				{
					q.offer(polledScvHealth[0]-9);
					q.offer(polledScvHealth[1]-3);
					q.offer(nowCnt+1);
					visit[polledScvHealth[0]-9][polledScvHealth[1]-3] = true;
				}
			}
			if(polledScvHealth[0]-3>0 || polledScvHealth[1]-9>0)
			{
				System.out.println(polledScvHealth[0]+" "+polledScvHealth[1]+"zzzzz");
				if(polledScvHealth[0]-3<=0 && polledScvHealth[1]-9<=0)
				{
					break Loop;
				}
				if(polledScvHealth[0]-3<=0)
				{
					polledScvHealth[0] = 3;
				}
				if(polledScvHealth[1]-9<=0)
				{
					polledScvHealth[1] = 9;
				}
				if(!visit[polledScvHealth[0]-3][polledScvHealth[1]-9])
				{
					q.offer(polledScvHealth[0]-3);
					q.offer(polledScvHealth[1]-9);
					q.offer(nowCnt+1);
					visit[polledScvHealth[0]-3][polledScvHealth[1]-9] = true;
				}
			}
		}
		return nowCnt;
	}
	
//	public static void attackThree(int [] scvHealth, int maxHealth)
//	{
//		boolean [][][] visit = new boolean [maxHealth][maxHealth][maxHealth];
//		Queue<Integer> q = new LinkedList<Integer>();
//		for(int i=0; i<num; i++)
//		{
//			q.offer(scvHealth[i]);
//		}
//		while(!q.isEmpty())
//		{
//			int [] polledScvHealth = new int [num];
//			for(int i=0; i<num; i++)
//				polledScvHealth[i] = q.poll();
//			if(num == 2)
//			{
//				
//			}
//			else
//			{
//				
//			}
//		}
//	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int [] scvHealth = new int [num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int maxHealth = Integer.MIN_VALUE;
		for(int i=0; i<num; i++)
		{
			scvHealth[i] = Integer.parseInt(st.nextToken());
			maxHealth = Math.max(maxHealth, scvHealth[i]);
		}
		int ans = 0;
		if(num == 1)
		{
			ans = maxHealth / 9 + 1;
			if(maxHealth % 9 == 0)
				ans = ans - 1;
		}
		if(num == 2)
		{
			ans = attackTwo(scvHealth, maxHealth);
		}
//		if(num == 3)
//		{
//			attackThree(scvHealth, maxHealth);
//		}
			System.out.println(ans);
	}

}
