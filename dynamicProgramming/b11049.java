package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

public class b11049 {

	public static class Matrix {
		int row;
		int col;

		Matrix(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] ans = new int[n][n];
		Matrix[] matrixArray = new Matrix[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			matrixArray[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				ans[j][j + i] = Integer.MAX_VALUE;
				for (int k = 0; k < i; k++) {
					int localMin = ans[j][j + k] + ans[j + k + 1][j + i]
							+ matrixArray[j].row * matrixArray[j + k].col * matrixArray[j + i].col;
					ans[j][j + i] = Math.min(ans[j][j + i], localMin);
				}
			}
		}
		System.out.println(ans[0][n - 1]);
	}
}
