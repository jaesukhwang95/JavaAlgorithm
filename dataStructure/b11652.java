package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b11652 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		int max = 0;
		long maxKey = 0;
		int temp = 0;
		while(n-->0)
		{
			long num = Long.parseLong(br.readLine());
			if(map.containsKey(num))
			{
				temp = map.remove(num)+1;
				map.put(num, temp);
				if(temp>max)
				{
					max = temp;
					maxKey = num;
				}
				else if(temp==max)
				{
					maxKey = num > maxKey ? maxKey : num;
				}
			}
			else
			{
				map.put(num, 1);
				if(map.size() == 1)
				{
					max = 1;
					maxKey = num;
				}
				else if(max == 1)
				{
					maxKey = num > maxKey ? maxKey : num;
				}
			}
		}
		System.out.println(maxKey);
	}
}
