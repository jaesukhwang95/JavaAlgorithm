package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s6692 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t ;i++)
		{
			int n = Integer.parseInt(br.readLine());
			float sum = 0;
			for(int j=0; j<n; j++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				sum += Float.parseFloat(st.nextToken()) * Float.parseFloat(st.nextToken());
			}
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
