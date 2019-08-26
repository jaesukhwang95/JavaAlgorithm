package baekjoon.dynamicprogramming;
import java.util.*;

public class b1463 {
	public static int[] d;
	
	public static int go(int n) {
		d[1] = 0;
		for(int i=2; i<=n ;i++)
		{
			
			d[i] = d[i-1] + 1;
			if(i%3 == 0 && d[i] > d[i/3] + 1)
			{
				d[i] = d[i/3] + 1;
			}
			if(i%2 == 0 && d[i] > d[i/2] + 1)
			{
				d[i] = d[i/2] + 1;
			}
		}
		return d[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n+1];
		int result = go(n);
		System.out.println(result);
		sc.close();
	}
}
