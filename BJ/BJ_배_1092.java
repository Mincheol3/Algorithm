import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_배_1092 {

    static int[] nums;
    static int N, M, ans;
    static Integer[] crane;
    static PriorityQueue<Integer> box = new PriorityQueue<>((e1, e2) -> e2 - e1);
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        crane = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane, Collections.reverseOrder());

        M = Integer.parseInt(br.readLine());
        // box = new Integer[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        if (box.peek() > crane[0]) {
            System.out.println(-1);
            return;
        }

        int i = 0;
        int cnt = 0;
        int c = 0;
         nums = new int[N];
        while (!box.isEmpty()) {
            // if(cnt % N == 0) c++;
            i %= N;
            int n = box.poll();

            // crane =    4 3 2 1 
            // box =  4 4 3 3 2 1 1

            // nums =  2 2 2 2
            if(n > crane[i]){
                nums[i-1]++;
                // System.out.println(n + " " + (i-1) + " " + nums[i-1]);
                i--;
            }
            else{
                if(i == N-1){
                    nums[i] = M-c;
                    break; 
                }
                else nums[i]++;
                // System.out.println(n + " " + i + " " + nums[i]);
               }
            i++;
            c++;
            // else {
            //     nums[i]++;
            //     i++;
            // }
            // cnt++;
           
            // i%=N;
            
        }
        // nums  =   2  4 // 6  10
        // 3 3 
        // System.out.println(nums[2]);
        int na = 0;
        ans = Math.max(ans, nums[0]);
        for(int t =0; t < N-1; t++){
            
            int n = nums[t];
            int n2 = nums[t+1];
            // System.out.println(n + " " + n2 + " " + na);
            if(n2 - na > ans){
                // System.out.println(1);
                int d = n2 - ans - na;

                if(d % (t+2) == 0){
                    ans+= +d / (t+2);
                    nums[t+1] = ans + d/ (t+2);
                    na = 0;
                }
                else {
                    ans += d/(t+2) +1;
                    nums[t+1] = ans + d/(t+2);
                    na = (t+2) - d%(t+2);
                }
                
                
            }
            else if(n2-na == ans){    
                nums[t] = ans;
                nums[t+1] = ans;
                na = 0;
                
            }
            else{
                nums[t+1] = ans-1;
                na = na - (n2-(ans-1)) + 1;
                
            }
        }
        
        System.out.println(ans);
    }

}
