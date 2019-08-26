package baekjoon.dynamicprogramming;
import java.io.*;

public class b2011 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] d = new int[str.length()+3];
		d[0] = 1;
		d[1] = 1;
		if(str.charAt(0)-'0' == 0)
			d[1] = 0;
		for(int i=2; i<=str.length(); i++)
		{
			if(str.charAt(i-1)-'0'!=0)
			{
				d[i] += d[i-1]%1000000;
				if(10<=(Integer.parseInt(str.substring(i-2,i))) && 26>=(Integer.parseInt(str.substring(i-2,i))))
				{
					d[i] += d[i-2]%1000000;
				}
			}
			else
			{
				if(str.charAt(i-2)-'0'==1 || str.charAt(i-2)-'0'==2)
				{
					d[i] += d[i-2]%1000000; 
				}
			}
		}
		System.out.println(d[str.length()]%1000000);
	}
}