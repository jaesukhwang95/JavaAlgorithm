package baekjoon.samsung.level3;
import java.util.*;
import java.io.*;

public class s1209 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int num=1; num<=10 ;num++)
		{
			int sum = Integer.MIN_VALUE;
			br.readLine();
			int [][] arr = new int [100][100];
			for(int i=0; i<100 ;i++)
			{
				int row = 0;
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100 ;j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
					row += arr[i][j];
				}
				sum = Math.max(sum, row);
			}	
			for(int i=0; i<100 ;i++)
			{
				int col = 0;
				for(int j=0; j<100 ;j++)
				{
					col += arr[j][i];
				}
				sum = Math.max(sum, col);
			}
			for(int i=0; i<2 ;i++)
			{
				int dig = 0;
				for(int j=0; j<100 ;j++)
				{
					dig += arr[j][j];
				}
				sum = Math.max(sum, dig);
			}
			sb.append("#").append(num).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}	
}
