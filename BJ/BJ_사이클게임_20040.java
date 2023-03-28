import java.io.*;
import java.util.*;

public class BJ_사이클게임_20040 {
    static int cnt;
    static int parent[];
    static Stack<Node> s = new Stack<Node>();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y=  Integer.parseInt(st.nextToken());
            // int n = Math.max(find(x), find(y));

            if(find(x) == find(y)){
                System.out.println(i+1);
                return;
            } 
            union(x, y);
        

        }
        System.out.println(0);
    }

    static void union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        
        if(fx <= fy) parent[fy] = fx;
        else parent[fx] = fy;
    }

    static int find(int x){
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }

    static class Node{

        int r;
        int c;
        int n;

        public Node(int r, int c, int n){
            this.r = r;
            this.c = c;
            this.n = n;
        }
    }
}
