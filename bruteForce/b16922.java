package baekjoon.bruteForce;

import java.io.*;
import java.util.*;

public class b16922 {
	public static int num;
	public static int ans;
	public static int [] digit = {1,5,10,50};
	public static HashSet<Integer> set = new HashSet<Integer>();
	public static void go(int idx, int cnt, int sum)
	{
		if(cnt == num)
		{
			if(!set.contains(sum))
			{
				ans++;
				set.add(sum);
			}
			return;
		}
		for(int i=idx; i<4 ;i++)
		{
			go(i, cnt+1, digit[i]+sum);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		ans = 0;
		go(0, 0, 0);
		System.out.println(ans);
	}
}
