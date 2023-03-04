import java.util.*;
import java.io.*;

public class BJ_호텔_1106 {
    
    static int C, N;
    static PriorityQueue<city> pq = new PriorityQueue<>((e1,e2) -> {

        if(e1.c == e2.c){
            if(e1.cost == e2.cost){
                return e1.div-e2.div;
            }
            else {
                double n = e1.cost;
                double c = e1.num;
                double n2 = e2.cost;
                double c2 = e2.num;
                int cc = 0;
                if (c/n > c2/n2) cc = 1;
                else cc = -1;
                if(cc== 1){
                    if(n > n2) return e2.cost-e1.cost;
                    else return e1.cost-e2.cost;
                }
                else {
                    if(n2>n) return e2.cost -e1.cost;
                    else return e1.cost-e2.cost;
                }
            }
        }
        else return e2.c - e1.c;
    });
    static class city{
        int cost;
        int num;
        int c;
        int div;
        city(int cost ,int num){
            this.cost = cost;
            this.num = num;
            c = num/cost;
            div = cost - num%cost;
        }
    }
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new city(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            
        }
        int pre = 30000;
        int ans = 0;
        int min = 3000000;
        int check = 0;
        while(!pq.isEmpty() && C != 0){
            
            int cost = pq.peek().cost;
            int num = pq.poll().num;
            System.out.println(cost + " " + num + " " + C);
            int div = C/num;
            int n = C%num;
            // System.out.println(C);
            if(div != 0){
                C -= div * num;
                if(C == 0){
                    min = Math.min(min, ans + div*cost);
                    // System.out.println(min);
                    break;
                }
            }
            System.out.println(pre + " " + div*cost + " " + min + " " + ans);
            if(pre > div*cost){
                ans += div * cost;
                // if(div == 0 && n != 0){
                min = Math.min(min, Math.min(ans+ cost, ans + pre));
                // }
                // else if(div != 0 && n !=0){
                //     min =Math.min(min, Math.min)
                // }
                pre = cost;
                check = 1;
            }
            // else {
            //     if(check == 0) check = 0;
            // }
            
            // System.out.println(ans);
        }
        // if(check ==0) System.out.println(ans);
        // else
        System.out.println(min);

    }
}
