import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_모독_16678 {
    
    static int N;
    static long ans;
    static int honor[];
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        honor = new int[N];
        for(int i = 0; i < N; i++){
            honor[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(honor);

        int defile = 1;
        for(int i = 0; i < N; i++){
            
            honor[i] -= defile;
            if(honor[i] >= 0){ 
                ans+=honor[i];
                defile++;
            }
            
        }
        System.out.println(ans);
    }
}
