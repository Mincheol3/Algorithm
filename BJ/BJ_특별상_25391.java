import java.util.*;
import java.io.*;
public class BJ_특별상_25391 {
    
    static long ans;
    static int N, M, K;
    static ArrayList<Score> list = new ArrayList<>();
    static PriorityQueue<Score> pq = new PriorityQueue<>((e1,e2) ->e2.n1 == e1.n1 ? e1.n2 - e2.n2 : e2.n1 - e1.n1);
    static PriorityQueue<Score> selec = new PriorityQueue<>((e1,e2) -> e2.n2 == e1.n2 ? e2.n1 - e1.n1 : e2.n2 - e1.n2);
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // Collections.sort(list, (e1,e2)-> {

        //     return e2.n1 == e1.n1 ? e1.n2 - e2.n2 : e2.n1 - e1.n1;
        // });

        for(int i = 0 ; i < M; i++){
            ans += pq.poll().n1;
            // list.remove(0);
        }
        for(int i = 0; i < K; i++){
            ans += pq.peek().n1;
            selec.add(pq.poll());
        }
        while(!pq.isEmpty()){
            if(selec.peek().n2 < pq.peek().n2){
                ans -= selec.poll().n1 + pq.peek().n1;
                selec.add(pq.poll());
            }
        }
       

        // Collections.sort(list, (e1,e2)-> {

        //     return e2.n2 == e1.n2 ? e2.n1 - e1.n1 : e2.n2 - e1.n2;
        // });
        // for(int i  = 0 ; i < K; i++){
        //     ans += list.get(i).n1;
        //     // list.remove(0);
        // }
        
        System.out.println(ans);
    }
    static class Score{

        int n1;
        int n2;

        public Score(int n1, int n2) {

            this.n1 = n1;
            this.n2 = n2;
        }
    }
}
