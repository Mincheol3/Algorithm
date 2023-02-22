import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class BJ_수열의점수 {
    
    static int n;
    static int pos, nega, zero, one;
    static long[] nums;
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger ans= new BigInteger("0");
        long answer = 0;
        n = Integer.parseInt(br.readLine());
        nums = new long[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(br.readLine());
            if(nums[i] == 1) one++;
            else if(nums[i] == 0) zero++;
            else if(nums[i] < 0) nega++;
            else pos++;
            
        }
        // 오름차순 정렬
        Arrays.sort(nums);

        //음수 계산
        //개수가 짝수 일때
        if(nega % 2 == 0){
            for(int i = 0; i < nega-1; i+=2){
                // ans = ans.add(BigInteger.valueOf(nums[i]*nums[i+1]));
                answer += nums[i]*nums[i+1];
            }
        }
        //홀수 일때
        else{
             // 0이 있으면 곱해주면 0 이므로 무시
            
            if(zero != 0){
                for(int i = 0; i < nega -2; i+=2){
                    // ans = ans.add(BigInteger.valueOf(nums[i]*nums[i+1]));
                    answer += nums[i]*nums[i+1];
                }
            }
            // 0 이 없으면 절댓값 제일 작은 음수를 더해줌
            else{
                for(int i = 0; i < nega-2; i+=2){
                    // ans = ans.add(BigInteger.valueOf(nums[i]*nums[i+1]));
                    answer += nums[i]*nums[i+1];
                }
                // ans += nums[nega-1];
                // ans = ans.add(BigInteger.valueOf(nums[nega-1]));
                answer += nums[nega-1];
            }
        }
        // 양수 계산
        if(pos % 2 == 0){
            // if(cnt != 0){
                for(int i = nega + zero + one; i < n-1; i+=2){
                    // ans = ans.add(BigInteger.valueOf(nums[i]*nums[i+1]));
                    answer += nums[i]*nums[i+1];
                }
            // }
            // else{
            //     for(int i = 0; i < n-1; i+=2){
            //         ans += nums[i]*nums[i+1];
            //     }
            // }
            // ans = ans.add(BigInteger.valueOf(one));
            answer+= one;
            
        }
        else{
            for(int i = nega + zero +one+1; i < n-1; i+=2){
                // ans = ans.add(BigInteger.valueOf(nums[i]*nums[i+1]));
                answer += nums[i]*nums[i+1];
            }
            answer+= nums[nega+zero+one] + one;
            // ans = ans.add(BigInteger.valueOf(nums[nega+zero+one] + one));
            
        }
        System.out.println(answer);
    }
}
