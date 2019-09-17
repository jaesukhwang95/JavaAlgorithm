package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b11004 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
		{
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		System.out.println(arr.get(k-1));
	}
}
