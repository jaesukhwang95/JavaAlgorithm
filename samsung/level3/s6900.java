package baekjoon.samsung.level3;

import java.io.*;
import java.util.*;

public class s6900 {
	
	public static boolean win(String num, String lottery)
	{
		boolean signal = true;
		for(int i=0; i<num.length() ;i++)
		{
			if(num.charAt(i) != lottery.charAt(i) && num.charAt(i) != '*')
			{
				signal = false;
				break;
			}
		}
		return signal;
	}

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("/Users/mac/dev/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int num = 0; num < t; num++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String [] numList = new String[n];
			String [] lotteryList = new String[m];
			long sum = 0;
			int [] money = new int[n];
			for(int i=0; i<n ;i++)
			{
				st = new StringTokenizer(br.readLine());
				numList[i] = st.nextToken();
				money[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<m ;i++)
			{
				lotteryList[i] = br.readLine();
				for(int j=0; j<n; j++)
				{
					if(win(numList[j], lotteryList[i]))
						sum += money[j];
				}
			}
			sb.append("#").append(num + 1).append(" ").append(sum).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
//1
//4 4 N M

//N
//*******1 1
//******12 10
//66*66**3 1000
//87654320 1000000

//M
//87654320
//85288251
//48888812
//12345678
