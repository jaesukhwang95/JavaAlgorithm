package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b1987 {
	
	static int r,c;
	static char [][] s;
	static int ans = Integer.MIN_VALUE;
	static int [] dx = {0,0,-1,1};
	static int [] dy = {1,-1,0,0};
	public static void go(boolean[] alpha, int x, int y, int cnt)
	{
		if(cnt>ans)
			ans = cnt;
		for(int i=0; i<4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<=nx && nx<r && 0<=ny && ny<c && !alpha[s[nx][ny]-'A'])
			{
				alpha[s[nx][ny]-'A'] = true;
				go(alpha, nx, ny, cnt+1);
				alpha[s[nx][ny]-'A'] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		s = new char[r][c];
		for(int i=0; i<r ;i++)
		{
			String str = br.readLine();
			for(int j=0; j<c; j++)
			{
				s[i][j] = str.charAt(j);
			}
		}
		boolean [] alpha = new boolean[26];
		alpha[s[0][0]-'A'] = true;
		go(alpha, 0, 0, 1);
	
		System.out.println(ans);
	}
}
