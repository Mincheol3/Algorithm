import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class BJ_PassportControl_16288 {
    
    static int N, K;
    static int[][] dp;
    static int[] nums;
    static ArrayList<Queue<Integer>> list = new ArrayList<Queue<Integer>>(); 
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[100][100];
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int pre = 0;
        for(int i = 0 ; i < N; i++){
            pre = nums[i];
            int cnt = 0;
            int min = Integer.MAX_VALUE;
            while(i < pre-1){
                if(pre < nums[i]){
                    pre = nums[i];
                    cnt = cnt != 0 ? cnt-- : cnt;
                    // cnt--;
                }
                
                if(nums[i] > nums[i+1]){
                    cnt++;
                    // System.out.println(nums[i] + " " + nums[i+1]);
                    if(cnt >= K){
                        // System.out.println(nums[i] + " " + nums[i+1]);
                        System.out.println("NO");
                        return;
                    }
                }
                i++;
            }
    
        }
        System.out.println("YES");

        

    }
}
