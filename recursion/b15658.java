package baekjoon.recursion;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class b15658 {
	
	public static ArrayList<Integer> sol = new ArrayList<Integer>();
	
	public static void go(int add, int min, int mul, int div, int [] arr,
			int [] op, int idx, int res)
	{
		if(idx==arr.length-1)
		{
			if(op[0]>=add && op[1]>=min && op[2]>=mul && op[3]>=div)
			{
				sol.add(res);
				return;
			}
			else
				return;
		}
		if(add<0 || min<0 || mul<0 || div<0)
			return;
		go(add+1,min,mul,div,arr,op,idx+1,res+arr[idx+1]);
		go(add,min+1,mul,div,arr,op,idx+1,res-arr[idx+1]);
		go(add,min,mul+1,div,arr,op,idx+1,res*arr[idx+1]);
		go(add,min,mul,div+1,arr,op,idx+1,res/arr[idx+1]);
	}
	

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int all = sc.nextInt();
		int [] num = new int [all];
		int [] op = new int [4];
		for(int i=0; i<all ;i++)
			num[i] = sc.nextInt();
		for(int i=0; i<4 ;i++)
			op[i] = sc.nextInt();
		go(0,0,0,0,num,op,0,num[0]);
		Collections.sort(sol);
		if(sol.size() == 1)
		{
			System.out.printf("%d\n", sol.get(0));
			System.out.printf("%d\n", sol.get(0));
		}
		else
		{
			System.out.printf("%d\n", sol.get(sol.size()-1));
			System.out.printf("%d\n", sol.get(0));
		}
		sc.close();
	}
}
