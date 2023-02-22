import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_최단경로_1753 {
    
    static int V, E, K;
    static boolean visit[];
    static int[] cost;
    static ArrayList<ArrayList<Node>> nodes = new ArrayList<ArrayList<Node>>();
    static PriorityQueue<Node> pq = new PriorityQueue<Node>((e1,e2) -> e1.cost -e2.cost);
    static class Node{
        
        int e;
        int cost;

        Node( int e, int cost){
            
            this.e= e;
            this.cost= cost;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      

        StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

        visit = new boolean[V+1];
        cost = new int[V+1];

        for(int i = 0; i<= V; i++){
            nodes.add(new ArrayList<Node>());
            cost[i] = 99999999;
        }

        for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			
			nodes.get(v1).add(new Node(v2,w));
		}
        bfs();
        for(int i = 1; i <=V; i++) {
			System.out.println(cost[i] == 99999999 ? "INF" : cost[i]);
		}


        
    }
    static void bfs(){
        cost[K] = 0;
        pq.offer(new Node(K, 0));

        while(!pq.isEmpty()){

            Node n = pq.poll();
            int ne = n.e;
            int ncost = n.cost;
            if(visit[ne]) continue;
            visit[ne] = true;
            for(int i =0; i < nodes.get(ne).size(); i++){
                Node nd = nodes.get(ne).get(i);
                if(!visit[nd.e] && cost[nd.e] > nd.cost + cost[ne]){
                    cost[nd.e] = nd.cost + cost[ne];
                    pq.offer(new Node(nd.e, cost[nd.e]));
                }
             }
        }
    }
}
