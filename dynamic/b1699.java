package baekjoon.dynamic;
import java.util.*;

public class b1699 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] d = new int[n+4];
		d[1]=1;
		d[2]=2;
		d[3]=3;
		d[4]=1;
		for(int i=5; i<=n ;i++)
		{
			int min = Integer.MAX_VALUE;
			for(int j=1; j*j<=i ;j++)
			{
				min = Math.min(d[i-j*j]+1, min);
			}
			d[i] = min;
		}
		System.out.println(d[n]);
		sc.close();
	}
}