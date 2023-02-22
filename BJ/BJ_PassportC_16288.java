import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_PassportC_16288 {
    
    static int N, K;
    static int pass[];
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pass = new int[K];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            q.offer(Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        int pre = q.peek();
        
        for(int i = 0; i < N; i++){

            for(int j = 0; j < K; j++){
                if(pass[j] < pre){
                    pass[j] = pre;
                    q.poll();
                    if(!q.isEmpty()) pre = q.peek();
                    cnt++;
                    // System.out.println("창구" + j + " " + pass[j] + " " + "다음사람" + pre);
                    break;
                }
            }
        }
        if(cnt ==N) System.out.println("YES");
        else System.out.println("NO");
    }
}
