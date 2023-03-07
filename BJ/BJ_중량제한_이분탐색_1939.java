import java.util.*;
import java.io.*;
public class BJ_중량제한_이분탐색_1939 {
    
    static int N, M, start, end;
    static int[][] city;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N+1][N+1];
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            
            right = Math.max(right,c);
            left = Math.min(left, c);
            city[y][x] = Math.max(city[y][x], c);
            city[x][y] = Math.max(city[x][y], c);
        }


        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while(left < right){
            int mid = (left + right +1)/2;

            
            if(dfs(mid,start)) left = mid;
            else right = mid-1;
        }
        System.out.println(left);

    }
    static boolean dfs(int mid, int x){
        boolean[] visit = new boolean[N+1];
        visit[x] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int n = q.poll();
            visit[n] = true;
            if(visit[start] && visit[end] ) return true;
            for(int i = 1; i <= city[n].length; i++){
                if(city[n][i] >= mid && !visit[i]){
                    q.add(i);
                }
            }
        }
        return false;
    }
}
