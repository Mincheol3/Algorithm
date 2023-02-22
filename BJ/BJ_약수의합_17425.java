import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BJ_약수의합_17425 {
    
    static int aws;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        long[] G = new long[1000001];
        G[1] = 1;

        for(int i = 2; i < 1000000; i++ ){
            G[i] = G[i-1] + yak(i);
        }
        for(int T = 0 ; T < N; T++){
            aws = 0;
            int n = Integer.parseInt(br.readLine());
            // Yak(n);
            sb.append(G[n]).append("\n");
            
        }
        System.out.println(sb.toString());
        
        
    }
    
    static int yak(int n){
        aws = 0;
        int sqrt = n / 2;
        aws += n;
        for(int i = 1 ; i <= sqrt; i++){
            if( n % i == 0) aws += i; 
        }
        return aws;
    }
    static void Yak(int n ){
        for(int i = n; i >= 1; i--){
            if(i != 1) aws+= i;
            else aws += 1;
            // int sqrt = (int)Math.sqrt(i);
            // System.out.println(sqrt);
            int sqrt = i/2;
            for(int j = 1; j <= sqrt; j++){
                if(i % j == 0) aws += j;
            }
        }
    }
}

