import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class BJ_휴게소세우기_1477 {
    
    static int N, M, L;
    static int[] Arr;
    static int left , right;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Arr = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){

            Arr[i] = Integer.parseInt(st.nextToken());
        }
        Arr[0] = 0;
        Arr[N+1] = L;
        Arrays.sort(Arr);
        // 거리차이 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        left = 0;
        right = L;

        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
            
            for(int i = 1; i < N +2; i++){
                
                sum += (Arr[i] - Arr[i-1] -1) / mid;
            }

            if(sum > M) left = mid +1;
            else right = mid -1;
        }
        System.out.println(left);

        
        
    }
}
