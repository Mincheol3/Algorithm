import java.util.*;
import java.io.*;

public class BJ_거울설치_2151 {

    static int dy[] = { -1, 1, 0, 0 };
    static int dx[] = { 0, 0, -1, 1 };
    static int N, ans;
    static int visit[][][];
    static char map[][];
    static ArrayList<door> list = new ArrayList<door>();
    static Queue<mirror> q = new LinkedList<mirror>();

    static class mirror {
        int y;
        int x;
        int d;
        int cnt;

        mirror(int y, int x, int d, int cnt) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.cnt = cnt;
        }
    }

    static class door {
        int y;
        int x;

        door(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        visit = new int[N][N][4];
        for(int i =0; i < N; i++) {
            for(int j = 0; j < N; j++){
                for(int k = 0; k < 4; k++){
                    visit[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '#') {
                    list.add(new door(i, j));
                }
            }
        }
        q.add(new mirror(list.get(0).y, list.get(0).x , -1, -1));

        while(!q.isEmpty()){

            mirror m = q.poll();
            int y = m.y;
            int x = m.x;
            int d = m.d;
            int cnt = m.cnt;
            // if(map[y][x] == '!') visit[y][x] = true;

            for(int i =0; i< 4; i++){
                int ny = y +dy[i];
                int nx = x + dx[i];

                if(ny >= N || nx >= N || nx < 0 || ny < 0 || map[ny][nx] == '*') continue;
                //현재위치가 '.' 이면 꺾을수 없음.
                if(map[y][x] == '.' && d != i) continue;
                
                if(ny == list.get(1).y && nx == list.get(1).x){
                    if(i != d) cnt++;
                    ans = Math.min(ans, cnt);
                    continue;
                }
                if(d == i){
                    if(visit[ny][nx][i] <= cnt) continue;
                    // System.out.println("t1" + " " +ny + " " + nx + " " + i + " " + cnt);
                    visit[ny][nx][i] = cnt;
                    q.add(new mirror(ny, nx, i, cnt));
                }
                else {
                    
                    if(visit[ny][nx][i] <= cnt+1) continue;
                    // System.out.println("t2" + " " + ny + " " + nx + " " + i + " " + cnt);
                    visit[ny][nx][i] = cnt+1;
                    q.add(new mirror(ny, nx, i, cnt+1));
                }

               
            }   
            
        }
        ans = ans == -1 ? 0 : ans;
        System.out.println(ans);
    }

}
