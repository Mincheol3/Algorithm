import java.util.*;
import java.io.*;
public class BJ_보스몬스터전리품_20005 {
    
    static int ans, sum,answer;
    static Queue<Room> q = new LinkedList<>();
    static int N,M,P,HP;
    static boolean visit[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static char[][] map;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visit = new boolean[N][M];
        int bx = 0;
        int by = 0;
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();

            for(int j = 0; j < M; j++){
                if(map[i][j] == 'B'){
                    by = i;
                    bx = j;
                }
            }
        }
        HashMap<String, Integer> hMap = new HashMap<String, Integer>();
        for(int i = 0 ; i < P; i++){
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            hMap.put(c, n);
        }
        HP = Integer.parseInt(br.readLine());
        q.add(new Room(by, bx, 0));
        visit[by][bx] = true;
    //    System.out.println(by + " " + bx);
       while(HP > 0){
       
        while(!q.isEmpty()){
            
            if(q.peek().c > ans) break;
            
            Room r = q.poll();
          
            if(map[r.y][r.x] != 'X' && map[r.y][r.x] != 'B' && map[r.y][r.x] != '.'){
                sum += hMap.get(String.valueOf(map[r.y][r.x]));
                // System.out.println(map[r.y][r.x]);
                // String str = String.valueOf(map[r.y][r.x]);
                // System.out.println(hMap.get(str));
                answer++;
                // System.out.println("FIND" + " "  + r.y + " " + r.x);
            }
            for(int i =0; i< 4 ; i++){
                int ny = r.y + dy[i];
                int nx = r.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= N || nx >=M || visit[ny][nx] || map[ny][nx] == 'X') continue;
                // System.out.println(ny + " " + nx);
                q.add(new Room(ny, nx, r.c+1));
                visit[ny][nx] = true;
            }
        }
        // System.out.println(HP);
        HP -= sum;
        ans++;
    }
    System.out.println(answer);


    }

    static class Room{

        int y;
        int x;
        int c;

        Room(int y, int x , int c){
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
}
