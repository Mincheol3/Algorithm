import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_자두나무_2240 {
    
    static int T,W;
    static int[] arr;
    static int[][][] dp; // 위치, 시간 ,이동 수
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[T + 1];
        
        for(int i = 1 ; i <= T; i++){
            arr[i] = Integer.parseInt(br.readLine());

        }

        dp = new int[3][T+1][W+1];

        dp[1][0][0] = 0;
        dp[2][0][0] = 0;

        //dp[위치][시간][이동횟수]
        //dp[1][t][w] = math.max(dp[1][t-1][w], dp[1][t-1][w-1]) + 현재 위치와 자두가 떨어지는 위치가 같으면 +1
        for(int i = 1; i <= T; i++){
            for(int j = 0; j <= W ; j++){
                // 1번나무에서 자두
                if (arr[i] == 1){
                    if(j == 0){ //움직이지 않았을 때
                        dp[1][i][j] = dp[1][i-1][j] +1;
                        continue;
                    }
                    // 1초전 이동 한 경우와 하지 않은 경우 중 큰 것
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]) +1;
                    dp[2][i][j] = Math.max(dp[2][i-1][j], dp[1][i-1][j-1]);
                }
                // 2번나무에서 자두
                else{
                    // 움직이지 않았을떄
                    if(j == 0){
                        dp[1][i][j] = dp[1][i-1][j];
                        continue;
                    }
                    dp[2][i][j] = Math.max(dp[2][i-1][j], dp[1][i-1][j-1]) +1;
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]);
                }
            }
        }

        int ans = 0;

        for(int i = 0; i <= W; i++){
            ans = Math.max(ans, Math.max(dp[1][T][i], dp[2][T][i]));
        }

        System.out.println(ans);

        
    }
}
