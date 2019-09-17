package baekjoon.dataStructure;
import java.io.*;

public class b1377 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		boolean check = false;
		int temp = 0;
		Loop:for(int i=0; i<n-2 ;i++) {
			check = false;
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1])
				{
					check = true;
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
			if(check == false)
			{
				System.out.println(i+1);
				break Loop;
			}
		}
		if(check == true)
		{
			System.out.println(arr.length);
		}
	}
}