import java.io.*;
import java.util.*;

public class BJ_밥_23559 {
    static int N, X, ans;
    static ArrayList<int[]> score = new ArrayList<int[]>();
    static PriorityQueue<Menu> menus = new PriorityQueue<>((e1, e2) -> e2.dif - e1.dif);

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         X = Integer.parseInt(st.nextToken());
         X -= 1000*N;
         for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ans += b;

            menus.add(new Menu(a, b));
         }

         while(X >= 4000){
            if(menus.peek().dif <= 0) break;
            ans += menus.poll().dif;
            X -= 4000;
         }

         System.out.println(ans);
        
    }

    static class Menu {

        int a;
        int b;
        int dif;

        Menu(int a, int b) {
            this.a = a;
            this.b = b;
            dif = a - b;
        }
    }
}
