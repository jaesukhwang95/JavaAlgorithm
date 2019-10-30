package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b4574 {

	public static int findSquare(int i, int j) {
		if (1 <= i && i <= 3) {
			if (1 <= j && j <= 3)
				return 1;
			else if (4 <= j && j <= 6)
				return 2;
			else if (7 <= j && j <= 9)
				return 3;
		} else if (4 <= i && i <= 6) {
			if (1 <= j && j <= 3)
				return 4;
			else if (4 <= j && j <= 6)
				return 5;
			else if (7 <= j && j <= 9)
				return 6;
		} else if (7 <= i && i <= 9) {
			if (1 <= j && j <= 3)
				return 7;
			else if (4 <= j && j <= 6)
				return 8;
			else if (7 <= j && j <= 9)
				return 9;
		}
		return -1;
	}

	public static int[][] digit = new int[10][10];
	public static boolean[][] domino = new boolean[10][10];
	public static boolean[][] col = new boolean[10][10];
	public static boolean[][] row = new boolean[10][10];
	public static boolean[][] square = new boolean[10][10];
	public static boolean flag;
	public static int k = 1;
	public static StringBuilder ans = new StringBuilder();

	public static void go(int idx) {
		if (flag) {
			return;
		}
		if (idx == 81) {
			flag = true;
			StringBuilder sb = new StringBuilder();
			sb.append("Puzzle ").append(k++).append("\n");
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					sb.append(digit[i][j]);
				}
				sb.append("\n");
			}
			ans.append(sb);
			return;
		}
		int x = idx / 9 + 1;
		int y = idx % 9 + 1;
		if (digit[x][y] != 0) {
			go(idx + 1);
		}
		else
		{
			if (x <= 8 && digit[x + 1][y] == 0) {
				for (int i = 1; i <= 9; i++) {
					for (int j = i + 1; j <= 9; j++) {
						if (domino[i][j])
							continue;
						else {
							domino[i][j] = true;
							domino[j][i] = true;
							{
	//							x,y // x+1,y => i // j
								if (!row[x][i] && !col[y][i] && !row[x + 1][j] && !col[y][j] && !square[findSquare(x, y)][i]
										&& !square[findSquare(x + 1, y)][j]) {
									row[x][i] = true;
									col[y][i] = true;
									row[x + 1][j] = true;
									col[y][j] = true;
									square[findSquare(x, y)][i] = true;
									square[findSquare(x + 1, y)][j] = true;
									digit[x][y] = i;
									digit[x + 1][y] = j;
									go(idx + 1);
									row[x][i] = false;
									col[y][i] = false;
									row[x + 1][j] = false;
									col[y][j] = false;
									square[findSquare(x, y)][i] = false;
									square[findSquare(x + 1, y)][j] = false;
									digit[x][y] = 0;
									digit[x + 1][y] = 0;
								}
	//							x,y // x+1,y => j // i
								if (!row[x][j] && !col[y][j] && !row[x + 1][i] && !col[y][i] && !square[findSquare(x, y)][j]
										&& !square[findSquare(x + 1, y)][i]) {
									row[x][j] = true;
									col[y][j] = true;
									row[x + 1][i] = true;
									col[y][i] = true;
									square[findSquare(x, y)][j] = true;
									square[findSquare(x + 1, y)][i] = true;
									digit[x][y] = j;
									digit[x + 1][y] = i;
									go(idx + 1);
									row[x][j] = false;
									col[y][j] = false;
									row[x + 1][i] = false;
									col[y][i] = false;
									square[findSquare(x, y)][j] = false;
									square[findSquare(x + 1, y)][i] = false;
									digit[x][y] = 0;
									digit[x + 1][y] = 0;
								}
							}
							domino[i][j] = false;
							domino[j][i] = false;
	
						}
	
					}
				}
			}
			if (y <= 8 && digit[x][y + 1] == 0) {
				for (int i = 1; i <= 9; i++) {
					for (int j = i + 1; j <= 9; j++) {
						if (domino[i][j])
							continue;
						else {
							domino[i][j] = true;
							domino[j][i] = true;
	
							{
	//							x,y // x,y+1 => i // j
								if (!row[x][i] && !col[y][i] && !row[x][j] && !col[y + 1][j]
										&& !square[findSquare(x, y)][i] && !square[findSquare(x, y + 1)][j]) {
									row[x][i] = true;
									col[y][i] = true;
									row[x][j] = true;
									col[y + 1][j] = true;
									square[findSquare(x, y)][i] = true;
									square[findSquare(x, y + 1)][j] = true;
									digit[x][y] = i;
									digit[x][y + 1] = j;
									go(idx + 2);
									row[x][i] = false;
									col[y][i] = false;
									row[x][j] = false;
									col[y + 1][j] = false;
									square[findSquare(x, y)][i] = false;
									square[findSquare(x, y + 1)][j] = false;
									digit[x][y] = 0;
									digit[x][y + 1] = 0;
								}
	//							x,y // x,y+1 => j // i
								if (!row[x][j] && !col[y][j] && !row[x][i] && !col[y + 1][i]
										&& !square[findSquare(x, y)][j] && !square[findSquare(x, y + 1)][i]) {
									row[x][j] = true;
									col[y][j] = true;
									row[x][i] = true;
									col[y + 1][i] = true;
									square[findSquare(x, y)][j] = true;
									square[findSquare(x, y + 1)][i] = true;
									digit[x][y] = j;
									digit[x][y + 1] = i;
									go(idx + 2);
									row[x][j] = false;
									col[y][j] = false;
									row[x][i] = false;
									col[y + 1][i] = false;
									square[findSquare(x, y)][j] = false;
									square[findSquare(x, y + 1)][i] = false;
									digit[x][y] = 0;
									digit[x][y + 1] = 0;
								}
	
							}
							domino[i][j] = false;
							domino[j][i] = false;
	
						}
	
					}
				}
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			int n = Integer.parseInt(br.readLine());
				if (n == 0) {
					bw.write(ans.toString());
					bw.close();
				System.exit(0);
			}
			flag = false;
			for (int i = 1; i <= 9; i++)
				for (int j = 1; j <= 9; j++) {
					digit[i][j] = 0;
					domino[i][j] = false;
					col[i][j] = false;
					row[i][j] = false;
					square[i][j] = false;
				}
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				String str1 = st.nextToken();
				int front1 = str1.charAt(0) - 'A' + 1;
				int back1 = str1.charAt(1) - '0';
				digit[front1][back1] = num1;
				row[front1][num1] = true;
				col[back1][num1] = true;
				square[findSquare(front1, back1)][num1] = true;
				int num2 = Integer.parseInt(st.nextToken());
				String str2 = st.nextToken();
				int front2 = str2.charAt(0) - 'A' + 1;
				int back2 = str2.charAt(1) - '0';
				digit[front2][back2] = num2;
				row[front2][num2] = true;
				col[back2][num2] = true;
				square[findSquare(front2, back2)][num2] = true;
				domino[num1][num2] = true;
				domino[num2][num2] = true;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 9; i++) {
				String str = st.nextToken();
				int front = str.charAt(0) - 'A' + 1;
				int back = str.charAt(1) - '0';
				digit[front][back] = i;
				row[front][i] = true;
				col[back][i] = true;
				square[findSquare(front, back)][i] = true;
			}
			go(0);
		}
	}
}