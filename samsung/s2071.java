package baekjoon.samsung;
import java.io.*;

public class s2071 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int total = Integer.valueOf(br.readLine());
		int j = 1;
		while(total-->0)
		{
			double sum = 0;
			String[] str = br.readLine().split(" ");
			double[] arr = new double[str.length];
			for(int i=0; i<str.length ; i++)
			{
				arr[i] = Double.valueOf(str[i]);
			}
			for(int i=0; i<str.length ;i++)
			{
				sum += arr[i];
			}
			bw.write("#"+String.valueOf(j)+" "+String.valueOf(Math.round(sum/str.length))+"\n");
			j++;
		}
		br.close();
		bw.close();
	}
}
