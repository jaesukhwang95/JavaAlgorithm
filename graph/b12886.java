package baekjoon.graph;

import java.util.*;
import java.io.*;

public class b12886 {

	public static class Group {
		int a;
		int b;

		public Group(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int sum = a + b + c;
		if ((a + b + c) % 3 != 0)
			System.out.println(0);
		else {
			Queue<Group> q = new LinkedList<Group>();
			HashSet<String> set = new HashSet<String>();
			int[] arr = new int[3];
			arr[0] = a;
			arr[1] = b;
			arr[2] = c;
			Arrays.sort(arr);
			q.offer(new Group(arr[0], arr[1]));
			set.add(arr[0] + " " + arr[1]);
			while (!q.isEmpty()) {
				Group g = q.poll();
				int na = g.a;
				int nb = g.b;
				int nc = sum - na - nb;
				if (na == nb && nb == nc) {
					System.out.println(1);
					System.exit(0);
				}
				if (na < nb) {
					int nna = na + na;
					int nnb = nb - na;
					int nnc = nc;
					int[] narr = new int[3];
					narr[0] = nna;
					narr[1] = nnb;
					narr[2] = nnc;
					Arrays.sort(narr);
					if (!set.contains(narr[0] + " " + narr[1])) {
						q.offer(new Group(narr[0], narr[1]));
						set.add(narr[0] + " " + narr[1]);
					}
				}
				if (na < nc) {
					int nna = na + na;
					int nnb = nb;
					int nnc = nc - na;
					int[] narr = new int[3];
					narr[0] = nna;
					narr[1] = nnb;
					narr[2] = nnc;
					Arrays.sort(narr);
					if (!set.contains(narr[0] + " " + narr[1])) {
						q.offer(new Group(narr[0], narr[1]));
						set.add(narr[0] + " " + narr[1]);
					}
				}
				if (nb < nc) {
					int nna = na;
					int nnb = nb + nb;
					int nnc = nc - nb;
					int[] narr = new int[3];
					narr[0] = nna;
					narr[1] = nnb;
					narr[2] = nnc;
					Arrays.sort(narr);
					if (!set.contains(narr[0] + " " + narr[1])) {
						q.offer(new Group(narr[0], narr[1]));
						set.add(narr[0] + " " + narr[1]);
					}
				}
			}
			System.out.println(0);
		}
	}
}