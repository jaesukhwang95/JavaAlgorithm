package baekjoon.samsung;
import java.io.*;

public class s8338 {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		int j = 1;
		while(t-->0)
		{
			int num = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] arr = new int[str.length];
			for(int i=0; i<num; i++)
			{
				arr[i] = Integer.parseInt(str[i]);
			}
			int max = arr[0];
			if(num>1)
			{
				max = arr[0] + arr[1] > arr[0] * arr[1] ? arr[0] + arr[1] : arr[0] * arr[1];
				for(int i=2; i<num ;i++)
				{
					max = max + arr[i] > max * arr[i] ? max + arr[i] : max * arr[i];
				}	
			}
			bw.write("#"+String.valueOf(j)+" "+String.valueOf(max)+"\n");
			j++;
		}
		br.close();
		bw.close();
	}
}
