package baekjoon.samsung.level2;
import java.io.*;

public class s1284 {
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int j = 1;
		while(total-->0)
		{
			String[] str = br.readLine().split(" ");
			int p = Integer.parseInt(str[0]);
			int q = Integer.parseInt(str[1]);
			int r = Integer.parseInt(str[2]);
			int s = Integer.parseInt(str[3]);
			int w = Integer.parseInt(str[4]);
			int money = Math.min(w*p, w>r ? q+(w-r)*s: q);
			sb.append("#").append(j).append(" ").append(money).append("\n");
			j++;
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}