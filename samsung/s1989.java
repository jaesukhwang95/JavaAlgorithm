package baekjoon.samsung;
import java.io.*;

public class s1989 {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int total = Integer.valueOf(br.readLine());
		int j = 1;
		while(total-->0)
		{
			int signal = 1;
			String str = br.readLine();
			char[] arr = str.toCharArray();
			for(int i=0; i<arr.length/2; i++)
			{
				if(arr[i] != arr[arr.length-i-1])
				{
					signal = 0;
					break;
				}
			}
			bw.write("#"+ String.valueOf(j)+ " " + String.valueOf(signal)+"\n");	
			j++;
		}
		br.close();
		bw.close();
	}
}
