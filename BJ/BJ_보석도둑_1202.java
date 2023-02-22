import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_보석도둑_1202 {
    
    static int N, K;
    static int[] w;
    static long ans;
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        w = new int[K];
        
        jewel[] jewels = new jewel[N];


        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            
            jewels[i] = new jewel(M, V);             
        }

        Arrays.sort(jewels, new Comparator<jewel>(){
            @Override
            public int compare(jewel o1, jewel o2){
                if(o1.m == o2.m){
                    return o2.v - o1.v;
                }
                return o1.m - o2.m;
            }
        });

        for(int i = 0; i < K; i++){
            w[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(w);

        int idx = 0;
        for(int i = 0; i < K; i++){
            
            while(idx < N && w[i] >=  jewels[idx].m){
                pq.offer(jewels[idx++].v);

               
            }

            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    
    }

    static class jewel{
        int m;
        int v;

        jewel(int m , int v){
            this.m = m ;
            this.v = v;
        }
    }
}
