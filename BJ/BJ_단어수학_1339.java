import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_단어수학_1339 {
    
    static int N, ans;
    static int alpha[];
    static String[] word;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        alpha = new int[26];
        word = new String[N];
        for(int i = 0 ; i < N ; i++){
            word[i] = br.readLine();
        }

        for(int i = 0; i < N; i ++){
            int len = word[i].length();
            int n = (int)Math.pow(10, len-1);
            
            for(int j = 0; j < len ; j++){
                alpha[(int)word[i].charAt(j)-65] += n;
                n /= 10;
            
            }
        }

        Arrays.sort(alpha);

        int num = 9;

        for(int i = alpha.length - 1; i >= 0; i--){
            if(alpha[i] == 0) break;

            ans += alpha[i]*num;
            num--;
        }

        System.out.println(ans);

    }
}
