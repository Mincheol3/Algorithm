import java.io.*;
import java.util.*;

public class BJ_문자열폭발_9935 {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String Boom = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if(sb.length() >= Boom.length()){
                boolean flag = true;
                for(int j = 0; j < Boom.length(); j++){
                    if(sb.charAt(sb.length() - Boom.length() + j) != Boom.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    sb.delete(sb.length() - Boom.length(), sb.length());
                }
            }
            
        }
        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb.toString());

   
    }
      
}
