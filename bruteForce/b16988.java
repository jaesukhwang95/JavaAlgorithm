package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b16988 {

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static class Element {
		int x;
		int y;

		Element(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int makeGroup(int[][] plate, boolean[][] visit, int n, int m, ArrayList<Integer> groupInformation) {
		Queue<Element> q = new LinkedList<Element>();
		int groupNumber = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j] && plate[i][j] == 2) {
					q.offer(new Element(i, j));
					int groupCount = 1;
					visit[i][j] = true;
					plate[i][j] = groupNumber;
					while (!q.isEmpty()) {
						Element p = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							if (0 <= nx && nx < n && 0 <= ny && ny < m && !visit[nx][ny] && plate[nx][ny] == 2) {
								groupCount++;
								visit[nx][ny] = true;
								plate[nx][ny] = groupNumber;
								q.offer(new Element(nx, ny));
							}
						}
					}
					groupInformation.add(groupCount);
					groupNumber++;
				}
			}
		}
		return groupNumber - 1;
	}

	public static boolean checkStoneStatus(int x, int y, int n, int m, int[][] plate) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m && plate[nx][ny] == 0) {
				return false;
			}
		}
		return true;
	}

	public static int checkKilledStone(int[][] plate, ArrayList<Integer> groupInformation, int n, int m) {
		int[] presentInformation = new int[groupInformation.size()];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (plate[i][j] > 0 && checkStoneStatus(i, j, n, m, plate)) {
					presentInformation[plate[i][j] - 1]++;
				}
			}
		}
		int killedStone = 0;
		for (int i = 0; i < groupInformation.size(); i++) {
			if (presentInformation[i] == groupInformation.get(i)) {
				killedStone = killedStone + groupInformation.get(i);
			}
		}
		return killedStone;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] plate = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
				if (plate[i][j] == 1)
					plate[i][j] = -1;
			}
		}
		ArrayList<Integer> groupInformation = new ArrayList<Integer>();
		makeGroup(plate, visit, n, m, groupInformation);
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = plate[i][j];
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < m; l++) {
						if (plate[i][j] != 0)
							continue;
						if (plate[k][l] != 0)
							continue;
						if (i == k && j == l)
							continue;
						plate[i][j] = -1;
						plate[k][l] = -1;
						int totalKilledStone = checkKilledStone(plate, groupInformation, n, m);
						if (totalKilledStone > max) {

							max = totalKilledStone;
						}
						plate[i][j] = 0;
						plate[k][l] = 0;
					}
				}
			}
		}
		System.out.println(max);
	}
}
