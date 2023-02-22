import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.BlockElement;

public class BJ_풍선맞추기_11509 {
    
    static int cnt;
    static int N;
    static boolean[] pop = new boolean[1000001];
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] balloons = new int[N];
        


        for(int i = 0 ;i < N; i++){
            balloons[i] = Integer.parseInt(st.nextToken());
        }
        
        int h = 0;
        for(int i = 0 ; i<N; i++){
            h = balloons[i];

            if(!pop[h + 1]){
                pop[h] = true;
                cnt++;
            }
            else{
                pop[h + 1] = false;
                pop[h] = true;
            }
            
        }
        System.out.println(cnt);

    }
    
}
