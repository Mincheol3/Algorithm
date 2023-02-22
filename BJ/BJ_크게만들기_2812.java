import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_크게만들기_2812 {
    
    static StringBuilder sb;
    static int K, N;
    static Stack<Integer> s = new Stack<Integer>();
    static int[] c;
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        c = new int[N];
        String input = br.readLine();
        int cnt = 0;
        // st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = input.charAt(i) - '0';

            if(!s.isEmpty()){
                while(!s.isEmpty() && cnt < K){

                    if(s.peek() < num){
                        s.pop();
                    
                        cnt++;
                    }
                    else break;
                }
                
            }
            s.push(num);
            if (cnt == K){
                sb.append(input.substring(i+1));
                break;
            }
            
        }
        while(!s.isEmpty()){
            int num = s.pop();
            if(cnt < K){
                cnt++;
                continue;
            }
            sb.insert(0, num);
        }
       
        // int[] nums = new int[s.size()];
        // for(int i = s.size()-1; i > 0; i++ ){
        //     nums[i] = s.pop();

        // }
        // for(int i = 0; i < nums.length; i++){
        //     sb.append(nums[i]);
        // }

        System.out.println(sb);

    }
}
