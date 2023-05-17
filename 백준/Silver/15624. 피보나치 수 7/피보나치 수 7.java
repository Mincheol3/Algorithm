import java.util.*;

import javax.sound.midi.SysexMessage;

import java.io.*;

public class Main {
    static int dp[];
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+2];
        dp[0] = 1; 
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-2] + dp[i-1])%1000000007;
        }

        System.out.println(dp[n]);

    }
    static int fibo(int num){

        if(num ==1 || num == 2) return 1;

        return dp[num-1]+dp[num-2];
    }
}
