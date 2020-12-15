import java.io.*;
import java.util.*;

class prog1 {


	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		int d1 = in.nextInt(), v1 = in.nextInt(), d2 = in.nextInt(), v2 = in.nextInt(),
		    v = in.nextInt();

		int day;
		for (day = 1; v > 0; day++) {
			if (d1 <= day)
				v -= v1;
			if (d2 <= day)
				v -= v2;
		}
		System.out.println(day-1);
	}

	static class InputReader {
		BufferedReader br;
		StringTokenizer st;

		public InputReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		int[] readArray(int n) {
			int []a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
		int [][] read2dArray(int n, int m) {
			int [][]a = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					a[i][j] = nextInt();
			return a;
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
