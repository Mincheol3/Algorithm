import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_미팅의저주_17268 {
    
    static int N, ans;
    static long[] dp;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[100001];
        dp[0] = 1;
        dp[2] = 1;
        dp[4] = 2;
        dp[6] = 5;
        //dp
        // dp[4] = dp[2] * dp[0] + dp[2] * dp[0];
        // dp[6] = dp[4]*dp[0] + dp[2] * dp[2] + dp[0]*dp[4];
        // dp[8] = dp[6] * dp[0] + dp[2] * dp[4] +  
        for(int i = 8; i  <= N; i+=2){
            for(int j = 0; j <= i-2; j+=2){

                dp[i] += dp[j]*dp[i-j-2];
                dp[i] %= 987654321;   
            }
        }

        System.out.println(dp[N]);
        
        


    }

}
