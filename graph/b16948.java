package baekjoon.graph;
import java.io.*;
import java.util.*;

public class b16948 {
	
	public static class Position{
		int r;
		int c;
		int num;
		Position(int x, int y, int num)
		{
			this.r = x;
			this.c = y;
			this.num = num;
		}
	}
	
	public static int [] dx = {-2,-2,0,0,2,2};
	public static int [] dy = {-1,1,-2,2,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		boolean [][] visit = new boolean[n][n];
		Queue<Position> q = new LinkedList<Position>();
		q.offer(new Position(r1, c1, 0));
		visit[r1][c1] = true;
		while(!q.isEmpty())
		{
			Position p = q.poll();
			for(int i=0; i<6; i++)
			{
				int nr = p.r+dx[i];
				int nc = p.c+dy[i];
				if(nr>=0 && nr<n && nc>=0 && nc<n && !visit[nr][nc])
				{
					if(nr==r2 && nc ==c2)
					{
						System.out.println(p.num+1);
						System.exit(0);
					}
					else
					{
						visit[nr][nc] = true;
						q.offer(new Position(nr, nc, p.num+1));
					}
				}
			}
		}
		System.out.println(-1);
	}
}