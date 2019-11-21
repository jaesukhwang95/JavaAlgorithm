package baekjoon.sorting;
import java.util.*;
import java.io.*;

public class b10814 {
	public static class Person implements Comparable<Person>
	{
		private int age;
		private String name;
		Person(int age, String name)
		{
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Person p)
		{
			if(this.age < p.age)
				return -1;
			else if(this.age == p.age)
			{
				return 0;
			}
			else
				return 1;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Person> arr = new ArrayList<Person>();
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			arr.add(new Person(age, name));
		}
		Collections.sort(arr);
		for(int i=0; i<n; i++)
		{
			sb.append(arr.get(i).age).append(" ").append(arr.get(i).name).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}

//Collections.sort()는 애초에 merge sort이기 때문에 비교 순위가 같을 경우 입력이 들어온 순서대로 정렬된다.