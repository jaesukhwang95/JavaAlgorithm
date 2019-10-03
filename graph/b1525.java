package baekjoon.graph;
import java.util.*;
import java.io.*;

public class b1525 {
	
	public static int [] dx = {-1,1,0,0};
	public static int [] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start = 0;
		int tmp;
		for(int i=0; i<3 ;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3 ;j++)
			{
				tmp = Integer.parseInt(st.nextToken());
			    if (tmp == 0) {
                    tmp = 9;
                }
				start = start*10 + tmp;
			}
		}
		HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		dist.put(start, 0);
		q.offer(start);
		while(!q.isEmpty())
		{
			int g = q.poll();
			String digit =  String.valueOf(g);
			int z = digit.indexOf('9');
			int x = z/3;
			int y = z%3;
			for(int i=0; i<4 ;i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<3 && 0<=ny && ny<3)
				{
					StringBuilder sb = new StringBuilder(digit);
					char tmpChar = sb.charAt(x*3+y);
					sb.setCharAt(x*3+y, sb.charAt(nx*3+ny));
					sb.setCharAt(nx*3+ny, tmpChar);
					String result = sb.toString();
					if(!dist.containsKey(Integer.valueOf(result)))
					{
						dist.put(Integer.valueOf(result), dist.get(g)+1);
						q.offer(Integer.valueOf(result));
					}
				}
			}
		}
		if(dist.containsKey(123456789))
		{
			System.out.println(dist.get(123456789));
		}
		else
		{
			System.out.println(-1);
		}
	}
}
