import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_여러분의다리_17352 {

    static int N;
    static int map[]; 
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N+1];
        for(int i = 1; i <= N; i++){
            map[i] = i;
        }
        for(int i = 0 ; i < N ; i ++){
        
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
        }
    }

    static void union(int x, int y){
        if(map[x] < map[y]) map[y] = x;
        else map[x] = y;
    }

    static int find(int x){
        if(map[x] == x) return x;
        else return find(map[x]);
    }
}
