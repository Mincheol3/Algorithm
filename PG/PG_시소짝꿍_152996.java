import java.util.*;

public class PG_시소짝꿍_152996 {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        int cnt = 0;
        for(int i = 0; i < weights.length -1; i++){
            if(i != 0 && weights[i] == weights[i-1]){
                answer += --cnt;
                continue;
            }
            cnt = 0;
            for(int j = i + 1; j < weights.length; j++){
                 if(weights[i] * 2 < weights[j]) break;
               
                double num = (double)weights[j] / weights[i];
                // System.out.println(num);
                if(num == 1.0 || num == 1.5 || num == 2.0 || num == 1.3333333333333333) cnt++;
                
            }
            answer += cnt;
        }
        return answer;
    }
}
