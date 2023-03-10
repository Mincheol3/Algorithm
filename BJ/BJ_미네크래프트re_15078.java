import java.util.*;
import java.io.*;

public class BJ_미네크래프트re_15078 {
    
    static int N,T,P,ans;
    static int[] K;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        K = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            K[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        
        for(int i = 0 ; i < N; i++){

            if(P*i > T) break;
            pq.add(K[i]);
            sum+=K[i];

            if(!pq.isEmpty() && (sum + P*i > T)){
                sum-= pq.peek();
                pq.poll();
            }
            ans = Math.max(ans, pq.size());
        }
        System.out.println(ans);
    }
}
