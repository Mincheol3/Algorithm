import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_달팽이_1913 {
    
    static int N, num;
    static int[][] map;
    static int[] dx = {0 , 1 ,0 ,-1};
    static int[] dy = {1, 0 , -1 , 0};
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int val = N*N;

        for(int i = 0; i < N; i++){

            for(int j = 0 ; j < N; j++){

            }
        }
    }
    static void makeMap(){
        int r = 0;
        int c = 0;
        int cnt = N*N;
        
        int d = 0;

        while(true){
            if(cnt == 0){
                break;
            }
            map[r][c] = cnt--;

            int nr == r + dy[d];
        }
    }
}
