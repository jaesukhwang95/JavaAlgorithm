package baekjoon.dataStructure;
import java.io.*;

public class b10820 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			 String str = br.readLine();
	         if (str == null) break;
			 int[] arr = new int[4];
				 for(int i=0; i<str.length(); i++)
				 {	
					 int num = Integer.valueOf(str.charAt(i));
					 if(65<=num && num<=90)
					 {
						 arr[1] += 1;
					 }
					 else if(97<=num && num<=122)
					 {
						 arr[0] += 1;
					 }
					 else if(48<=num && num<=57)
					 {
						 arr[2] += 1;
					 }
					 else if(num==32)
					 {
						 arr[3] += 1;
					 }
				 }	
				 sb.append(arr[0]).append(" ").append(arr[1]).append(" ").append(arr[2]).append(" ").append(arr[3]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}