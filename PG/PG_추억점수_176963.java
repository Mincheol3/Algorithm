import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);        
        }
        
        for(int i = 0; i < answer.length; i++){
               for(int j = 0; j < photo[i].length; j++){
                   String str = photo[i][j];
                   if(map.get(str) != null){
                       answer[i] += map.get(str);
                   }
               }
        }
        
        return answer;
    }
}