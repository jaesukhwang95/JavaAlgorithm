package baekjoon.recursion;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class b14501 {
	
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public static void go(int [] day, int [] price, int sum, int idx)
	{
		if(idx == day.length)
		{
			arr.add(sum);
			return;
		}
		if(idx > day.length)
			return;
		go(day, price, sum+price[idx], idx+day[idx]);
		go(day, price, sum, idx+1);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int all = sc.nextInt();
		int [] day = new int [all];
		int [] price = new int [all]; 
		int i = 0;
		while(all-->0)
		{
			day[i] = sc.nextInt();
			price[i] = sc.nextInt();
			i++;
		}
		go(day, price, 0, 0);
		Collections.sort(arr);
		System.out.printf("%d\n", arr.get(arr.size()-1));
		sc.close();
		
	}
}
