package baekjoon.bruteForce;
import java.util.*;
import java.io.*;

public class b1339 {
	
	public static void swap(int[] arr, int i, int j)
	{
		int tmp;
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static int[] next_p(int [] arr)
	{
		int len = arr.length;
		int idx = len-1;
		int last = len-1;
		int end = len-1;
		while(idx>=1 && arr[idx] < arr[idx-1])
		{
			idx--;
		}
		if(idx == 0)
		{
			int [] nil = {};
			return nil;
		}
		while(idx-1<last)
		{
			if(arr[idx-1]<arr[last])
			{
				swap(arr, idx-1, last);
				break;
			}
			last--;
		}
		while(idx<end)
		{
			swap(arr, idx, end);
			idx++;
			end--;
		}
		return arr;
	}
	
	public static int [] alphabetToDigit = new int [91];
	
	public static int findMaxSum(int [] digitArr, Character [] charArr, String[] str)
	{
		int ans = Integer.MIN_VALUE;
		int sum;
		do
		{
			sum = 0;
			for(int i=0; i<digitArr.length ;i++)
			{
				alphabetToDigit[charArr[i]] = digitArr[i];
			}
			for(int i=0; i<str.length ;i++)
			{
				int len = str[i].length();
				int now = 0;
				for(int j=0; j<len ;j++)
				{
					now = alphabetToDigit[str[i].charAt(j)] + now*10;
				}
				sum += now;
			}
			ans = Math.max(ans, sum);
			digitArr = next_p(digitArr);
		}while(digitArr.length != 0);
		return ans;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<Character> set = new HashSet<>();
		String[] strArr = new String[n];
		for(int i=0; i<n ;i++)
		{
			strArr[i] = br.readLine();
			for(char e: strArr[i].toCharArray())
			{
				set.add(e);
			}
		}
		Character [] charArr = set.toArray(new Character[set.size()]);
		int [] digitArr = new int [charArr.length];
		for(int i=0;  i<digitArr.length ;i++)
		{
			digitArr[i] = 9-i;
		}
		Arrays.sort(digitArr);
		System.out.println(findMaxSum(digitArr, charArr, strArr));
	}
}
