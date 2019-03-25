package baekjoon.recursion;
import java.util.Scanner;
import java.util.ArrayList;

public class b6603 {
	public static ArrayList<Integer> sol = new ArrayList<Integer>();
	public static void go (int [] arr, int idx, int cnt)
	{
		if(cnt ==6)
		{
			for(int i : sol)
				System.out.printf("%d ", i);
			System.out.println();
			return;
		}
		if(idx == arr.length)
			return;
		sol.add(arr[idx]);
		go(arr, idx+1, cnt+1);
		sol.remove(sol.size()-1);
		go(arr, idx+1, cnt);
		
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int num = sc.nextInt();
			if(num==0)
				sc.close();
				System.exit(0);
			int [] arr = new int[num];
			
			for(int i=0;i<num ;i++)
				arr[i] = sc.nextInt();
			go(arr, 0, 0);
			System.out.println();
		}
		
	}
}
