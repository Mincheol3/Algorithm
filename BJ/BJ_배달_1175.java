import java.util.*;
import java.io.*;

public class BJ_배달_1175 {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int N, M,ans;
    static char map[][];
    static boolean visit[][][][];
    static boolean visited[][];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        map = new char[N][];
        visit = new boolean[N][M][5][4];
        visited = new boolean[N][M];
        Queue<Block> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            if (q.isEmpty()) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'S'){
                        q.add(new Block(i, j, 4, 0, 0,false,false));
                        // visit[i][j][0] = true;
                        // visit[i][j][1] = true;
                        // visit[i][j][2] = true;
                        // visit[i][j][3] = true;
                        break;
                    }
                }
            }
        }
        while(!q.isEmpty()){

            Block b = q.poll();

            // if(map[b.y][b.x] == 'C'){
                
            //     b.a++;
            // }
            if(!b.C1 && b.x == 0 && b.y == 1){
                b.a++;
                b.C1 = true;
            }
            if(!b.C2 && b.x == 2 && b.y == 1){
                b.a++;
                b.C2 = true;
            }
            if(b.a == 2){
                ans = Math.min(ans, b.c);
                continue;
            }
            for(int i = 0; i < 4; i++){
                int ny = b.y + dy[i];
                int nx = b.x + dx[i];

                if(b.d == i || ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == '#' || visit[ny][nx][b.d][i]) continue;
                visit[ny][nx][b.d][i] = true;
                System.out.println(ny + " " + nx + " " + b.d + " " + (b.c+1));
                q.add(new Block(ny, nx, i, b.c+1,b.a,b.C1,b.C2));
            }
        }
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static class Block {
        int y;
        int x;
        int d;
        int c;
        int a;
        boolean C1 = false;
        boolean C2 = false;
        Block(int y, int x, int d,int c, int a, boolean C1, boolean C2) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.c = c;
            this.a = a;
            this.C1 = C1;
            this.C2 = C2;
        }
    }
}
