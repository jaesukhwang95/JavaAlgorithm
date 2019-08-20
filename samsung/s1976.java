package baekjoon.samsung;
import java.io.*;

public class s1976 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int cnt = 1;
		while(total-->0)
		{
			String[] str = br.readLine().split(" ");
			int[] arr = new int[str.length];
			for(int i=0; i<str.length ;i++)
			{
				arr[i] = Integer.parseInt(str[i]);
			}
			int hour = arr[0] + arr[2];
			int minute = arr[1] + arr[3];
			if(minute>=60)
			{
				minute -= 60;
				hour += 1;
			}
			if(hour>12)
				hour -= 12;
			sb.append("#").append(cnt).append(" ").append(hour).append(" ").append(minute).append("\n");
			cnt++;
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
