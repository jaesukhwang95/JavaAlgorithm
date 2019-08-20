package baekjoon.samsung;
import java.util.*;

public class s2025 {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		for(int i=num; i>0 ;i--)
		{
			sum += i;
		}
		System.out.printf("%d\n", sum);
		sc.close();
	}
}
