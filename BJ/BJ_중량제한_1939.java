import java.util.*;
import java.io.*;

public class BJ_중량제한_1939 {
    
    static int[] parent;
    static int N, M;
    static PriorityQueue<Island> pq = new PriorityQueue<Island>((e1,e2) -> e2.c - e1.c);
    static class Island{

        int s;
        int e;
        int c;

        Island(int s ,int e, int c){
            this.s = s;
            this.e = e;
            this.c = c;
        }

    }
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new Island(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        while(!pq.isEmpty()){
            Island i = pq.poll();
            union(i.s, i.e);
            if(find(start) == find(end)){
                System.out.println(i.c);
                return;
            }
        }
        System.out.println(0);
    }
    static int find(int x){
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }
    
    static void union(int x, int y){
        int fx = find(x);
        int fy = find(y);

        if(fx <= fy) parent[fy] = fx;
        else parent[fx] = fy;
    }
}
