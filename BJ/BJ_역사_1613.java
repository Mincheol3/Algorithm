import java.util.*;
import java.io.*;

public class BJ_역사_1613 {
    
    static int n, k, s;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

       
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        boolean[][] Arr = new boolean[n+1][n+1];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            // union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            Arr[x][y] = true;
            
        }

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= n; j++){

                if(!Arr[j][i]) continue;

                for(int k = 1; k <= n; k++){
                    if(Arr[i][k]) Arr[j][k]= true;
                }
            }
        }

      

        s = Integer.parseInt(br.readLine());

        for(int i = 0; i < s; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(Arr[x][y] && !Arr[y][x]) sb.append(-1);
            else if(Arr[y][x] && !Arr[x][y]) sb.append(1);
            else if(!Arr[x][y] && !Arr[y][x]) sb.append(0);
            sb.append("\n");
            
        }
        System.out.println(sb.toString());
        
    }
}
