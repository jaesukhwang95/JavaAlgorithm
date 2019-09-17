package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b11650 {
	
	public static class Point implements Comparable<Point>{
		private int x;
		private int y;
		Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point a)
		{
			if(this.x < a.x)
				return -1;
			else if(this.x == a.x)
			{
				if(this.y < a.y)
					return -1;
				else if(this.y == a.y)
					return 0;
				else
					return 1;
			}
			else
			{
				return 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> arr = new ArrayList<Point>();
		for(int i=0; i<n ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Point(x,y));
		}
		Collections.sort(arr);
		for(int i=0; i<n ;i++)
		{
			sb.append(arr.get(i).x).append(" ").append(arr.get(i).y).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
