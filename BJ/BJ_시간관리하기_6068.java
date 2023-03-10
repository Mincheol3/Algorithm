import java.util.*;
import java.io.*;

public class BJ_시간관리하기_6068 {
    
    static int N, max;
    static PriorityQueue<work> pq = new PriorityQueue<>((e1,e2) -> e1.s == e2.s ? e2.t-e1.t : e2.s-e1.s);
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i =0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            pq.add(new work(T, S));
            max = Math.max(max, S);
        }
        while(!pq.isEmpty()){
            work w = pq.poll();
            
            if(max <= w.s){
                max -= w.t;
            }
            else max = w.s-w.t;
        }

        if(max < 0) System.out.println(-1);
        else System.out.println(max);

    
    }
    static class work{
        int t;
        int s;

        work(int t, int s){
            this.t = t;
            this.s= s;
        }
    }
}
