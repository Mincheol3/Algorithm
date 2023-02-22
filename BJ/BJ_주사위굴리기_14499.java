import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_주사위굴리기_14499 {
    
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int N, M, K, x , y;
    static int[][] map;
    // 상 하 좌 우 앞 뒤
    static int dice[];
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dice = new int[6];
    

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> q  = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){

            q.offer(Integer.parseInt(st.nextToken()));
        }
   
         while(!q.isEmpty()){
            int cmd = q.poll();
            
            roll(cmd);
        }

        System.out.println(sb.toString());
    }

    static void roll(int cmd){

        if(x + dx[cmd] < 0 || x +dx[cmd] >= M 
        || y + dy[cmd] < 0 || y + dy[cmd] >= N) return;
        else {
            x += dx[cmd];
            y += dy[cmd];
        }
       
        int temp = 0;
        
        if(map[y][x] == 0){
            switch(cmd) {
                // 동
                case 1 :
                    temp = dice[2];
                    dice[2] = dice[1];
                    dice[1] = dice[3];
                    dice[3] = dice[0];
                    dice[0] = temp;
                    break;
                // 서
                case 2 :
                    temp = dice[3];
                    dice[3] = dice[1];
                    dice[1] = dice[2];
                    dice[2] = dice[0];
                    dice[0] = temp;
                    break;
                // 북
                case 3 :
                    temp = dice[5];
                    dice[5] = dice[1];
                    dice[1] = dice[4];
                    dice[4] = dice[0];
                    dice[0] = temp;
                    break;
                // 남
                case 4 :
                    temp = dice[4];
                    dice[4] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[0];
                    dice[0] = temp;
                    break;
    
            }
            map[y][x] = dice[1];
        }

        else{
            switch(cmd) {
                // 동
                case 1 :
                    temp = dice[2];
                    dice[2] = dice[1];
                    dice[1] = map[y][x];
                    dice[3] = dice[0];
                    dice[0] = temp;
                    break;
                // 서
                case 2 :
                    temp = dice[3];
                    dice[3] = dice[1];
                    dice[1] = map[y][x];
                    dice[2] = dice[0];
                    dice[0] = temp;
                    break;
                // 북
                case 3 :
                    temp = dice[5];
                    dice[5] = dice[1];
                    dice[1] = map[y][x];
                    dice[4] = dice[0];
                    dice[0] = temp;
                    break;
                // 남
                case 4 :
                    temp = dice[4];
                    dice[4] = dice[1];
                    dice[1] = map[y][x];
                    dice[5] = dice[0];
                    dice[0] = temp;
                    break;
    
            }
            map[y][x] = 0;
        }
        System.out.println(dice[0]);
    }
}
