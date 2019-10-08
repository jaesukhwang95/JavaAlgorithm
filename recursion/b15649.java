package baekjoon.recursion;
import java.util.*;

public class b15649 {
	
	public static int m;
	public static int n;
	public static int [] arr;
	public static boolean [] visit;
	
	public static void go(int idx)
	{
		if(idx == n)
		{
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<idx ;i++)
			{
				sb.append(arr[i]).append(" ");
			}
			System.out.println(sb.toString());
			return;
		}
		for(int i=1; i<=m ;i++)
		{
			if(!visit[i])
			{
				visit[i] = true;
				arr[idx] = i;
				idx++;
				go(idx);
				idx--;
				visit[i] = false;
				arr[idx] = 0;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String [] str = sc.nextLine().split(" ");
		m = Integer.parseInt(str[0]);
		n = Integer.parseInt(str[1]);
		arr = new int [n];
		visit = new boolean [m+1];
		go(0);
		sc.close();
	}
}
