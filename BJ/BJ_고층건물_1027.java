import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_고층건물_1027 {
    static int ans;    
    static int N;
    static int[] Arr;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        
        for(int i = 0 ; i < N; i++){
            float pre = Integer.MIN_VALUE;
            int max = 0;
            //오른쪽
            for(int j = i; j < N; j++){
                if(i == j) continue;
                float lean = slope(Arr[i], Arr[j], j - i);
                if(pre < lean ){
                    max++;
                    pre = lean;
                }
            }
            // 왼쪽
            pre = Integer.MAX_VALUE;
            for(int k = i; k >= 0; k--){
                if(i == k) continue;
                float lean = slope(Arr[i], Arr[k], k - i);
                if(pre > lean ){
                    max++;
                    pre = lean;
                }
                
            }
            if(Math.max(ans, max) == max) System.out.println(i);
            ans = Math.max(max, ans);
        }
        System.out.println(ans);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
    static float slope(int n1, int n2, int n3){
        
        float  y = n2 - n1;
        
        return y / n3;
    }
}
