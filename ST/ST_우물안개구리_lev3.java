import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ST_우물안개구리_lev3 {
    
    static int N, M;
    static int weight[];
    static boolean[] isbest;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        weight = new int[N+1];
        isbest = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            isbest[i] = true;
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(isbest[n1] || isbest[n2]){
                if(weight[n1] < weight[n2]) isbest[n1] = false;
                else if(weight[n1] == weight[n2]){
                    isbest[n1] = false;
                    isbest[n2] = false;
                }
                else isbest[n2] = false;
            }
            
        }
        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(isbest[i]) ans++;
        }
        System.out.println(ans);
    }
}
