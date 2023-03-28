import java.io.*;
import java.util.*;

public class BJ_하늘에서별똥별_14658 {
    
    static int N, M, L, K,ans;
    static ArrayList<Star> stars = new ArrayList<Star>();
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i =0; i< K; i++){
            st = new StringTokenizer(br.readLine());

            stars.add(new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        ans = Integer.MAX_VALUE;
        int len = stars.size();
        for(int i =0; i < len; i++){
            int cx = stars.get(i).x;
            int cy = stars.get(i).y;
           
            for(int j = 0; j < len; j++){
                int cnt = 0;
                int nx = stars.get(j).x;
                int ny = stars.get(j).y;
                
               for(int k = 0; k < len; k++){
                int sx = stars.get(k).x;
                int sy = stars.get(k).y;

                if(sx >= cx && sx <= cx +L && sy >= ny && sy <= ny+L) cnt++;
                
               }
               ans = Math.min(ans, K-cnt);
            }
            
        }
        System.out.println(ans);
    }

    static class Star{

        int x;
        int y;

        public Star(int x, int y){
            this.x = x ;
            this.y = y;
        }
    }
}
