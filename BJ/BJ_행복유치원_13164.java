import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_행복유치원_13164 {
    
    static int N, K;
    static long[] h;
    static long[] gap;
    static long ans;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        h = new long[N];
        gap = new long[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N-1; i++){
            gap[i] = h[i+1] - h[i];
        }

        Arrays.sort(gap);

        for(int i =0; i < N- K; i++){
            ans+= gap[i];
        }
        System.out.println(ans);
    }
}
