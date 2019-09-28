package baekjoon.samsung.level2;
import java.io.*;

public class s2005 {
	
	public static int [][] arr;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int k = 0;
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1][n+1];
			arr[1][1] = 1;
			
			for(int i=2; i<=n; i++)
			{
				arr[i][1] = 1;
				arr[i][i] = 1;
				for(int j=2; j<n ; j++)
				{
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				}
			}
			k++;
			sb.append("#").append(k).append("\n");
			for(int i=1; i<=n; i++)
			{
				for(int j=1; j<=i ; j++)
				{
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
