package baekjoon.greedy;
import java.util.*;
import java.io.*;

public class b2873 {
	
	public static boolean check(int cnt, int r,int c)
	{
		if(cnt == (r*c-1))
			return true;
		return false;
	}
	
	public static void oddRow(StringBuilder sb, int r, int c)
	{
		int cnt = 0;
		Loop: while(true)
		{
			for(int i=0; i<c-1; i++)
			{
				sb.append('R');
				cnt++;
				if(check(cnt, r, c))
					break Loop;
			}
			sb.append('D');
			cnt++;
			if(check(cnt, r, c))
				break Loop;
			for(int i=0; i<c-1; i++)
			{
				sb.append('L');
				cnt++;
				if(check(cnt, r, c))
					break Loop;
			}
			sb.append('D');
			cnt++;
			if(check(cnt, r, c))
				break Loop;
		}
	}
	
	public static void oddColumn(StringBuilder sb, int r, int c)
	{
		int cnt = 0;
		Loop: while(true)
		{
			for(int i=0; i<r-1; i++)
			{
				sb.append('D');
				cnt++;
				if(check(cnt, r, c))
					break Loop;
			}
			sb.append('R');
			cnt++;
			if(check(cnt, r, c))
				break Loop;
			for(int i=0; i<r-1; i++)
			{
				sb.append('U');
				cnt++;
				if(check(cnt, r, c))
					break Loop;
			}
			sb.append('R');
			cnt++;
			if(check(cnt, r, c))
				break Loop;
		}
	}
	
	public static StringBuilder evenRowEvenColumn(int r, int c, int minX, int minY)
	{
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();

		boolean signal1 = false;
		boolean signal2 = false;
		boolean signal3 = false;
		boolean signal4 = false;
		
		int row1 = 0;
		int row2 = r-1;
		int col1 = 0;
		int col2 = c-1;
		while(signal1 && signal2)
		{
			if(!signal1)
			{
				if(row1==minX || row1==minX+1)
				{
					signal1 = true;
				}
				else
				{
					for(int i=0; i<c-1; i++)
					{
						sb1.append('R');
					}
					sb1.append('D');
					for(int i=0; i<c-1; i++)
					{
						sb1.append('L');
					}
					sb1.append('D');
					row1 = row1+2;
				}
			}
			if(!signal2)
			{
				if(row2==minX || row2==minX+1)
				{
					signal2 = true;
				}
				else
				{
					for(int i=0; i<c-1; i++)
					{
						sb2.append('R');
					}
					sb2.append('D');
					for(int i=0; i<c-1; i++)
					{
						sb2.append('L');
					}
					sb2.append('D');
					row2 = row2-2;
				}
			}
		}
		
		while(signal3 && signal4)
		{
			if(!signal3)
			{
				if(col1==minY || col1==minY+1)
				{
					signal3 = true;
				}
				else
				{
					sb4.append("DRUR");
					col1 = col1+2;
				}
			}
			if(!signal4)
			{
				if(col2==minY || col2==minY+1)
				{
					signal4 = true;
				}
				else
				{
					sb5.append("RURD");
					col1 = col1-2;
				}
			}
		}
		
		return sb;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		int minX = 0;
		int minY = 0;
		int [][] space = new int [r][c];
		for(int i=0; i<r; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++)
				space[i][j] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		if(r%2==1)
		{
			oddRow(sb, r, c);
		}
		else if(c%2==1)
		{
			oddColumn(sb, r,c);
		}
		else
		{
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
				{
					if( ((i+j)%2==1) && (min > space[i][j]))
					{
						minX = i;
						minY = j;
					}
				}
			evenRowEvenColumn(r, c, minX, minY);
		}
		System.out.println(sb.toString());
	}
}
