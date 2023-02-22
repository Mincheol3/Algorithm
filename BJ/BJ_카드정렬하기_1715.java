import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_카드정렬하기_1715 {
    
    static int N , ans;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(pq.size() > 1){
            int n = pq.poll();
            int n2 = pq.poll();
            ans +=(n +n2);
            pq.add(n + n2);
        }

        System.out.println(ans);

    }
}
