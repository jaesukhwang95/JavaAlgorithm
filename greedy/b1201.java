package baekjoon.greedy;
import java.util.*;
import java.io.*;

public class b1201 {
	
	public static void reverseArray(int [] arr, int startIdx, int endIdx)
	{
		int temp = 0;
		while(startIdx<=endIdx)
		{
			temp = arr[startIdx];
			arr[startIdx] = arr[endIdx];
			arr[endIdx] = temp;
			startIdx++;
			endIdx--;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		if(m+k-1 > n || n > m*k)
		{
			System.out.println(-1);
		}
		else
		{
			int [] input = new int [n+1];
			for(int i=1; i<=n; i++)
			{
				input[i] = i;
			}
			reverseArray(input,1,k);
			int startIdx = k+1;
			int delta = (n-k) / (m-1);
			int endIdx = startIdx + delta-1;
			int groupCount = 0;
			while(groupCount <= m-3)
			{
				reverseArray(input, startIdx, endIdx);
				startIdx = endIdx+1;
				endIdx = startIdx+delta-1;
				groupCount++;
			}
			reverseArray(input, startIdx, n);
			for(int i=1; i<=n; i++)
			System.out.print(input[i]+" ");
			System.out.println();
		}
	}
}