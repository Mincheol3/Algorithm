import java.util.*;
import java.io.*;

public class BJ_컵라면2_1781 {
    
    static int num[];
    static int N, pre;
    static long ans;
    static boolean check[];
    static PriorityQueue<report> pq = new PriorityQueue<report>((r1,r2) -> r1.n == r2.n ? r1.d - r2.d : r2.n - r1.n);
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        check = new boolean[N + 1];
        num = new int[N+1];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dead = Integer.parseInt(st.nextToken());
            pq.offer(new report(dead, Integer.parseInt(st.nextToken())));
            check[dead] = true;
        }
        int nn = 0;
        for(int i = 1 ; i <= N; i++){
            if(check[i]) nn++;
        }
        // System.out.println("nn" + nn);
        int cnt = 0;
        while(!pq.isEmpty()){
            report r = pq.poll();
            int d = r.d;
            int n = r.n;

            if( num[d] < d && d > cnt){
                num[d]++;
                cnt++;
                ans+= n;
                // System.out.println("d : " + d + " " + "n :" + n);
            }
        }

        System.out.println(ans);
    }

    static class report{

        int d;
        int n;

        report(int d, int n){
            this.d = d;
            this.n = n;
        }
    }
}
