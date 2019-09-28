package baekjoon.samsung.level2;
import java.io.*;

public class s1984 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int j = 1;
		while(total-->0)
		{
			int sum = 0;
			String[] str = br.readLine().split(" ");
			int[] arr = new int[10];
			for(int i=0; i<10; i++)
			{
				arr[i] = Integer.parseInt(str[i]);
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i=0; i<10; i++)
			{
				if(arr[i] > max)
					max = arr[i];
				if(arr[i] < min)
					min = arr[i];
				sum += arr[i];
			}
			sum -= max + min;
			double avg = Math.round(Double.valueOf(sum)/8);
			int result = (int) avg;
			sb.append("#").append(j).append(" ").append(result).append("\n");
			j++;
		}
		bw.write(sb.toString());
	bw.close();
	br.close();
	}
}
