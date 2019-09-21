package baekjoon.bruteForce;
import java.io.*;
import java.util.*;

public class b14889 {
	
	public static void swap(char [] arr, int a,int b)
	{
		char tmp;
		tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static String next_permutation(String str)
	{
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		int idx = len-1;
		int end = len-1;
		char [] arr = new char [len];
		arr = str.toCharArray();
		while(idx>=1 && arr[idx] <= arr[idx-1])
		{
			idx--;
		}
		if(idx == 0)
			return "-1";
		while(idx-1<len-1)
		{
			if(arr[idx-1]<arr[len-1])
			{
				swap(arr, idx-1, len-1);
				break;
			}
			len--;
		}
		while(idx<=end)
		{
			swap(arr, idx, end);
			end--;
			idx++;
		}
		for(int i=0; i<arr.length ;i++)
		sb.append(arr[i]);
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int [n][n];
		for(int i=0; i<n ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n ;j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder checkTeam = new StringBuilder();
		for(int i=0; i<n/2 ;i++)
		{
			checkTeam.append(0);
		}
		for(int i=n/2; i<n ;i++)
		{
			checkTeam.append(1);
		}
		String check = checkTeam.toString();
		int min = Integer.MAX_VALUE;
		int x1, x2, y1, y2, sum1, sum2;
		do {
			ArrayList<Integer> ATeam = new ArrayList<>();
			ArrayList<Integer> BTeam = new ArrayList<>();
			for(int i=0; i<check.length() ;i++)
			{
				if(check.charAt(i) == '0')
				{
					ATeam.add(i);
				}
				else
				{
					BTeam.add(i);
				}
			}
			sum1 = 0;
			sum2 = 0;
			for(int i=0; i<n/2; i++)
			{
				for(int j=i+1; j<n/2; j++)
				{
					x1 = ATeam.get(i);
					y1 = ATeam.get(j);
					x2 = BTeam.get(i);
					y2 = BTeam.get(j);
					sum1 += arr[x1][y1] + arr[y1][x1];
					sum2 += arr[x2][y2] + arr[y2][x2];
				}
			}
			min = Math.min(min, Math.abs(sum1-sum2));
			check = next_permutation(check);
		} while(!(check).equals("-1"));
		System.out.println(min);
	}

}
