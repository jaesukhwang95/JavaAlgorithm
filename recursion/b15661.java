package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class b15661 {

	public static int min = Integer.MAX_VALUE;

	public static void chooseTeam(int idx, int num, ArrayList<Integer> Start, ArrayList<Integer> Link,
			int[][] ability) {
		if (idx == num) {
			findMinimum(Start, Link, num, ability);
			return;
		}
		Start.add(idx);
		chooseTeam(idx + 1, num, Start, Link, ability);
		Start.remove(Start.size() - 1);
		Link.add(idx);
		chooseTeam(idx + 1, num, Start, Link, ability);
		Link.remove(Link.size() - 1);

	}

	public static void findMinimum(ArrayList<Integer> Start, ArrayList<Integer> Link, int num, int[][] ability) {
		int startAbility = 0;
		int linkAbility = 0;
		for (int i = 0; i < Start.size(); i++) {
			for (int j = 0; j < Start.size(); j++) {
				startAbility = startAbility + ability[Start.get(i)][Start.get(j)];
			}
		}
		for (int i = 0; i < Link.size(); i++) {
			for (int j = 0; j < Link.size(); j++) {
				linkAbility = linkAbility + ability[Link.get(i)][Link.get(j)];
			}
		}
		min = Math.min(min, Math.abs(startAbility - linkAbility));
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] ability = new int[num][num];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < num; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> Start = new ArrayList<Integer>();
		ArrayList<Integer> Link = new ArrayList<Integer>();
		chooseTeam(0, num, Start, Link, ability);
		System.out.println(min);
	}
}
