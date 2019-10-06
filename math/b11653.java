package baekjoon.math;
import java.util.*;
import java.io.*;

public class b11653 {
	public static void main(String[] args) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=2; i*i<=num; i++)
		{
			if(num%i == 0)
			{
				num = num/i;
				sb.append(i).append("\n");
				i--;
			}
		}
		if(num>1)
			sb.append(num).append("\n");
		bw.write(sb.toString());
		bw.close();
		sc.close();
	}
}
