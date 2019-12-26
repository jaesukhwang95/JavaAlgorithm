package baekjoon.bruteForce;

import java.util.*;
import java.io.*;

public class b16987 {

	public static class Egg {
		int durability;
		int weight;

		Egg(int durability, int weight) {
			this.durability = durability;
			this.weight = weight;
		}
	}

	public static void strikeEgg(int idx1, int idx2, Egg[] eggArray) {
		eggArray[idx1].durability = eggArray[idx1].durability - eggArray[idx2].weight;
		eggArray[idx2].durability = eggArray[idx2].durability - eggArray[idx1].weight;
	}

	public static void changeRound(int idx, int eggCount, Egg[] eggArray) {
		if (idx == eggCount) {
			int cnt = 0;
			for (int i = 0; i < eggCount; i++) {
				if (eggArray[i].durability <= 0)
					cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		int brokenCnt = 0;
		for (int i = 0; i < eggCount; i++) {
			if (eggArray[i].durability <= 0)
				brokenCnt++;
		}
		if (eggArray[idx].durability <= 0 || brokenCnt >= (eggCount - 1)) {
			changeRound(idx + 1, eggCount, eggArray);
		} else {
			for (int i = 0; i < eggCount; i++) { 
				if (i == idx) {
					continue;
				} else if (eggArray[i].durability <= 0) {
					continue;
				} else {
					int durabiltiy1 = eggArray[i].durability;
					int durabiltiy2 = eggArray[idx].durability;
					strikeEgg(i, idx, eggArray);
					changeRound(idx + 1, eggCount, eggArray);
					eggArray[i].durability = durabiltiy1;
					eggArray[idx].durability = durabiltiy2;
				}
			}
		}
	}

	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int eggCount = Integer.parseInt(br.readLine());
		Egg[] eggArray = new Egg[eggCount];
		for (int i = 0; i < eggCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggArray[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		changeRound(0, eggCount, eggArray);
		System.out.println(max);
	}
}
