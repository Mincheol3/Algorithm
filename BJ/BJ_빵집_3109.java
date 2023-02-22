import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_빵집_3109 {
    
    static int dx[] = {1, 1, 1};
    static int dy[] = {-1, 0, 1};
    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int ans;
    static boolean check;
    static Queue<pipe> q = new LinkedList<pipe>();
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for(int i = 0 ; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int t = 0; t < R; t++){
            q.offer(new pipe(t, 0));
            check = false;
            dfs();
        }
        

        // while(!q.isEmpty()){
        //     pipe p = q.poll();

        //     int y = p.y;
        //     int x = p.x;
        //     visit[y][x] = true;
        //     if(x == C - 1){
        //         check = true;
        //         ans++;
        //     }

        //     for(int i = 0; i < 3; i++){
        //         if(check) break;
        //         int ny = y + dy[i];
        //         int nx = x + dx[i];

        //         //범위 체크
        //         if(ny < 0 || ny >= R || nx >= C || visit[ny][nx] || map[ny][nx] != '.') continue;
        //         // 빵집까지 갔으면
        //         if(nx == C-1){
        //             ans++;
        //             visit[ny][nx] = true;
        //         }
        //         // visit[ny][nx] = true;
        //         q.offer(new pipe(ny, nx));
                
        //     }
        // }
        System.out.println(ans);


    }
    static void dfs(){
        while(!q.isEmpty()){
            pipe p = q.poll();

            int y = p.y;
            int x = p.x;
            visit[y][x] = true;

            if(x == C - 1){
                check = true;
                ans++;
            }

            for(int i = 0; i < 3; i++){
                if(check) break;
                int ny = y + dy[i];
                int nx = x + dx[i];

                //범위 체크
                if(ny < 0 || ny >= R || nx >= C || visit[ny][nx] || map[ny][nx] != '.') continue;
                // 빵집까지 갔으면
                // System.out.println("ny :" + ny);
                // System.out.println("nx :" + nx);
                q.offer(new pipe(ny, nx));
                dfs();
                
            }
        }
    }

    static class pipe{
        int y, x;

        pipe(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
