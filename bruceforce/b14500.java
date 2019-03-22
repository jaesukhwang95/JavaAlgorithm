package baekjoon.bruceforce;
import java.util.Scanner;

public class b14500 {

	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int [][] arr = new int [row][col];
		for(int i=0; i<row; i++)
			for(int j=0; j<col ;j++)
				arr[i][j] = sc.nextInt();
		int max = Integer.MIN_VALUE;
		
		int sum = 0;
		
		for(int i=0; i<row; i++)
			for(int j=0; j<col-3 ;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i][j+1] + arr[i][j+2]+ arr[i][j+3];
					if(sum>max)
						max =sum;
				}
	
		for(int i=0; i<row-3; i++)
			for(int j=0; j<col;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i+1][j] + arr[i+2][j]+ arr[i+3][j];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-1; i++)
			for(int j=0; j<col-1;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i+1][j] + arr[i][j+1]+ arr[i+1][j+1];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-2; i++)
			for(int j=0; j<col-1;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i+1][j] + arr[i+2][j]+ arr[i+2][j+1];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-1; i++)
			for(int j=0; j<col-2;j++)
				{
					sum = 0;
					sum = sum + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2]+ arr[i][j+2];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-2; i++)
			for(int j=0; j<col-1;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i][j+1] + arr[i+1][j+1]+ arr[i+2][j+1];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-1; i++)
			for(int j=0; j<col-2;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i][j+1] + arr[i][j+2]+ arr[i+1][j];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-2; i++)
			for(int j=0; j<col-1;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i+1][j] + arr[i+1][j+1]+ arr[i+2][j+1];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-1; i++)
			for(int j=0; j<col-2;j++)
				{
					sum = 0;
					sum = sum + arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1]+ arr[i][j+2];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-2; i++)
			for(int j=0; j<col-1;j++)
				{
					sum = 0;
					sum = sum + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j]+ arr[i+2][j];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-1; i++)
			for(int j=0; j<col-2;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i][j+1] + arr[i+1][j+1]+ arr[i+1][j+2];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-2; i++)
			for(int j=0; j<col-1;j++)
				{
					sum = 0;
					sum = sum + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1]+ arr[i+2][j];
					if(sum>max)
						max =sum;
				}
		for(int i=0; i<row-1; i++)
			for(int j=0; j<col-2;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i+1][j] + arr[i+1][j+1]+ arr[i+1][j+2];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-2; i++)
			for(int j=0; j<col-1;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i+1][j] + arr[i+2][j]+ arr[i][j+1];
					if(sum>max)
						max =sum;
				}
		for(int i=0; i<row-1; i++)
			for(int j=0; j<col-2;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i][j+1] + arr[i][j+2]+ arr[i+1][j+2];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-1; i++)
			for(int j=0; j<col-2;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i][j+1] + arr[i][j+2]+ arr[i+1][j+1];
					if(sum>max)
						max =sum;
				}
		for(int i=0; i<row-1; i++)
			for(int j=0; j<col-2;j++)
				{
					sum = 0;
					sum = sum + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1]+ arr[i+1][j+2];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-2; i++)
			for(int j=0; j<col-1;j++)
				{
					sum = 0;
					sum = sum + arr[i][j] + arr[i+1][j] + arr[i+2][j]+ arr[i+1][j+1];
					if(sum>max)
						max =sum;
				}
		
		for(int i=0; i<row-2; i++)
			for(int j=0; j<col-1;j++)
				{
					sum = 0;
					sum = sum + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1]+ arr[i+1][j];
					if(sum>max)
						max =sum;
				}
		
		
		
		System.out.printf("%d ", max);
	}
}
