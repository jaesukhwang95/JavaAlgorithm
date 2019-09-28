package baekjoon.samsung.level2;
import java.io.*;

public class s1948 {
	public static int duration(int month, int day)
	{
		int duration = 0;
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
		for(int i=0; i<month-1; i++)
		{
			duration += days[i];
		}
		duration += day;
		return duration;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int j = 1;
		while(total-->0)
		{
			String[] str = br.readLine().split(" ");
			int[] arr = new int [str.length];
			for(int i=0; i<str.length; i++)
			{
				arr[i] = Integer.parseInt(str[i]);
			}
			int result = duration(arr[2], arr[3])- duration(arr[0], arr[1])+1;
			sb.append("#").append(j).append(" ").append(result).append("\n");
			j++;
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}	
}