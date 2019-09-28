package baekjoon.samsung.level2;
import java.util.*;
import java.io.*;

public class s1966 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int total = Integer.parseInt(br.readLine());
		int j = 1;
		while(total-->0)
		{
			br.readLine();
			String[] str = br.readLine().split(" ");
			int[] arr = new int[str.length];
			for(int i=0; i<str.length ; i++)
			{
				arr[i] = Integer.parseInt(str[i]);
			}
			Arrays.sort(arr);
			System.out.printf("#%d ", j);
			for(int i=0; i<arr.length; i++)
			System.out.printf("%d ", arr[i]);
			System.out.println();
			j++;
		}
		br.close();
		bw.close();
	}
}
