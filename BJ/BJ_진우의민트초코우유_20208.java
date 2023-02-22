import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 체력이 0 이면 이동불가. 
// 우유 먹으면 체력 늘어남.
public class BJ_진우의민트초코우유_20208 {
    
    static int N, M ,H, homeX, homeY, ans;
    static int[][] map;
    static boolean eat[];
    static ArrayList<int[]> milk = new ArrayList<int[]>();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 1){
                    homeY = i;
                    homeX = j;
                }
                else if(map[i][j] == 2){
                    milk.add(new int[], {i,j});
                }
            }
        }
        eat = new boolean[milk.size()];

    }

    static void permu(int d, ArrayList<int[]> arr){

        if(d == milk.size()) return;
    }

    static void simul(ArrayList<int[]> arr){
        
        int curY = homeY;
        int curX = homeX;
        int hp = M;
        int cnt = 0;

        for(int[] milk : arr) {
            int dist = Math.abs(curY - milk[0]) + Math.abs(curX - milk[1]);
            
            if(dist > hp) break;

            else{
                hp -= dist;
                hp += H;
                cnt++;
                curY = milk[0];
                curX = milk[1];
                int distHome = Math.abs(homeY - milk[0]) + Math.abs(homeX - milk[1]);

                if(distHome <= hp) {

                    ans = Math.max(cnt, ans)
                }
            }

        }
    }
}
