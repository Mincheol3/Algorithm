import java.util.*;
import java.io.*;

public class BJ_용액_2467 {
    
    static int N, idx;
    static long[] Arr;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Arr = new long[N];
        for(int i =0; i < N; i++){
            Arr[i] = Long.parseLong(st.nextToken());
            if(Arr[i] < 0){
                idx = i;
            }
        }
        long idxj = 0;
        long idxi = 0;
        long ans = Long.MAX_VALUE;
        int j = N-1;
        for(int i =0; i<j ; i++){
            long n = Arr[j] + Arr[i];
            
            if(ans >= Math.abs(n)) {
                ans = Math.abs(n);
                idxi = Arr[i];    //   -3 -2  1  2
                idxj = Arr[j];
                // if(n > 0){
                //     i--;
                //     j--;
                // }
                // continue;
            }
            // else{
                if(n > 0){
                i--;
                j--;
                }
            // }
        }
        System.out.println(idxi + " " + idxj);
    }
}
