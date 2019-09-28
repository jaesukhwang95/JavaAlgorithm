package baekjoon.samsung.level2;
import java.io.*;

public class s1959 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		int k = 1;
		while(total-->0)
		{
			int max = Integer.MIN_VALUE;
			int sum = 0;
			br.readLine();
			String[] str1 = br.readLine().split(" ");
			int[] arr1 = new int[str1.length];
			for(int i=0; i<str1.length ; i++)
			{
				arr1[i] = Integer.parseInt(str1[i]);
			}
			String[] str2 = br.readLine().split(" ");
			int[] arr2 = new int[str2.length];
			for(int i=0; i<str2.length ; i++)
			{
				arr2[i] = Integer.parseInt(str2[i]);
			}
			if(str1.length >= str2.length)
			{
				for(int i=0; i<=str1.length-str2.length ; i++)
				{
					for(int j=i; j<i+str2.length ; j++)
					{
						sum += arr1[j] * arr2[j-i];
					}
					if(sum>max)
						max = sum;
					sum=0;
				}
			}
			else
			{
				for(int i=0; i<=str2.length-str1.length ; i++)
				{
					for(int j=i; j<i+str1.length ; j++)
					{
						sum += arr1[j-i] * arr2[j];
					}
					if(sum>max)
						max = sum;
					sum = 0;
				}
			}
			sb.append("#").append(k).append(" ").append(max).append("\n");
			k++;
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
