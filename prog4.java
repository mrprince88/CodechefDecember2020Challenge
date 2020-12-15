import java.io.*;
import java.util.*;

class prog4 {

    public static void main(String[] args) throws IOException {

          System.setIn(new FileInputStream("./input.txt"));
         System.setOut(new PrintStream(new FileOutputStream("./output.txt")));
        
        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);

        int t=in.nextInt();

        while(t-->0) {
            int n=in.nextInt();
            int k=in.nextInt();
            int []a=new int[n+1];
            
            if((n&1)==0) {
                for(int i=1;i<=n;i++)
                a[i]=((i&1)==0)?i:-i;
            }

            else {
                for(int i=1;i<=n;i++)
                a[i]=((i&1)==1)?i:-i;
            }

            int sum=0,cnt=0;

            for(int i=1;i<=n;i++){
                sum+=a[i];
                if(sum>0)
                cnt++;
            }

            if(cnt>k) {
                for(int i = n ;cnt > k;i-=2) {
                    cnt--;
                    pw.println(i);
                    a[i]=-i;
                }
            }

            else if(cnt<k) {
                for (int i = n-1; cnt < k; i-=2) {
                    cnt++;
                    a[i] = i;
                }

            }

            for(int i=1;i<=n;i++)
            pw.print(a[i]+" ");
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
            int []a = new int[n];
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
            final int [][]arr = new int[n][m];
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