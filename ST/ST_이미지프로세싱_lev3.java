import java.util.*;
import java.io.*;


public class ST_이미지프로세싱_lev3
{
        static int H, W, Q;
        static StringTokenizer st;
        static int[][] map;
        static int[] dx = {0, 0, -1, 1};
        static int[] dy = {-1, 1, 0, 0};

        static class Node{
            int y;
            int x;
        
            Node(int y, int x){
                this.y = y;
                this.x = x;
            }
        }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        map = new int[H+1][W+1];

        for(int i = 1; i <= H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Q = Integer.parseInt(br.readLine());

        for(int i = 0 ; i< Q; i++){
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            Queue<Node> q = new LinkedList<Node>();
            q.offer(new Node(y,x));

            boolean[][] visit = new boolean[H+1][W+1];
            for(int k = 0; k <= H; k++){
                Arrays.fill(visit[k],false);
            }
            visit[y][x] = true;
            int origin = map[y][x];
            while(!q.isEmpty()){

                Node n = q.poll();
                int ox = n.x;
                int oy = n.y;
                
                map[y][x] = c;
                for(int j = 0; j < 4; j++){
                    int ny = oy + dy[j];
                    int nx = ox + dx[j];

                    if( ny >0 && nx >0 && ny <= H && nx <= W && !visit[ny][nx] && origin == map[ny][nx]){
                        map[ny][nx] = c;
                        visit[ny][nx] = true;
                        q.offer(new Node(ny,nx));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= H; i++){
            for(int j = 1; j<= W; j++){
                sb.append(map[i][j]+ " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
}