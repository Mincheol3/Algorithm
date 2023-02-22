import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_최소회의실_19598 {
    // (e1, e2) -> e1.e == e2.e ? e2.s - e1.s : e2.e-e1.e
    static int N;
    static ArrayList<conference> conf = new ArrayList<conference>();
    //시작 시간 순으로. 시작시간이 같으면 종료가 빠른것 우선
    static PriorityQueue<conference> pq = new PriorityQueue<conference>((e1, e2) -> e1.s == e2.s ? e1.e - e2.e : e1.s-e2.s);
    static boolean check[]; 
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        N = Integer.parseInt(br.readLine());
        check = new boolean[N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new conference(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }

        int ans = 0;
        // 종료시간 순으로, 종료시간 같으면 시작시간 빠른것
        PriorityQueue<conference> pq2 = new PriorityQueue<conference>((e1, e2) -> e1.e == e2.e ? e1.s - e2.s : e1.e-e2.e);
        
        
        
        while (!pq.isEmpty()){

            conference next = pq.poll();
            pq2.offer(next);
            
            // 시작시간 순으로 뽑아냄.
            while(!pq.isEmpty() && pq.peek().s == next.s){
                pq2.offer(pq.poll());
            }
            // 종료시간이 뽑아낸 시작시간 보다 작으면 같은 회의실에서 진행가능
            // ==> poll 해줌
            while(!pq2.isEmpty() && pq2.peek().e <= next.s){
                pq2.poll();
            }
            // ans 가 max 일때 사용해야하는 회의실 갯수
            ans = Math.max(ans, pq2.size());
        }
        System.out.println(ans);
    }
    
    static class conference{
        int s;
        int e;

        conference(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
