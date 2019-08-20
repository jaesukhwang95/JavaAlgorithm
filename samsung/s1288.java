package baekjoon.samsung;
import java.io.*;

public class s1288 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int total = Integer.valueOf(br.readLine());
		int k = 1;
		while(total-->0)
		{
			int[] digit = {0,0,0,0,0,0,0,0,0,0};
			int num = Integer.valueOf(br.readLine());
			int i = 1;
			while(true)
			{
				int sum = 0;
				{
					String str = String.valueOf(num*i);
					char[] arr = str.toCharArray();
					for(int j=0; j<arr.length ;j++)
					{
						digit[arr[j] - '0'] = 1;
					}
				}
				for(int j=0; j<10 ;j++)
				{
					sum += digit[j];
				}
				if(sum==10)
				{
					bw.write("#"+ String.valueOf(k) +" " + String.valueOf(i*num)+ "\n");
					k++;
					break;
				}
				i++;
			}
		}
		br.close();
		bw.close();
	}
}