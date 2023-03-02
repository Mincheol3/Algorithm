import java.util.*;

import java.util.*;

import java.io.*;

public class BJ_내일할거야_7983 {
    
    static int n;
    static PriorityQueue<Report> pq = new PriorityQueue<Report>((e1,e2) -> e2.t == e1.t ? e2.d - e1.d : e2.t - e1.t);
    static class Report{

        int d;
        int t;

        Report(int d, int t) {
            this.d = d;
            this.t = t;
        }
    }
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new Report(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        int min = Integer.MIN_VALUE;
        int day = pq.peek().t;
        int pre = day;
        int ans = day;
        while(!pq.isEmpty()){

            Report r = pq.poll();

            if(pre == r.t){
                day -= r.d;
            }
            else {
                min = Math.max(min, day - r.t);
                if(day > r.t){
                    day = r.t - r.d;
                }
                else{
                    day -= r.d;
                }
                
                pre = r.t;
            }
            

        }
        min = Math.max(min, day);
        System.out.println(day);
    }
}
