import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_문자열화폐_17828 {
    
    static int N, X;
    static char c[];
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        c = new char[N];
        if(X > 26*N || X < N){
            System.out.println("!");
            return;
        }
        int x = X - N;
        int div = x / 25;
        int per = x % 25;

        for(int i = 0; i < N - div -1; i++){
            c[i] = 'A';
        }
        // System.out.println(per);
       if(N-div-1 >= 0){
        c[N-div-1] = (char)(per + 65);
       }
       
        for(int i = N-div; i < N; i++){
            c[i] = 'Z';
        
    }

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            sb.append(c[i]);
            // System.out.println(c[i] + " " + i);
        }
        System.out.println(sb.toString());
        
    }
}
