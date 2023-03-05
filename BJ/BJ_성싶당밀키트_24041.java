import java.util.*;
import java.io.*;

public class BJ_성싶당밀키트_24041 {

    static int N, G, K;
    static ArrayList<Food> f0 = new ArrayList<Food>();
    static ArrayList<Food> f1 = new ArrayList<Food>();
    static Food[] food;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        food = new Food[N];

    
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());

            food[i] = new Food(s,l,o);
        }

        Arrays.sort(food, (f1,f2) -> {
            return f1.l == f2.l ? f2.s - f1.s : f1.l - f2.l;
        });

        long left = 1;
        long right = Integer.MAX_VALUE;

        while(left < right){

            long day = (left + right +1 )/2;
            if(check(day)) left = day;
            else right = day -1;
        }
        System.out.println(left);
        
    
    }
    static boolean check(long day){
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = N;
        int k = K;
        int idx = 0;
        while(idx < N){
            // if(food[idx].l >= day) break;
            long n = Math.max(1,food[idx].s *(day - food[idx].l));
            // System.out.println("day : " + day + " idx : " + idx + " " + "food[idx].l : " + food[idx].l + " "  + " n : " + n);
            if(food[idx].o == 1) pq.add(n);
            if(n!= 1)
            sum += (n-1);
            if(sum > G){
                while(sum > G){
                    if(k-- == 0 || pq.isEmpty()) return false;
                    sum-= pq.poll();
                }
            }
            idx++;
        }
        return true;
        
    }

    static class Food {

        int s;
        int l;
        int o;

        Food(int s, int l,int o) {
            this.s = s;
            this.l = l;
            this.o = o;
        }
    }
}
