import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_독수리_16238 {
    
    static int N, day;
    static Integer sheep[];
    static long ans;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sheep = new Integer[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            sheep[i] = Integer.parseInt(st.nextToken());
        }
        sheep[0] = -1;
        Arrays.sort(sheep,Collections.reverseOrder());
        int idx =0;
        int day = 0;
        while(idx!= N+1 && sheep[idx] - day > 0){
            ans += sheep[idx++] - day++;
            
        }
        System.out.println(ans);
    }
}
