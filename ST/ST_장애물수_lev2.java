import java.util.*;
import java.io.*;

public class ST_장애물수_lev2 {
    
    static int N, ans;
    static char[][] Map;
    static boolean visit[][];
    static int dx[] = {0, 0, -1 ,1};
    static int dy[] = {-1, 1, 0, 0};
    static StringTokenizer st;
    static class Node{
        int y, x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        // System.out.println(N);
        Map = new char[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            Map[i] = br.readLine().toCharArray();
            Arrays.fill(visit[i], false);
        }     
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Node> q = new LinkedList<Node>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(Map[i][j] != '0' ){
                    q.offer(new Node(i , j));
                    Map[i][j] = '0';
                    int cnt = 1;
                    ans++;
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        
                        for(int k = 0; k < 4; k++){
                            int ny = node.y + dy[k];
                            int nx = node.x + dx[k];
                            
                            if(ny >= 0 && nx >= 0 && ny < N && nx <N &&  Map[ny][nx] == '1'){
                                q.offer(new Node(ny, nx));
                                Map[ny][nx] = '0';
                                cnt++;
                            }
                        }
                    }
                    pq.offer(cnt);
                }
            }
            }
            System.out.println(ans);
            while(!pq.isEmpty()){
                System.out.println(pq.poll());
        }   
    }   
        
}
