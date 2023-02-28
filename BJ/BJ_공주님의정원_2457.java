import java.util.*;
import java.io.*;

public class BJ_공주님의정원_2457{

    static int N;
    static PriorityQueue<Flower> pq = new PriorityQueue<Flower>((f1,f2) -> f1.s== f2.s ? f1.e - f2.e : f1.s - f2.s);
    static PriorityQueue<Flower> select = new PriorityQueue<Flower>((f1,f2) -> f2.e - f1.e);
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        StringTokenizer st ;
        
        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken())*100;
            int sd = Integer.parseInt(st.nextToken());

            int em = Integer.parseInt(st.nextToken())*100;
            int ed = Integer.parseInt(st.nextToken());

            pq.add(new Flower(sm+sd, em+ed));


        }
        int ans = 1;
        // 3 월 1일전에 지는 꽃 필요없음.
        while(!pq.isEmpty() && pq.peek().e <= 301){
            pq.poll();
        }
        int s = 0;
        int e= 0;
        // 3월 1일 이전에 피
        while(!pq.isEmpty() && pq.peek().s <= 301){
            if(e <= pq.peek().e){
                e = pq.peek().e;
                s = pq.poll().s;
            }
            else pq.poll();
            // s = pq.peek().s;
            // e = pq.poll().e;
            if(e > 1130) {
                System.out.println(ans);
                return;
            }
        }
        select.add(new Flower(s, e));

        int pres = select.peek().s;
        int pree = select.peek().e;

        
        if(pree == 0){
            System.out.println(0);
            return;
        }
        // System.out.println(pres + " " + pree);
        int currs = 0;
        int curre = 0;
        while(!pq.isEmpty()){
            
            
            // 범위안에 들면
            while(!pq.isEmpty() && pree >= pq.peek().s){
                // if(pq.peek().s == pq.peek().e){
                //     pq.poll(); continue;
                // }
                if(select.peek().e <= pq.peek().e){
                    select.add(new Flower(pq.peek().s, pq.poll().e));
                }
                else pq.poll();
            }
            
            ans++;
            pree = select.peek().e;
            // System.out.println(select.peek().s + " " + pree);
            if(pree > 1130) {
                System.out.println(ans);
                return;
            }
            if(!pq.isEmpty() && pree < pq.peek().s) {
                System.out.println(0);
                return;
            }
            
        }

        System.out.println(0);


    }

    static class Flower{

        int s;
        int e;

        Flower(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
}