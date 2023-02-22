import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_도서관_1461 {
    
    static int N, M,ans;
    static int book[];
    
    static PriorityQueue<Integer> plus = new PriorityQueue<>((e1,e2) -> e2 - e1);
    static PriorityQueue<Integer> minus = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n > 0) plus.add(n);
            else minus.add(n);
        }
        if(plus.isEmpty()){
            ans += Math.abs(minus.peek());
            int size = minus.size();
            if(size > M){
                for(int i = 0; i < M; i++){
                    minus.poll();
                }
            }
            else minus.clear();
        }
        else if(minus.isEmpty()){
            ans += plus.peek();
            // System.out.println(plus.peek());
            int size = plus.size();
            if(size > M){
                for(int i = 0; i < M; i++){
                    plus.poll();
                }
            }
            else plus.clear();
        }
        else{
        if( plus.peek() >= Math.abs(minus.peek())){
            ans += plus.peek();
            // System.out.println(plus.peek());
            int size = plus.size();
            if(size > M){
                for(int i = 0; i < M; i++){
                    plus.poll();
                }
            }
            else plus.clear();
            
        }
        else{
            // System.out.println(minus.peek());
            ans += Math.abs(minus.peek());
            int size = minus.size();
            if(size > M){
                for(int i = 0; i < M; i++){
                    minus.poll();
                }
            }
            else minus.clear();
        }
    }
        
        while(!plus.isEmpty()){
            // System.out.println(plus.peek());
            ans+= plus.peek() * 2;
            int size = plus.size();
            if(size > M){
                for(int i = 0; i < M; i++){
                    plus.poll();
                }
            }
            else plus.clear();
        }

        while(!minus.isEmpty()){
            // System.out.println(Math.abs(minus.peek()));
            ans+= Math.abs(minus.peek()) * 2;
            int size = minus.size();
            if(size > M){
                for(int i = 0; i < M; i++){
                    minus.poll();
                }
            }
            else minus.clear();
        }

        System.out.println(ans);

    }
}
