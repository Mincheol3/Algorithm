import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_떡장수와호랑이_16432 {
    
    static int N;
    static boolean[][] cake, visit;
    static int dp[];
    static boolean check;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        cake = new boolean[N+1][10];
        visit = new boolean[N+1][10];
        for(int i = 0; i < N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for(int j = 0; j < M; j++){
            cake[i][Integer.parseInt(st.nextToken())] =true ;
            }
        }
        dfs(0,0);

        StringBuilder sb = new StringBuilder();
        if(check){
            for(int i =0; i< N; i++){
                sb.append(dp[i]).append("\n");
            }            
        }
        else System.out.println(-1);
       
        System.out.println(sb.toString());
    }
    static void dfs(int idx, int n){
        if(idx == N) {
            check = true;
            return;
        }
        for(int i = 1; i <= 9; i++){
            if(cake[idx][i] && i != n && !visit[idx+1][i]){
                System.out.println(idx + " "  + i );
                visit[idx+1][i] = true;
                dp[idx] = i;
                dfs(idx+1, i);
                if(check) return;
            }
        }
        
     
    }
}
