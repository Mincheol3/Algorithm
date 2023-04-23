import java.util.*;
import java.io.*;
public class BJ_짚신벌레_2560 {

    static int a, b, d ,N;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] day = new int[N+1];
        day[0] = 1;
        int dead = 0;
        int breed = 0;
       
        for(int i = 1; i <= N; i++){
            day[i] = day[i-1];
            if(i - a >= 0) day[i] = (day[i] + day[i-a])%1000;
            if(i - b >= 0) day[i] = (day[i] - day[i-b]+ 1000)%1000;
        }
        System.out.println((day[N]-day[N-d]+1000)%1000);
    }
}
