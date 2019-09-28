package baekjoon.samsung.level2;
import java.io.*;

public class s1954 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int cnt = 1;
		while(total-->0)
		{
			int j=1;
			int n = Integer.parseInt(br.readLine());
			int columnStart = 0;
			int columnEnd = n-1;
			int rowStart = 0;
			int rowEnd = n-1;
			int[][] arr = new int[n][n];
			while(true)
			{
				for(int i=rowStart; i<rowEnd+1; i++)
				{
					arr[columnStart][i] = j;
					j++;
				}
				for(int i=columnStart+1; i<columnEnd+1; i++)
				{
					arr[i][rowEnd] = j;
					j++;
				}
				for(int i=rowEnd-1; i>=rowStart; i--)
				{
					arr[columnEnd][i] = j;
					j++;
				}
				for(int i=columnEnd-1; i>=columnStart+1; i--)
				{
					arr[i][rowStart] = j;
					j++;
				}
				columnStart += 1;
				columnEnd -= 1;
				rowStart += 1;
				rowEnd -= 1;
				if(columnStart>columnEnd && rowStart>rowEnd)
					break;
			}
			sb.append("#").append(cnt).append("\n");
			for(int i=0; i<n ; i++)
			{
				for(int k=0; k<n ;k++)
				{
					sb.append(arr[i][k]).append(" ");
				}
				sb.append("\n");
				
			}
			cnt++;
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
