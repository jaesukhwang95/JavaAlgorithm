package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s5162 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++)
		{
			int [] arr = new int [3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++)
			{
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int smallPrice = arr[0];
			if(arr[1]<arr[0])
				smallPrice = arr[1];
			int ans = arr[2] / smallPrice;
			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
