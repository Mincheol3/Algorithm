import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_개똥벌레2_3020 {
    
    static int N, H;
    static int Arr1[], Arr2[];
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Arr1 = new int[H+1];
        Arr2 = new int[H+1];
        int[] Arr3 = new int[N+1];
        for(int i = 0; i < N/2; i++){
        
            Arr1[Integer.parseInt(br.readLine())]++;
            Arr2[H - Integer.parseInt(br.readLine())+1]++;
        }
        Arrays.sort(Arr2);
        Arrays.sort(Arr1);

        for(int i = 1; i <= H; i++){
            Arr1[i] += Arr1[i-1];
        }
        for(int i = H-1; i >= 0; i--){
            Arr2[i] += Arr2[i+1];
        }
        int min = N;
        int ans = 0;
        int cnt = 0;
        for(int i = 1; i <= H; i++){
            min = 0;
            min += Arr1[H] - Arr1[i];
            min += Arr2[H] = Arr2[i];

            if(ans > min){
                ans = min;
                cnt = 1;
            }
            else if(ans == min){
                cnt++;
            }
        }
        System.out.println(ans + " " + cnt);
    }
}
