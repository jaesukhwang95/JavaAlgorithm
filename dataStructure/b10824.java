package baekjoon.dataStructure;
import java.io.*;
import java.util.*;

public class b10824 {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		String c = st.nextToken();
		String d = st.nextToken();
		System.out.println(Long.valueOf(a.concat(b))+Long.valueOf(c.concat(d)));
	}
}
