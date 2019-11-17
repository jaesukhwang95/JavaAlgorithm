package baekjoon.recursion;
import java.io.*;

public class b11729 {
	
	public static void solve(int n, int x, int y, StringBuilder sb)
	{
		if(n==0)
			return;
		solve(n-1, x, 6-x-y, sb);
			sb.append(x+" "+y+"\n");
		solve(n-1, 6-x-y, y, sb);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		sb.append(((int)Math.pow(2, n)-1+"\n"));
		solve(n, 1, 3, sb);
		System.out.print(sb.toString());
	}
}