import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_군사이동_11085 {
    
    static int p, w, c , v, ans;
    static PriorityQueue<route> pq = new PriorityQueue<>((e1,e2) -> e2.c - e1.c);
    static int[] parent;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        parent = new int[p];
        

        for(int i = 0; i < p; i++){
            parent[i] = i;
        }
        for(int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            pq.add(new route(y, x, n));
            
        }
       
        while(!pq.isEmpty()){

            route r = pq.poll();

            union(r.y, r.x);

            if(find(c) == find(v)){

                ans = r.c;
                break;
            }
            
        }
        System.out.println(ans);
    }

    static class route{
        int y;
        int x;
        int c;

        route(int y, int x, int c){
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }

    static void union(int y, int x){
        int fy = find(y);
        int fx = find(x);

        if(fx <= fy) parent[fy] = fx;
        else parent[fx] = fy;
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}
