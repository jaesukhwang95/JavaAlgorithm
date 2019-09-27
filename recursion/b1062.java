package baekjoon.recursion;
import java.util.*;
import java.io.*;

public class b1062 {
	
	static String [] words; // 입력 단어들
	static int n,k,ans; // n: 단어 수, k: 알파벳 수-5
	static char [] charset; // 알파벳 후보군
	
	public static void go(HashSet<Character> charList, int idx, int start)
	{
		int cnt = 0;
		if(idx == k)
		{
			for(int i=0; i<words.length ;i++)
			{
				if(words[i].length() == 0)
				{
					cnt++;
				}
				else
				{
					for(int j=0; j<words[i].length(); j++)
					{
						if(!charList.contains(words[i].charAt(j)))
						{
							break;
						}
						if(j==words[i].length()-1)
							cnt++;
					}
				}
			}
			ans = Math.max(cnt, ans);
			return;
		}
		for(int i=start; i<charset.length ;i++)
		{
			charList.add(charset[i]);
			go(charList, idx+1, i+1);
			charList.remove(charset[i]);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		 ans = 0;
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 k = Integer.parseInt(st.nextToken());
		 k = k-5;
		 words = new String[n];
		 HashSet<Character> alpha = new HashSet<Character>();
		 for(int i=0; i<n ;i++)
		 {
			 String word = br.readLine();
			 word = word.replaceAll("[a,c,i,n,t]", "");
			 words[i] = word;
			 for(int j=0; j<word.length() ;j++)
			 {
				 alpha.add(word.charAt(j));
			 }
		 }
		 if(k>=0)
		 {
			 charset = new char [alpha.size()];
			 int num  = 0;
			 for(char ch: alpha)
			 {
				 charset[num] = ch;
				 num++;
			 }
			 if(alpha.size()<k)
				 k = alpha.size();
			 go(new HashSet<Character>(), 0, 0);
			 System.out.println(ans);
		 }
		 else
		 {
			 System.out.println(ans);
		 }
	}
}