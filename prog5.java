import java.io.*;
import java.util.*;

class prog5 {

    public static void main(String[] args) {
        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++)
                a[i] = in.nextLong();

            int i=0,o=0;

            for(int g=x;g>0 && i<n-1;g--) {

                boolean flag=false;

                int p=(int)(Math.log(a[i])/Math.log(2));
                long r=(long)Math.pow(2,p);

                a[i]=a[i]^r;

                for(int j=i+1;j<n;j++) {

                    if((a[j]^r) < a[j]) {
                        a[j]=a[j]^r;
                        flag=true;
                        break;
                    }

                }

                if(!flag)
                 a[n-1]^=r;

                while(i<n && a[i]<=0)
                 i++;

                o=g+1;

            }

            if(o>0) {
                if(n<3 && o%2>0) {
                    a[n-2]^=1;
                    a[n-1]^=1;
                }
            }

            for(int j=0;j<n;j++)
                pw.print(a[j]+ " ");
            pw.println();
        }

        pw.close();
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
                } catch (final IOException e) {
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
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        int[][] read2DArray(int n, int m) {
            final int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}