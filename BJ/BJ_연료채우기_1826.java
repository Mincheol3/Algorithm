import java.util.*;
import java.io.*;

public class BJ_연료채우기_1826 {
    
    static int ans;
    static int N, a, b;
    static Fuel[] fuels;
    static PriorityQueue<Integer> exclude = new PriorityQueue<Integer>(Collections.reverseOrder());
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        fuels = new Fuel[N];
        StringTokenizer st;
        int sum = 0;
        for(int i  = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sum += v;
            fuels[i] = new Fuel(x, v);
        }
        Arrays.sort(fuels, new Comparator<Fuel>() {
            
            @Override
            public int compare(Fuel f1, Fuel f2){
                return f1.x - f2.x;
            }
        });
    

        st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(sum + P < L) System.out.println(-1);

        else{
            sum = P;
            for(int i = 0; i < N; i++){
                int x = fuels[i].x;
                int v = fuels[i].v;
                // System.out.println(x + " " + v);
                if(P > x){
                  
                    exclude.add(v);
                }
                else if(P == x){
                    // ans++;
                  
                    exclude.add(v);
                }
                else{
                    while(!exclude.isEmpty()){
                        if(P >= x) break;
                        P += exclude.poll();
                        // System.out.println(P);
                        ans++;
                    }
                    if(P < x) {
                        System.out.println(-1);
                        return;
                    }
                    exclude.add(v);
                    
                }
                if(P >= L) break;
            }
            while(!exclude.isEmpty()){
                if(P >= L) break;
                P += exclude.poll();
                // System.out.println(P);
                ans++;
            }
            if(P < L) ans = -1;
            System.out.println(ans);
        }
        
    }
    static class Fuel{
        int x;
        int v;

        Fuel(int x, int v){
            this.x = x;
            this.v =v;
        }
    }
}
