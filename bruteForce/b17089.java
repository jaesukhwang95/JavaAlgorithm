package baekjoon.bruteForce;
import java.util.*;
import java.io.*;

public class b17089 {
	
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y)
		{
			this.x =x;
			this.y =y;
		}
		@Override
		public int hashCode() {
			return x + y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Pair) {
				Pair p = (Pair) obj;
				return (p.x == (x)) && (p.y == (y));
			} else {
				return false;
			}
		}
	}
	
	public static void findMinimum(boolean[][] friend, int n, int[] indexList)
	{
		int cnt = 0;
		for(int j: indexList)
		{
			for(int i=1; i<=n; i++)
			{
				if(friend[j+1][i])
				{
					cnt++;
				}
			}
		}
		min = Math.min(min, cnt-6);
	}
	
	public static void chooseThree(int[] indexList, int n, int r, int index, int target, boolean[][] friend) {
        if(r==0){
        	if(friend[indexList[0]+1][indexList[1]+1] && friend[indexList[1]+1][indexList[2]+1] && friend[indexList[0]+1][indexList[2]+1])
        	{
                findMinimum(friend, n, indexList);
        	}
            return;
        }
        if(target == n)
        	return;    
        indexList[index] = target;
        chooseThree(indexList, n, r-1, index+1, target+1,friend);
        chooseThree(indexList, n, r, index, target+1,friend);
    }
	
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean [][] friend = new boolean[n+1][n+1];
		for(int i=0; i<m; i++)
		{
			st =  new StringTokenizer(br.readLine());
			int index1 = Integer.parseInt(st.nextToken());
			int index2 = Integer.parseInt(st.nextToken());
			friend[index1][index2] = true;
			friend[index2][index1] = true;
		}
        int[] indexList = new int[3];
        chooseThree(indexList, n, 3, 0, 0,friend);
        if(min == 2147483647)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(min);
        }
	}
}
