package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b12100 {
	
	public static int [][] arr;
	public static int n;
	public static ArrayList<Integer> ans = new ArrayList<Integer>();
	
	public static void moveLeft(int n)
	{
		for(int i=0; i<n; i++)
		{
			Queue<Integer> q = new LinkedList<Integer>();
			for(int j=0; j<n; j++)
			{
				if(arr[i][j] == 0)
					continue;
				else
					q.offer(arr[i][j]);
			}
			int cnt = 0;
			while(!q.isEmpty())
			{
				int num = q.poll();
				if(!q.isEmpty() && num == q.peek())
				{
					arr[i][cnt] = num*2;
					q.poll();
					cnt++;
				}
				else
				{
					arr[i][cnt] = num;
					cnt++;
				}
			}
			while(cnt<n)
			{
				arr[i][cnt] = 0;
				cnt++;
			}
		}
	}
	
	public static void moveRight(int n)
	{
		for(int i=0; i<n; i++)
		{
			Queue<Integer> q = new LinkedList<Integer>();
			for(int j=n-1; j>=0; j--)
			{
				if(arr[i][j] == 0)
					continue;
				else
					q.offer(arr[i][j]);
			}
			int cnt = n-1;
			while(!q.isEmpty())
			{
				int num = q.poll();
				if(!q.isEmpty() && num == q.peek())
				{
					arr[i][cnt] = num*2;
					q.poll();
					cnt--;
				}
				else
				{
					arr[i][cnt] = num;
					cnt--;
				}
			}
			while(cnt>=0)
			{
				arr[i][cnt] = 0;
				cnt--;
			}
		}
	}
	
	public static void moveUp(int n)
	{
		for(int i=0; i<n; i++)
		{
			Queue<Integer> q = new LinkedList<Integer>();
			for(int j=0; j<n; j++)
			{
				if(arr[j][i] == 0)
					continue;
				else
					q.offer(arr[j][i]);
			}
			int cnt = 0;
			while(!q.isEmpty())
			{
				int num = q.poll();
				if(!q.isEmpty() && num == q.peek())
				{
					arr[cnt][i] = num*2;
					q.poll();
					cnt++;
				}
				else
				{
					arr[cnt][i] = num;
					cnt++;
				}
			}
			while(cnt<n)
			{
				arr[cnt][i] = 0;
				cnt++;
			}
		}
	}
	
	public static void moveDown(int n)
	{
		for(int i=0; i<n; i++)
		{
			Queue<Integer> q = new LinkedList<Integer>();
			for(int j=n-1; j>=0; j--)
			{
				if(arr[j][i] == 0)
					continue;
				else
					q.offer(arr[j][i]);
			}
			int cnt = n-1;
			while(!q.isEmpty())
			{
				int num = q.poll();
				if(!q.isEmpty() && num == q.peek())
				{
					arr[cnt][i] = num*2;
					q.poll();
					cnt--;
				}
				else
				{
					arr[cnt][i] = num;
					cnt--;
				}
			}
			while(cnt>=0)
			{
				arr[cnt][i] = 0;
				cnt--;
			}
		}
	}
	
	public static void go(int idx)
	{
		if(idx == 5)
		{
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n ;i++)
			{
				for(int j=0; j<n; j++)
					max = Math.max(max, arr[i][j]);
			}
			ans.add(max);
			return;
		}
		else
		{
			int [][] tmp = new int [n][n];
			for(int i=0; i<n ;i++)
			{
				for(int j=0; j<n; j++)
					tmp[i][j] = arr[i][j];
			}
			moveLeft(n);
			go(idx+1);
			for(int i=0; i<n ;i++)
			{
				for(int j=0; j<n; j++)
					arr[i][j] = tmp[i][j];
			}
			moveRight(n);
			go(idx+1);
			for(int i=0; i<n ;i++)
			{
				for(int j=0; j<n; j++)
					arr[i][j] = tmp[i][j];
			}
			moveUp(n);
			go(idx+1);
			for(int i=0; i<n ;i++)
			{
				for(int j=0; j<n; j++)
					arr[i][j] = tmp[i][j];
			}
			moveDown(n);
			go(idx+1);
			for(int i=0; i<n ;i++)
			{
				for(int j=0; j<n; j++)
					arr[i][j] = tmp[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0);
		Collections.sort(ans);
		System.out.println(ans.get(ans.size()-1));
	}
}
