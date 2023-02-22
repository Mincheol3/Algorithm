import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_공유기설치_2110 {
    
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
        comb(0,0);
        System.out.println(ans);
    }

    static void comb(int idx, int cnt){

        if(cnt == C){
            cnt = 0;
            
            // System.out.println(index[0]);
            // System.out.println(index[1]);
            // System.out.println(index[2]);

           ans = Math.max(ans, len(index));
            return;
        }

        for(int i = idx; i < N; i++){
            index[cnt] = i;
            comb(i + 1, cnt+1);
            // comb(idx + 1, cnt);
        }
    }

    static int len(int[] Arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < C-1; i++){
             min = Math.min(min,Math.abs(home[Arr[i]] - home[Arr[i+1]]));
             
        }
        // System.out.println(min);
        return Math.abs(min);
    }
}
