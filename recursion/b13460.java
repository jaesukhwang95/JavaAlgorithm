package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b13460 {
	
	public static int up=0, down=1, left=2, right=3;
	public static int n, m;
	public static int redX, redY, blueX, blueY, holeX, holeY;
	public static char [][] arr;
	public static int redPosition = Integer.MAX_VALUE;	
	public static boolean [] dir = new boolean [4];
	
	public static class result{
		int x;
		int y;
		boolean hole;
		result(int x, int y, boolean hole)
		{
			this.x = x;
			this.y = y;
			this.hole = hole;
		}
	}
	
	public static result moveUp(int x, int y)
	{
		boolean signal = false;
		while(arr[x][y] != '#')
		{
			x--;
			if(arr[x][y] == 'O')
				signal = true;
		}
		return new result(x+1,y,signal);
	}
	
	public static result moveDown(int x, int y)
	{
		boolean signal = false;
		while(arr[x][y] != '#')
		{
			x++;
			if(arr[x][y] == 'O')
				signal = true;
		}
		return new result(x-1,y,signal);
	}
	
	public static result moveLeft(int x, int y)
	{
		boolean signal = false;
		while(arr[x][y] != '#')
		{
			y--;
			if(arr[x][y] == 'O')
				signal = true;
		}
		return new result(x,y+1,signal);
	}
	
	public static result moveRight(int x, int y)
	{
		boolean signal = false;
		while(arr[x][y] != '#')
		{
			y++;
			if(arr[x][y] == 'O')
				signal = true;
		}
		return new result(x,y-1,signal);
	}
	
	public static void go(int redX, int redY, int blueX, int blueY, int idx)
	{
		if(idx==11)
		{
			return;
		}
		if(idx==0)
		{
			for(int i=0; i<4 ;i++)
			{
				dir[i] = true;
				go(redX, redY, blueX, blueY, idx+1);
				dir[i] = false;
			}
		}
		for(int i=0; i<4 ;i++)
		{
			if(dir[i] == true)
			{
				if(i==up)
				{
					result resBlue = moveUp(blueX, blueY);
					result resRed = moveUp(redX, redY);
					if(resBlue.x == resRed.x && resBlue.y == resRed.y)
					{
						if(redX>blueX)
						{
							blueX = resBlue.x;
							blueY = resBlue.y;
							redX = resRed.x+1;
							redY = resRed.y;
							if(resBlue.hole == true && resRed.hole == true)
								return;
							else if(resRed.hole == true)
							{
								redPosition = Math.min(redPosition, idx);
								return;
							}
						}
						else
						{
							blueX = resBlue.x+1;
							blueY = resBlue.y;
							redX = resRed.x;
							redY = resRed.y;
							if(resBlue.hole == true && resRed.hole == true)
							{
								return;
							}
						}
						
					}
					else
					{
						blueX = resBlue.x;
						blueY = resBlue.y;
						redX = resRed.x;
						redY = resRed.y;
						if(resBlue.hole == true)
						{
							return;
						}
						if(resRed.hole == true)
						{
							redPosition = Math.min(redPosition, idx);
							return;
						}
					}
				}
				else if(i==down)
				{
					result resBlue = moveDown(blueX, blueY);
					result resRed = moveDown(redX, redY);
					if(resBlue.x == resRed.x && resBlue.y == resRed.y)
					{
						if(redX>blueX)
						{
							blueX = resBlue.x-1;
							blueY = resBlue.y;
							redX = resRed.x;
							redY = resRed.y;
							if(resBlue.hole == true && resRed.hole == true)
							{
								return;
							}
						}
						else
						{
							blueX = resBlue.x;
							blueY = resBlue.y;
							redX = resRed.x-1;
							redY = resRed.y;
							if(resBlue.hole == true && resRed.hole == true)
								return;
							else if(resRed.hole == true)
							{
								redPosition = Math.min(redPosition, idx);
								return;
							}
						}
					}
					else
					{
						blueX = resBlue.x;
						blueY = resBlue.y;
						redX = resRed.x;
						redY = resRed.y;
						if(resBlue.hole == true)
						{
							return;
						}
						if(resRed.hole == true)
						{
							redPosition = Math.min(redPosition, idx);
							return;
						}
					}
				}
				else if(i==left)
				{
					result resBlue = moveLeft(blueX, blueY);
					result resRed = moveLeft(redX, redY);
					if(resBlue.x == resRed.x && resBlue.y == resRed.y)
					{
						if(redY>blueY)
						{
							blueX = resBlue.x;
							blueY = resBlue.y;
							redX = resRed.x;
							redY = resRed.y+1;
							if(resBlue.hole == true && resRed.hole == true)
								return;
							else if(resRed.hole == true)
							{
								redPosition = Math.min(redPosition, idx);
								return;
							}
						}
						else
						{
							blueX = resBlue.x;
							blueY = resBlue.y+1;
							redX = resRed.x;
							redY = resRed.y;
							if(resBlue.hole == true && resRed.hole == true)
							{
								return;
							}
						}
					}
					else
					{
						blueX = resBlue.x;
						blueY = resBlue.y;
						redX = resRed.x;
						redY = resRed.y;
						if(resBlue.hole == true)
						{
							return;
						}
						if(resRed.hole == true)
						{
							redPosition = Math.min(redPosition, idx);
							return;
						}
					}
				}
				else
				{
					result resBlue = moveRight(blueX, blueY);
					result resRed = moveRight(redX, redY);
					if(resBlue.x == resRed.x && resBlue.y == resRed.y)
					{
						if(redY>blueY)
						{
							blueX = resBlue.x;
							blueY = resBlue.y-1;
							redX = resRed.x;
							redY = resRed.y;
							if(resBlue.hole == true && resRed.hole == true)
							{
								return;
							}
						}
						else
						{
							blueX = resBlue.x;
							blueY = resBlue.y;
							redX = resRed.x;
							redY = resRed.y-1;
							if(resBlue.hole == true && resRed.hole == true)
								return;
							else if(resRed.hole == true)
							{
								redPosition = Math.min(redPosition, idx);
								return;
							}
						}
					}
					else
					{
						blueX = resBlue.x;
						blueY = resBlue.y;
						redX = resRed.x;
						redY = resRed.y;
						if(resBlue.hole == true)
						{
							return;
						}
						if(resRed.hole == true)
						{
							redPosition = Math.min(redPosition, idx);
							return;
						}
					}
				}
			}
		}
		if(idx!=0)
		{
			if(dir[down] == true)
			{
				dir[down] = false;
				dir[left] = true;
				go(redX, redY, blueX, blueY, idx+1);
				dir[left] = false;
				dir[right] = true;
				go(redX, redY, blueX, blueY, idx+1);
				dir[right] = false;
			}
			else if(dir[right] == true)
			{
				dir[right] = false;
				dir[up] = true;
				go(redX, redY, blueX, blueY, idx+1);
				dir[up] = false;
				dir[down] = true;
				go(redX, redY, blueX, blueY, idx+1);
				dir[down] = false;
			}
			else if(dir[left] == true)
			{
				dir[left] = false;
				dir[up] = true;
				go(redX, redY, blueX, blueY, idx+1);
				dir[up] = false;
				dir[down] = true;
				go(redX, redY, blueX, blueY, idx+1);
				dir[down] = false;
			}
			else
			{
				dir[up] = false;
				dir[left] = true;
				go(redX, redY, blueX, blueY, idx+1);
				dir[left] = false;
				dir[right] = true;
				go(redX, redY, blueX, blueY, idx+1);
				dir[right] = false;
			}
		}
		
	}
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char [n][m];
		for(int i=0; i<n ;i++)
		{
			String str = br.readLine();
			for(int j=0; j<m ;j++)
			{
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'B')
				{
					blueX = i;
					blueY = j;
				}
				if(arr[i][j] == 'R')
				{
					redX = i;
					redY = j;
				}
				if(arr[i][j] == 'O')
				{
					holeX = i;
					holeY = j;
				}
			}
		}
		go(redX, redY, blueX, blueY, 0);
		if(redPosition >= 11)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(redPosition);
		}
	}
}