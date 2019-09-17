package baekjoon.dataStructure;
import java.io.*;

public class b10989 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = 0;
		int[] arr = new int [10000001];
		for(int i=0; i<n; i++)
		{
			m = Integer.parseInt(br.readLine());
			arr[m] += 1;
		}
		for(int i=1; i<10000001; i++)
		{
			if(arr[i] > 0)
			{
				for(int j=0; j<arr[i] ;j++)
				{
					sb.append(i).append("\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.close();
	}
}