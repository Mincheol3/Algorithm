import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_수묶기_1744 {
    
    static int N, minus,zero, one;
    static int[] nums;
    static long ans;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
            if(nums[i] == 0) zero++;
            else if(nums[i] < 0) minus++;
            else if(nums[i] ==  1) one++;
        }
        Arrays.sort(nums);
        
        int plus = N - (zero + one + minus);

        if(minus %2 == 1){
            for(int i =0; i < minus-2; i+=2){
                ans += nums[i]*nums[i+1];
            }
            if(zero == 0) ans+= nums[minus-1];
        }
        else{
            for(int i =0; i <= minus-2; i+=2){
                ans += nums[i]*nums[i+1];
            }
        }

        //          13                5
        for(int i = N-1; i > (zero+one+minus); i-= 2){
            ans+= nums[i]*nums[i-1];
        }
        if(plus %2 ==1) ans+= nums[N - plus];
        ans+= one;

        System.out.println(ans);
    }
}       
