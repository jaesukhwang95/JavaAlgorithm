package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b14889 {
	
	static int ans = Integer.MAX_VALUE;
	static int num = 0;
	static int[][] s;
	
	public static void go(int idx, ArrayList<Integer> start, ArrayList<Integer> link)
	{
		if(idx==num)
		{
			if(start.size() != num/2 && link.size() != num/2)
				return;
			int startStat = 0;
			int linkStat = 0;
			for(int i=0; i<num/2 ;i++)
			{
				for(int j=i+1; j<num/2 ;j++)
				{
					startStat = startStat + s[start.get(i)][start.get(j)] + s[start.get(j)][start.get(i)];
					linkStat = linkStat + s[link.get(i)][link.get(j)] + s[link.get(j)][link.get(i)] ;
				}
			}
			ans = Math.min(Math.abs(startStat-linkStat), ans);
			return;
		}
		start.add(idx);
		go(idx+1, start, link);
		start.remove(start.size()-1);
		link.add(idx);
		go(idx+1, start, link);
		link.remove(link.size()-1);
	}
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		s = new int [num][num];
		for(int i=0; i<num ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<num; j++)
			{
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<Integer> link = new ArrayList<Integer>();
		go(0, start, link);
		System.out.println(ans);
	}
}
