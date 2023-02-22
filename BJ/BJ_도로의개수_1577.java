import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_도로의개수_1577 {
    
    static int N, M, K;
    static boolean[][] width;
    static boolean[][] len;
    static int dy[] = {0, 1};
    static int dx[] = {1, 0};
    static long dp[][];
   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        width = new boolean[M+1][N+1];
        len = new boolean[M+1][N+1];

        dp = new long[M+1][N+1];
        
        for(int i = 0; i < M + 1; i++){
            for(int j = 0; j <= N; j++){
                dp[i][j] = -1;
            }
        }
                
        for(int i = 0 ; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            if(x1 == x2){
                len[Math.max(y2, y1)][x1] = true;
                
            }
            else {
                width[y1][Math.max(x1, x2)] = true;
            }
        }
        
        
        System.out.println(dfs(0,0));
       
    }

    static long dfs(int y, int x){
        // 도착
        if(y == M && x == N){
        
            return 1;
        }
        
        // 가본적 있으면
        if(dp[y][x] != -1){
            return dp[y][x];
        }

        dp[y][x] = 0;

            for(int i = 0; i < 2; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny <= M && nx <= N){
                    switch(i){
                        case 0 :
                            if(!width[ny][nx]){
                                // System.out.println(ny + " "  + nx);
                                dp[y][x] += dfs(ny, nx);
                                }
                            break;
                        case 1 :
                            if(!len[ny][nx]){
                                // System.out.println(ny + " "  + nx);
                                dp[y][x] += dfs(ny, nx);
                                }
                                break;
                        }
                    
                }
            }
        
        return dp[y][x];

    }
   
}
