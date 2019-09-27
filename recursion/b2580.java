package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b2580 {
	
	public static int[][] value = new int[10][10];
	public static boolean[][] col = new boolean[10][10];
	public static boolean[][] row = new boolean[10][10];
	public static boolean[][] square = new boolean[10][10];
	public static String ans;
	
	public static void go(int z)
	{
		if(z == 81)
		{
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9 ;i++)
			{
				for(int j=0; j<9; j++)
				{
					sb.append(value[i][j]).append(" ");
				}
				sb.append("\n");
			}
			ans = sb.toString();
		}
		int x = z/9;
		int y = z%9;
		if(value[x][y] == 0)
		{
			for(int i=1; i<=9 ;i++)
			{
				if(!col[y][i] && !row[x][i] &&!square[(x/3)*3+(y/3)][i])
				{
					value[x][y] = i;
					col[y][i] = true;
					row[x][i] = true;
					square[(x/3)*3+(y/3)][i] = true;
					go(z+1);
					value[x][y] = 0;
					col[y][i] = false;
					row[x][i] = false;
					square[(x/3)*3+(y/3)][i] = false;
				}				
			}
		}
		else
		{
			go(z+1);
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<9 ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++)
			{
				value[i][j] = Integer.parseInt(st.nextToken());
				row[i][value[i][j]] = true;
				col[j][value[i][j]] = true;
				square[(i/3)*3+(j/3)][value[i][j]] = true;
			}
		}
		go(0);
		bw.write(ans);
		bw.close();
	}
}
