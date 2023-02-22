import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_커플만들기_1727 {
    
    static int n, m;
    static long ans;
    
    static PriorityQueue<Integer> male = new PriorityQueue<Integer>();
    static PriorityQueue<Integer> female = new PriorityQueue<Integer>();
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int N = Math.max(n, m);
        int M = Math.min(n, m);

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            male.offer( Integer.parseInt(st.nextToken()));
        }
        // Arrays.sort(male);
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++){
            female.offer(Integer.parseInt(st.nextToken()));
        }
        // Arrays.sort(female);

        int cnt = 0;

        if(male.size() > female.size()){

            while(cnt < M){
                int f = female.poll();
                int man = male.poll();
                int p = male.peek();
                
                while(male.size() > 1){
                    if(Math.abs(f - man) > Math.abs(f -p)){
                        s.push(man);
                        man = male.poll();
                        p = male.peek();
                    }
                    else break;
                }
                if(Math.abs(f - man) < Math.abs(s.peek() - f)){
                    ans += Math.abs(f - man);
                }
                else{
                    ans+= Math.abs(s.pop() -f);
                    s.push(man);
                }
                cnt++;
                // 현재가 다음보다 작을때
                // if(Math.abs(f -man) <= Math.abs(f - p)){
                //     if(Math.abs(f - man) < Math.abs(s.peek() - f)){
                //     ans += Math.abs(f - man);
                //     }
                //     else{
                //         ans+= Math.abs(s.pop() -f);
                //         // 다시 큐에 추가 ?
                //         s.push(man);
                //     }
                //     continue;
                // }
                // // 현재가 다음보다 클 때

                // else{
                    
                // }
            }
        }
        


    }
}
