package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b2751 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<n; i++)
		{
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		for(int i=0; i<n; i++)
		{
			sb.append(arr.get(i)).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}

//ArrayList를 사용하여 Collections.sort를 사용하는 것이 Array를 사용하여 Arrays.sort를 사용하는 것보다 훨씬 빠름.
//Arrays.sort는 비교값이 primitive값일 경우 merge sort가 아닌 quick sort를 사용함.