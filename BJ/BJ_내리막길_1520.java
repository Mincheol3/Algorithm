import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_내리막길_1520 {
    
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int M, N, ans;
    static int map[][];
    static int dp[][];
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];
        
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        // dfs(0,0);
        System.out.println(dfs(0,0));
    }

    static int dfs(int y, int x){
        
        // 도착지 
        if(y == M-1 && x == N-1){
            return 1;
        }

        // 이미 가본 길이면 있으면 그 경로에서 도착지로 갈 수 있는 경우의 수 리턴
        if(dp[y][x] != -1){
            return dp[y][x];
        }

        dp[y][x] = 0;
        
        for(int i = 0 ; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if( ny >= 0 && nx >= 0 && ny < M && nx < N && map[ny][nx] < map[y][x]){

                dp[y][x] += dfs(ny, nx);
           
            }
      
        }
        return dp[y][x];
    }
}
