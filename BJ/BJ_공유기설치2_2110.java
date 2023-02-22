import java.util.*;
import java.io.*;

public class BJ_공유기설치2_2110 {
    
    static int N, C;
    static int[] home, index;
    static int ans;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        home = new int[N];
        index = new int[C];
        for(int i = 0; i < N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int low = 1;
        int high = home[N-1] - home[0];
        int d = 0;
        
        while(low <= high){

            int mid = (low + high) / 2;
            int start = home[0];
            int cnt  = 1;

            for(int i = 0 ; i < N; i++){
                d = home[i] - start;

                if(d >= mid){
                    cnt++;
                    start = home[i];
                }
            }
            if(C > cnt){
                high = mid - 1 ;
            }
        
            else {
                ans = mid;
                low = mid+1;
            }
        }
        System.out.println(ans);
    }
}
