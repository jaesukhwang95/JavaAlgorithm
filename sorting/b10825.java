package baekjoon.sorting;
import java.io.*;
import java.util.*;

public class b10825 {
	public static class Student implements Comparable<Student>
	{
		private String name;
		private int korean;
		private int english;
		private int math;
		Student(String name, int korean, int english, int math)
		{
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
		@Override
		public int compareTo(Student s)
		{
			if(this.korean > s.korean)
				return -1;
			else if(this.korean == s.korean)
			{
				if(this.english < s.english)
					return -1;
				else if(this.english == s.english)
				{
					if(this.math > s.math)
						return -1;
					else if(this.math == s.math)
					{
						if(this.name.compareTo(s.name) < 0)
							return -1;
						else if(this.name.compareTo(s.name) == 0)
							return 0;
						else
							return 1;
					}
					else
						return 1;
				}
				else
					return 1;
			}
			else 
				return 1;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> arr = new ArrayList<Student>();
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			arr.add(new Student(name, korean, english, math));
		}
		Collections.sort(arr);
		for(int i=0; i<n; i++)
		{
			sb.append(arr.get(i).name).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
