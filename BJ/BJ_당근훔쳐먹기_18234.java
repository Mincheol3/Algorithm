import java.util.*;
import java.io.*;

public class BJ_당근훔쳐먹기_18234 {
    
    static PriorityQueue<Carrot> pq = new PriorityQueue<Carrot>((e1,e2)-> e1.p == e2.p ? e2.w - e1.w : e2.p-e1.p);
    static int N;
    static long T,ans;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new Carrot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while(!pq.isEmpty()){
            Carrot c = pq.poll();
            long val  = c.p*(--T) + c.w;
            ans += val;
        }
        System.out.println(ans);
        

    }

    
    static class Carrot{
        int w;
        int p;

        Carrot (int w, int p) {
            this.w = w;
            this.p = p;
        }
    }
}
