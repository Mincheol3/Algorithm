import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_에라토스테네스의체_2960 {
    static int N, K;
    static int ans, cnt;
    static int[] arr;
    static boolean[] prime;
    public static void main(String[] args) throws Exception {
            
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        prime = new boolean[N+2];
        int cnt = 0;
        for(int i = 2; i <=N; i++){
            
            if(!prime[i]){
                System.out.println(i);
                for(int j = i; j <= N; j+= i){
                    if(!prime[j]){
                    prime[j] = true;
                    cnt++;
                    }
                    if(cnt ==K){
                        System.out.println(j);
                        return;
                    }
                }
            }
        } 
        // arr = new int[N+2];
        // for(int i = 2; i <= N; i++){
        //     arr[i] = i; 
        // }
        // for(int i = 2; i <= N; i++){
        //     if(arr[i] == 0) continue;

        //     for(int j = i; j <=N; j+=i){
        //         if(arr[j] != 0){
        //             arr[j] = 0;
        //             cnt++;
        //             if(cnt == K){
        //                 System.out.println(j);
        //                 return;
        //             }
        //         }
        //     }
        // }
    }
}
