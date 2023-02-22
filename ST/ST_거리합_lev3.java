import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ST_거리합_lev3 {
    
    static int N;
    static long ans[];
    static int parent[];
    static int childCnt[];

    static class Node{
        int num;
        long cost;
        
        Node(int num, long cost){
            this.num = num;
            this.cost = cost;
        }
    }
    static class info{
        int branchCnt;
        long costSum;
    }

    static ArrayList<Node>[] adj;

    static info dfs(int curNode, int par){
        info ret = new info();
        parent[curNode] = par;
        for(int i = 0 ; i < adj[curNode].size(); i++){
            int nextNode = adj[curNode].get(i).num;
            long cost = adj[curNode].get(i).cost;

            if(nextNode == par) continue;
            info child = dfs(nextNode, curNode);
            ret.costSum += cost * child.branchCnt + child.costSum;
            ret.branchCnt += child.branchCnt; 
        }
        ret.branchCnt++;
    }
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        ans = new long[N+1];
        parent = new int[N+1];
        childCnt = new int[N+1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<Node>();
        }
        // 입력
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e= Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            adj[s].add(new Node(e,c));
            adj[e].add(new Node(s,c));
        }
    }
}
