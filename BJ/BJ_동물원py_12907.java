import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_동물원py_12907 {
    
    static int N;
    static int[] list;
    static int[] dict;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new int[N];
        dict = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < N ; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n >= N) {
                System.out.println(0); return;
            }
            dict[n]++;
        }

         int len = 0;
        for(int i = 0 ; i <= N ; i++) {
            // System.out.println(dict[i]);
            if(dict[i] == 0){
                len = i;
                break;
            }
            else dict[i]--;
        }

        int len2 = 0;
        for(int i = 0 ; i <= N ; i++) {
            if(dict[i] == 0){
                len2 = i;
                break;
            }
            else dict[i] --;
        }

        boolean check = false;

        for(int i = 0 ; i <= N; i++){
            if(dict[i] > 0){
                check = true;
                break;
            }
        }

        // System.out.println(len + " " + len2);
        if(check) System.out.println(0);
        else if(len == len2){
            System.out.println(1 << (len2));
        }
        else System.out.println(1 << (len2+1));
    }

}
