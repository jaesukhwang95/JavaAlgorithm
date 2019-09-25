package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b14391 {
	
	static int n, m;
	static int cnt = 0;
	static char [][] s;
	static int [][] upDown;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	
	static void go(int idx)
	{
		if(idx==n*m)
		{
			boolean [][] visit = new boolean[n][m];
			ArrayList<String> all = new ArrayList<String>();
			cnt++;
			int k = 0;
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++)
				{
					upDown[i][j] = arr.get(k);
					k++;
				}
			}
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++)
				{
					if(!visit[i][j])
					{
						if(upDown[i][j] == 1)
						{
							k = j;
							String strUp = "";
							while(k<m && !visit[i][k] && upDown[i][k] == 1)
							{
								visit[i][k] = true;
								strUp = strUp + s[i][k];
							    k++;
							}
							all.add(strUp);
						}
						if(upDown[i][j] == 0)
						{
							k = i;
							String strDown = "";
							while(k<n && !visit[k][j] && upDown[k][j] == 0)
							{
								visit[k][j] = true;
								strDown = strDown + s[k][j];
							    k++;
							}
							all.add(strDown);
						}
					}
				}
			}
			int sum = 0;
			for(int i=0; i<all.size() ;i++)
			{
				sum = sum + Integer.parseInt(all.get(i));
			}
			ans.add(sum);
			return;
		}
		arr.add(1);
		go(idx+1);
		arr.remove(arr.size()-1);
		arr.add(0);
		go(idx+1);
		arr.remove(arr.size()-1);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());	
		m = Integer.parseInt(st.nextToken());
		s = new char [n][m];
		upDown = new int [n][m];

		for(int i=0; i<n; i++)
		{
			String str = br.readLine();
			for(int j=0; j<m; j++)
				s[i][j] = str.charAt(j);
		}
		go(0);
		Collections.sort(ans);
		System.out.println(ans.get(ans.size()-1));
	}
}
