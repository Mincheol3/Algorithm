import java.util.*;
import java.io.*;

public class BJ_커플만들기2_1727 {

    static int n, m;
    static long ans;

    static int[] male, female;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
    
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] man = new int[n + 1];
        int[] woman = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; ++i) {
            man[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; ++i) {
            woman[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(man);
        Arrays.sort(woman);
        
        //dp[i][j] : (1~i)까지의 남자와 (1~j)까지의 여자를 커플 매칭했을때 성격 차이 최소값
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                //i번 남자와 j번 여자 커플 매칭
                dp[i][j] = dp[i - 1][j - 1] + Math.abs(man[i] - woman[j]);
                //남자가 더 많으면 추가된 i번 남자 솔로
                if (i > j) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                //여자가 더 많으면 추가된 j번 여자 솔로
                else if (i < j) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                
                System.out.println("i :" + i + " j :" + j + " dp[i][j] :" +dp[i][j] + " dp[i-1][j] " + dp[i-1][j] + " dp[i][j-1] :" +dp[i][j-1] );
            }
        }
        bw.write(dp[n][m] + "\n");
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
