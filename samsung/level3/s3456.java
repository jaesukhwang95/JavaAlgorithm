package baekjoon.samsung.level3;
import java.util.*;
import java.io.*;

public class s3456 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int num=1; num<=n ;num++)
		{
			int [] arr = new int[3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<3; i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Loop: for(int i=0; i<3 ;i++)
			{
				for(int j=i+1; j<3; j++)
				{
					if(arr[i] == arr[j])
					{
						sb.append("#").append(num).append(" ").append(arr[3-i-j]).append("\n");
						break Loop;
					}
				}
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
