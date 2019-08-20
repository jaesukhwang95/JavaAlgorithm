package baekjoon.samsung;
import java.io.*;

public class s1945 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int total = Integer.valueOf(br.readLine());
		int j = 1;
		while(total-->0)
		{
			double number = Double.valueOf(br.readLine());
			for(int a=0; a<25 ;a++)
				for(int b=0; b<16 ;b++)
					for(int c=0; c<12 ;c++)
						for(int d=0; d<10 ;d++)
							for(int e=0; e<8 ;e++)
								if(Math.pow(2, a) * Math.pow(3, b) * Math.pow(5, c) * Math.pow(7, d) * Math.pow(11, e) == number)
										bw.write("#"+String.valueOf(j)+" "+ String.valueOf(a)+" "+String.valueOf(b)+" "+String.valueOf(c)+" "+String.valueOf(d)+" "+String.valueOf(e)+"\n");
			j++;
		}
		br.close();
		bw.close();
	}
}