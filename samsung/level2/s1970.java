package baekjoon.samsung.level2;
import java.io.*;

public class s1970 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int j = 1;
		while(total-->0)
		{
			int[] arr = new int[8];
			int money = Integer.parseInt(br.readLine());
			money -= money%10;
			if(money >= 50000)
			{
				arr[0] = money/50000;
				money -= arr[0] * 50000;
			}
			if(money >= 10000)
			{
				arr[1] = money/10000;
				money -= arr[1] * 10000;
			}
			if(money >= 5000)	
			{
				arr[2] = money/5000;
				money -= arr[2] * 5000;
			}
			if(money >= 1000)
			{
				arr[3] = money/1000;
				money -= arr[3] * 1000;
			}
			if(money >= 500)
			{
				arr[4] = money/500;
				money -= arr[4] * 500;
			}
			if(money >= 100)
			{
				arr[5] = money/100;
				money -= arr[5] * 100;
			}
			if(money >= 50)
			{
				arr[6] = money/50;
				money -= arr[6] * 50;
			}
			{
				arr[7] = money/10;
				money -= arr[7] * 10;
			}
			System.out.printf("#%d\n", j);
			for(int i=0; i<8; i++)
			System.out.printf("%d ", arr[i]);
			System.out.println();
			j++;
		}
		br.close();
	}
}