import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_교환_1039 {
    static int N, K, ans;
    static int[] num;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[7];
        int i = 1;
        int cnt = 0;
        while(N / i >= 1){
            i *= 10;

            num[cnt] = (N % i - N % (i/10)) / (i/10);
            cnt++;
        }
        int total = cnt-1;
        // System.out.println(num[3]);
        if(cnt == 1 && K >0){
            System.out.println(-1);
            return;
        }
        if(cnt == 2){
            if(num[0] ==0 && K % 2 == 0) {
                System.out.println(-1);
                return;
            }
            else if(num[1] == 0 && K % 2 == 1){
                System.out.println(-1);
                return;
            }
        }
        while(K > 0){
            boolean ck = false;
            for(int j = cnt-1; j > 0; j--){
                int max = num[j];
                // System.out.println("처음 max : " + max );
                int idx = 0;
                for(int k = j-1; k >= 0; k--){
                    if(check(max, k)){
                        max = Math.max(max, num[k]);
                        idx = k; 
                        ck = true;
                        // System.out.println("num k :" + num[k] );
                    }
                }
                // System.out.println("최종 max " + max);
                // System.out.println("j : " + j );
                // System.out.println("idx :" + idx);
                if(ck){
                    int pre = num[j];
                    num[j] = max;
                    num[idx] = pre;
                    cnt--;
                    break;
                }
            }
            // System.out.println(ck);
            if(!ck){
                int n = 1;
                if(K % 2 == 0){
                    for(int t = 0; t <= total; t++){
                        ans  += num[t] * n;
                        n*= 10; 
                    }
                }
                else {
                    boolean same = false;
                    for(int v = 0; v < total; v++){
                        if(num[v] == num[v+1]) same = true;
                    }
                    if(same){
                        for(int t = 0; t <= total; t++){
                            ans  += num[t] * n;
                            n*= 10; 
                        }
                    }
                    else{
                        int n2 = 1;
                        int n3 = num[0];
                        num[0] = num[1];
                        num[1] = n3;
                        for(int t = 0; t <= total; t++){
                            ans += num[t]*n2;
                            n2*=10;
                        }
                    }
                    
                }
                break;
            }
            K--;
            if(K == 0){
                int n3= 1;
                for(int l = 0; l < total+1; l++){
                    ans += num[l]*n3;
                    n3*=10;
                }

            }
        }
      
        System.out.println(ans);
    }

    static boolean check(int n, int n2){
        if(n <= num[n2]) return true;

        return false;
    }
}
