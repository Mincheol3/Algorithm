import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ST_업무처리_lev3 {
    
    static int N, K, R;
    static StringTokenizer st;
    static ArrayList<int[]> arr = new ArrayList<int[]>();
    static int dp[][];
    public static void main(String[] args) throws Exception {
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        dp = new int[(int)Math.pow(2, N)][2];

        for(int i = 0; i < Math.pow(2, N); i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++){
                int n = Integer.parseInt(st.nextToken());
                arr.get(i)[j] = n;
             
            }
        }
        int T = 0;
        while(T < 0){
            if(T <= K){
        
            }
            
        }
    }
}
