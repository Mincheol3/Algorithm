import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_과제_13904 {
    
    static int N;
    static PriorityQueue<report> pq = new PriorityQueue<report>((r1,r2) -> r1.d == r2.d ? r2.w - r1.w : r1.d - r2.d);
    static PriorityQueue<Integer> select = new PriorityQueue<Integer>();
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new report(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        while(!pq.isEmpty()){
            report r = pq.poll();
            int d = r.d;
            int w = r.w;

            if(select.size() <d){
                select.add(w);
            }
            else if(select.size() == d){
                if(select.peek() < w){
                    select.poll();
                    select.add(w);
                }
            }

        }
        int ans = 0;
        while(!select.isEmpty()){
            ans+= select.poll();
        }
        System.out.println(ans);
        


    }

    static class report{
        int d;
        int w;

        report(int d, int w){
            this.d = d;
            this.w = w;
        }
    }
}
