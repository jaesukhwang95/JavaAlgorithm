package baekjoon.samsung;
import java.io.*;
import java.util.*;

public class s1974 {
	public static int validation(int[][] arr)
	{
		int sum = 0;
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				sum+= arr[i][j];
			}
			if(sum != 45)
			{
				return 0;
			}
			sum=0;
		}
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				sum+= arr[j][i];
			}
			if(sum != 45)
			{
				return 0;
			}
			sum=0;
		}
		for(int i=0;i<3; i=i+3)
			for(int j=0; j<3; j=j+3)
			{
				sum = sum +arr[i][j] +sum+arr[i][j+1] +sum+arr[i][j+2]
						  +sum+arr[i+1][j] +sum+arr[i+1][j+1] +sum+arr[i+1][j+2]
						  +sum+arr[i+2][j] +sum+arr[i+2][j+1] +sum+arr[i+2][j+2];
				if(sum != 45)
				{
					return 0;
				}
			}
		return 1;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int cnt = 1;
		while(total-->0)
		{
			int[][] arr = new int [9][9];
			for(int i=0; i<9; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = validation(arr);
			sb.append("#").append(cnt).append(" ").append(result).append("\n");
			cnt++;
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
