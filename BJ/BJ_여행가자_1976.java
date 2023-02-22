import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// Union find Set 사용하여 도시끼리 연결되어 있는지 판단.
public class BJ_여행가자_1976 {
    
    static int N, M;
    static int parent[];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            for(int j = 1; j <= N; j++){
                
                int n = Integer.parseInt(st.nextToken());
 
                if(n == 1){
                    union(i,j);
                }
                
            }

        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 출발 도시
        int first = Integer.parseInt(st.nextToken());

        // 다음으로 이동할 도시와 연결되어 있는지 확인.
        for(int i = 1; i< M; i++){
            int next = Integer.parseInt(st.nextToken());

            //연결X -> No
            if(!link(first, next)){
                System.out.println("NO");
                return;
            }
         }
         // 모두 연결되어 있으면 Yes
         System.out.println("YES");
         return;
        
    }
    static int find1(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    static void uni(int x, int y){
        int nx = find(x);
        int ny = find(y);

        if(nx < ny) parent[ny] = nx;
        parent[nx] = ny;
    }

    // 도시 연결
    static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    // 최상위 부모 찾기
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 연결 확인
    static boolean link(int x, int y){
        return find(x) == find(y) ? true : false;
    }
}
