import java.io.*;
import java.util.*;

public class BJ_벽부수고이동하기_2206 {
    
    static int ans = Integer.MAX_VALUE;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static boolean[][][] visit;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        visit = new boolean[N][M][2];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(0, 0, false, 1));
        int t = 0;
        while(!q.isEmpty()){
            
            Point p = q.poll();
            if(p.c) t =0;
            else t = 1; 
            if(p.cnt >= ans) continue;
            if(p.y == N-1 && p.x == M-1){
                ans = Math.min(ans, p.cnt);
                continue;
            }

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || nx <0 || ny >= N || nx >= M || visit[ny][nx][t])continue;
                
                if(map[ny][nx] == '1' && t == 1) {
                    q.add(new Point(ny, nx, true, p.cnt+1));
                    visit[ny][nx][0] = true;
                }
                else if(map[ny][nx] == '0'){
                    visit[ny][nx][t] = true;
                    q.add(new Point(ny, nx, p.c, p.cnt+1));
                }
            }
        }
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    static class Point{

        int y;
        int x;
        boolean c;
        int cnt;

        public Point(int y, int x, boolean c, int cnt){
            this.y = y;
            this.x = x;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
