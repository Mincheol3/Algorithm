import java.util.*;
import java.io.*;
public class BJ_순회강연_2109 {
    
    static int N;
    static PriorityQueue<lecture> pq = new PriorityQueue<>((e1,e2)-> e1.d == e2.d ? e2.p - e1.p : e1.d - e2.d);
    static PriorityQueue<Integer> select = new PriorityQueue<>();
    static class lecture{

        int d;
        int p;

        lecture(int p, int d){
            this.d =  d;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i =0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while(!pq.isEmpty()){

            lecture lec = pq.poll();
            int day = lec.d;
            int pay = lec.p;
            if(select.size() < day) select.add(pay);

            else{
                if(select.peek() < pay){
                    select.poll();
                    select.add(pay);
                }
            }
        }
        int ans = 0;
        while(!select.isEmpty()){
            ans += select.poll();
        }

        System.out.println(ans);
    }
}
