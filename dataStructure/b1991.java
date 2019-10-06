package baekjoon.dataStructure;
import java.util.*;
import java.io.*;

public class b1991 {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static int [][] arr;
	
	public static void preorder(int p)
	{
		if(p == -1)
			return;
		sb.append((char)(p+'A'));
		preorder(arr[p][0]);
		preorder(arr[p][1]);
	}
	
	public static void inorder(int p)
	{
		if(p == -1)
			return;
		inorder(arr[p][0]);
		sb.append((char)(p+'A'));
		inorder(arr[p][1]);
	}
	
	public static void postorder(int p)
	{
		if(p == -1)
			return;
		postorder(arr[p][0]);
		postorder(arr[p][1]);
		sb.append((char)(p+'A'));
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int [26][2];
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p =	st.nextToken().charAt(0) - 'A';
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			if(l != '.')
			{
				arr[p][0] = l - 'A';
			}
			else
			{
				arr[p][0] = -1;
			}
			if(r != '.')
			{
				arr[p][1] = r - 'A';
			}
			else
			{
				arr[p][1] = -1;
			}
		}
		preorder(0);
		System.out.println(sb.toString());
		sb = new StringBuilder();
		inorder(0);
		System.out.println(sb.toString());
		sb = new StringBuilder();
		postorder(0);
		System.out.println(sb.toString());
	}
}
