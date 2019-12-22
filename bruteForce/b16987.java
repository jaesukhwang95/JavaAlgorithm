package baekjoon.bruteForce;
import java.util.*;
import java.io.*;

public class b16987 {
	
	public static class Egg{
		int durability;
		int weight;
		Egg(int durability, int weight){
			this.durability = durability;
			this.weight = weight;
		}
	}
	
	public static void strikeEgg(int idx1, int idx2, Egg [] eggArray)
	{
		Egg Egg1 = eggArray[idx1];
		Egg Egg2 = eggArray[idx2];
		Egg1.durability = Egg1.durability - Egg2.weight;
		Egg2.durability = Egg2.durability - Egg1.weight;
		eggArray[idx1] = Egg1;
		eggArray[idx2] = Egg2;
	}
	
	public static void changeRound(int idx, int eggCount, Egg [] eggArray){
		if(idx == eggCount)
		{
			for(int i=0; i<eggCount; i++)
			{
				System.out.println(eggArray[i].durability+" "+eggArray[i].weight);
			}
			int cnt = 0;
			for(int i=0; i<eggCount; i++)
			{
				if(eggArray[i].durability < 0)
					cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		if(eggArray[idx].durability < 0)
		{
			changeRound(idx+1, eggCount, eggArray);
		}
		else
		{
			for(int i=0; i<eggCount; i++)
			{
				if(i == idx)
				{
					continue;
				}
				else if(eggArray[i].durability<0)
				{
					continue;
				}
				else
				{
					Egg Egg1 = eggArray[i];
					Egg Egg2 = eggArray[idx];
					strikeEgg(i, idx, eggArray);
					changeRound(idx+1, eggCount, eggArray);
					eggArray[i] = Egg1;
					eggArray[idx] = Egg2;
				}
			}
			changeRound(idx+1, eggCount, eggArray);
		}
	}
	
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int eggCount = Integer.parseInt(br.readLine());
		Egg [] eggArray = new Egg[eggCount];
		for(int i=0; i<eggCount; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggArray[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		changeRound(0, eggCount, eggArray);
		System.out.println(max);
	}
}
