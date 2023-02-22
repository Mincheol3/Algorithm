import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_동물원_12907 {
    
    static int N, sum;
    static int[] num;
    static int[] check;
    static int max;

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        check = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());

            if(num[i] >= N) {
                System.out.println(0);
                return;
            }
            check[num[i]]++;

        }
        

        for(int i = 0; i < N; i++){
            // 같은 키 2 마리 초과 안댐
            if(check[i] > 2) {
                System.out.println(0);
                return;
            }
            // 큰놈이 작은놈보다 많으면 안댐
            if(i != N-1 && check[N - 1 - i] > check[N -2 -i]){
                System.out.println(0);
                return;
            }
            if(check[i] == 2){
                max++;
            }
        }
        // 처음부터 끝까지 쌍으로 이루어 졌을경우 지수 + 1 할 필요 없음!!!
        if(N % 2 == 0 && max == N / 2){
            System.out.println((int)Math.pow(2, max));
            return;
        }
     
        System.out.println((int)Math.pow(2, max+1));
        // System.out.println(2*2*max);

    }

  
}
