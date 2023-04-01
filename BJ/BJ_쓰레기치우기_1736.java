import java.io.*;
import java.util.*;


public class BJ_쓰레기치우기_1736 {
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        

        int map[][] = new int[N+1][M+1];
        // int max[] = new int[N+1];
        // int min[] = new int[N+1];
        int minv = 102;
        int maxv = -1;
        // min[0] =  102;
        // max[0] = -1;
        int trash = 0;
        boolean visit[] = new boolean[M];
        for(int i = 1; i <= N; i ++){
            st = new StringTokenizer(br.readLine());
            //  max[i] = -1;
            //  min[i] = 101;
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    trash++;
                //    max[i] = Math.max(max[i], j);
                //    min[i] = Math.min(min[i], j);
                }
                
            }
        }
        int ans =0;
        int cnt = 1;
        while(trash > 0){
            int max = 0;
            // System.out.println(ans + " " + cnt);
            for(int i = cnt; i <= N; i++){
                for(int j = max; j <= M; j++){
                    if(map[i][j] == 1){
                        // System.out.println(i+ " " + j);
                        map[i][j] =0;
                        trash--;
                        max = Math.max(max, j);
                    }
                }
            }
            ans++;
            cnt++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
       
         System.out.println(ans);
        
    }
}
