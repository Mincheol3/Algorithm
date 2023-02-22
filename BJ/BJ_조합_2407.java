import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_조합_2407 {
    
    static int n ,m;
    static int ans;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        comb(0,0);
        System.out.println(ans);

    }
    // 이거 중복안되는 조합
    static void comb(int start, int depth){
        if(depth == m){
            ans++;
        }
        for(int i = start; i < n; i++){

            comb(i+1,depth+1);
        }
    }

    static void comb2(int start, int depth){
        if(depth == m){
            ans++;
        }
        for(int i = start; i < n; i++){

            comb(i,depth+1);
        }
    }

    static void permu(int start, int depth){
        if(depth == m){
            ans++;
        }
        for(int i = 0; i < n; i++){
            permu(i, depth+1);
        }
    }

    static void permu2(int start, int depth, boolean[] visit){
        if(depth == m){
            ans++;
        }
        for(int i = 0 ; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                permu2(i, depth+1, visit);
                visit[i] = false;
            }
        }
    }
}
