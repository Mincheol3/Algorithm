import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_돌다리건너기_2602 {
    
    static char[] str, angel, devil;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        str =  br.readLine().toCharArray();
        devil = br.readLine().toCharArray();
        angel = br.readLine().toCharArray();

        int size = str.length ;
        int size2 = angel.length;
        int[][][] dp= new int[2][size][size2];

        if(str[0] == devil[0]) dp[1][0][0] = 1;
        if(str[0] == angel[0]) dp[0][0][0] = 1;

        for(int i =1; i < size2 ; i++){

            dp[0][0][i] = dp[0][0][i-1];
            dp[1][0][i] = dp[1][0][i-1];

            if(devil[i] == str[0]){
                dp[1][0][i] += 1;
            }
            if(angel[i] == str[0]){
                dp[0][0][i] += 1;
            }

            for(int j = 1; j < size; j++){
                dp[0][j][i] += dp[0][j][i-1];
                dp[1][j][i] += dp[1][j][i-1];

                if(devil[i] == str[j]) dp[1][j][i] += dp[0][j-1][i-1];
                if(angel[i] == str[j]) dp[0][j][i] += dp[1][j-1][i-1];
            }
        }
        System.out.println(dp[0][size-1][size2-1] + dp[1][size-1][size2-1]);
    }
}
