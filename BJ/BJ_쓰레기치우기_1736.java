import java.io.*;
import java.util.*;


public class BJ_쓰레기치우기_1736 {
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        

        int map[][] = new int[N+1][M+1];
        int max[] = new int[N+1];
        int min[] = new int[N+1];
        int minv = 102;
        int maxv = -1;
        min[0] =  102;
        max[0] = -1;
        boolean visit[] = new boolean[M];
        for(int i = 1; i <= N; i ++){
            st = new StringTokenizer(br.readLine());
             max[i] = -1;
             min[i] = 101;
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                   max[i] = Math.max(max[i], j);
                   min[i] = Math.min(min[i], j);
                }
                
            }
        }
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        for(int i = 1; i <= N; i++){
            // 쓰레기가 없는곳이면
            System.out.println(Arrays.toString(max));
            System.out.println(Arrays.toString(min));
            if(min[i] == 101) continue;
            // 이전의 min 값보다 작거나 min 보다 크더라도 max 값보다 작으면
            if((min[i-1] != 101 && min[i] < min[i-1]) || min[i] < max[i-1]){
                System.out.println(i);
                ans++;
                for(int j = i+1; j <= N; j++){
                    System.out.println(max[i] + " " + j);
                    if(min[j] == 102){
                        min[j] = max[i];
                        max[j] = max[i];
                    }
                    else if(max[i] <= min[j]){
                        min[j] = 102;
                        max[i] = max[j];
                        max[j] = -1;
                    }
                    else if(max[i] > min[j] && max[i] <= max[j]){
                        // System.out.println(i + " " + j);
                        // System.out.println(max[j]);
                       
                        int n = max[j];
                        for(int q = min[j]; q < max[i]; q++){
                            if(map[j][q] == 1){
                                max[j] = Math.max(min[j], q);
                            }
                            
                        }
                        max[i] = n;
                        // System.out.println("aa" + max[j]);
                    }
                }
            }
        }
         System.out.println(ans);
        
    }
}
