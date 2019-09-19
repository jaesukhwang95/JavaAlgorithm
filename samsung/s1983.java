package baekjoon.samsung;
import java.io.*;
import java.util.*;

public class s1983 {
	public static int total(int mid, int last, int assignment)
	{
		return mid * 35 + last * 45 + assignment * 20;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int k = 1;
		while(t-->0)
		{
			int rank = 0;
			String grade;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			int [] arr = new int[num];
			for(int i=0; i<num ;i++)
			{
				st = new StringTokenizer(br.readLine());
				arr[i] = total(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			int ans = arr[idx-1];
			Arrays.sort(arr);
			for(int i=0; i<num ;i++)
			{
				if(ans == arr[i])
					rank = i;
			}
			if(0<= rank && rank < num/10)
			{
				grade = "D0";
			}
			else if(num/10<= rank && rank < num/10*2)
			{
				grade = "C-";
			}
			else if(num/10*2<= rank && rank < num/10*3)
			{
				grade = "C0";
			}
			else if(num/10*3<= rank && rank < num/10*4)
			{
				grade = "C+";
			}
			else if(num/10*4<= rank && rank < num/10*5)
			{
				grade = "B-";
			}
			else if(num/10*5<= rank && rank < num/10*6)
			{
				grade = "B0";
			}
			else if(num/10*6<= rank && rank < num/10*7)
			{
				grade = "B+";
			}
			else if(num/10*7<= rank && rank < num/10*8)
			{
				grade = "A-";
			}
			else if(num/10*8<= rank && rank < num/10*9)
			{
				grade = "A0";
			}
			else
			{
				grade = "A+";
			}
			sb.append("#").append(k).append(" ").append(grade).append("\n");
			k++;
		}
		bw.write(sb.toString());
		bw.close();
	}
}
