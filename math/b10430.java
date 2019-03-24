package baekjoon.math;
import java.util.Scanner;


public class b10430 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.printf("%d\n", (A+B)%C);
		System.out.printf("%d\n", (A%C + B%C)%C);
		System.out.printf("%d\n", (A*B)%C);
		System.out.printf("%d\n", (A%C * B%C)%C);

		sc.close();
	}
}
