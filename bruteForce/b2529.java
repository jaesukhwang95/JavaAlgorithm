package baekjoon.bruteForce;
import java.util.*;
import java.io.*;

public class b2529 {
	
	public static boolean check(int a, int b, String str)
	{
		if(str.equals("<"))
		{
			if(a<b)	
				return true;
			else
				return false;
		}
		else
		{
			if(a>b)
				return true;
			else
				return false;
		}
	}
	
	public static void swap(int[] arr, int i, int j)
	{
		int tmp;
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static int[] next_p(int[] arr)
	{
		int last = arr.length - 1;
		int idx = last;
		int swpIdx = last;
		while(idx>=1 && arr[idx] < arr[idx-1])
		{
			idx--;
		}
		if(idx==0)
		{
			int [] zero = {};
			return zero;
		}
		while(idx<=swpIdx)
		{
			if(arr[idx-1]<arr[swpIdx])
			{
				swap(arr, idx-1, swpIdx);
				break;
			}
			swpIdx--;
		}
		int first = idx;
		while(first<last)
		{
			swap(arr, first, last);
			first++;
			last--;
		}
		return arr;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String [] op = new String[num];
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		for(int i=0; i<num ;i++)
 		{
 			op[i] = st.nextToken();
 		}
 		int [] bigNum = new int [num+1];
 		int [] smallNum = new int [num+1];
 		for(int i=0; i<=num ;i++)
 		{
 			bigNum[i] = 9-i;
 			smallNum[i] = i;
 		}
 		Arrays.sort(bigNum);
 		long max = Long.MIN_VALUE;
 		long min = Long.MAX_VALUE;
		do
		{
			StringBuilder sb = new StringBuilder();
			boolean bigSignal = true;
			for(int i=0; i<num; i++)
			{
				if(!check(bigNum[i], bigNum[i+1], op[i]))
				{
					bigSignal = false;
					break;
				}
			}
			if(bigSignal)
			{
				for(int j=0; j<=num ;j++)
				sb.append(bigNum[j]);
				max = Math.max(max, Long.parseLong(sb.toString()));
			}
			bigNum = next_p(bigNum);
		} while(bigNum.length != 0);
		do
		{
			StringBuilder sb = new StringBuilder();
			boolean smallSignal = true;
			for(int i=0; i<num; i++)
			{
				if(!check(smallNum[i], smallNum[i+1], op[i]))
				{
					smallSignal = false;
					break;
				}
			}
			if(smallSignal)
			{
				for(int j=0; j<=num ;j++)
				sb.append(smallNum[j]);
				min = Math.min(min, Long.parseLong(sb.toString()));
			}
			smallNum = next_p(smallNum);
		} while(smallNum.length != 0);
		System.out.println(max);
		if(String.valueOf(min).length() != num+1)
			System.out.print("0"+min);
		else
			System.out.print(min);
		System.out.println();
	}
}
