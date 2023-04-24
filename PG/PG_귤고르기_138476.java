import java.util.*;

public class PG_귤고르기_138476 {
    
    static PriorityQueue<Integer> select = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int k, int[] tangerine) {
        
        Arrays.sort(tangerine);
        int pre = tangerine[0];
        int num = 1;
        for(int i = 1; i < tangerine.length; i++){
            if(pre != tangerine[i]){
                select.add(num);
                num = 1;
                pre = tangerine[i];
                continue;
            }
            num++;
            
            
        }
        select.add(num);
     int answer = 0;
       
    
        
        while(!select.isEmpty() && k > 0){
            k -= select.poll();
            answer++;
        }
        return answer;
    }
}
