import java.io.*;
import java.util.*;

public class BJ_드래곤앤던전2_16434 {
    
    static int N; 
    static long Atk, maxHp, curHp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Atk = Integer.parseInt(st.nextToken());
        long maxHp = 0;
        long curHp = 0;

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(t == 1){
                curHp += (h / Atk - (h % Atk == 0 ? 1 : 0)) * a;
                maxHp = Math.max(curHp, maxHp);
            }
            else if(t == 2){
               Atk += a;
               curHp = Math.max(curHp - h, 0);
                
            }
           
        }
        System.out.println(maxHp+1);
    }
}
