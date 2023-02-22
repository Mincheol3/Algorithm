import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BJ_동전1_2293 {
    static int n, k;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] val = new int[n];
        int[] dp = new int[k+1];
        for(int i = 0 ; i < n ; i++){
            val[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k; j++){
                if(j >= val[i]) dp[j] += dp[j - val[i]];
            }
        }
        System.out.println(dp[k]);
    }
    
}
