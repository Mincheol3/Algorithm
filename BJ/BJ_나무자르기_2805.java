import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_나무자르기_2805 {
    
    static int N, M;
    static long ans;
    static int tree[];
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];
        int max = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(max, tree[i]);
        }

        int low = 0;
        int high = 2000000000;
        int H = 0;

        while(low <= high){
            long m = 0;
            H = (low + high)/ 2;
            for(int i = 0 ;i < N; i++){
                m += tree[i] > H ? tree[i] - H : 0;
            }
            if(m < M){
                high = H -1;
            }
            else {
                ans = H;
                low = H +1;
            }
        }
        System.out.println(ans);
        
    }
}
