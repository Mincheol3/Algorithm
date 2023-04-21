import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class BJ_숨바꼭질3_13549 {
    static int N, K, ans;
    static int visit[];
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        visit = new int[Math.max(N, K)+5];
        Arrays.fill(visit, Integer.MAX_VALUE);
        find(N, 0);
        System.out.println(ans);

    }

    static void find(int curr, int time){
        if(curr >= visit.length || curr < 0) return;
        if(curr == K){
            ans = Math.min(ans, time);
            return;
        }
        if(visit[curr] <= time) return;
        visit[curr] =time;

        // System.out.println(curr + " " + time);
        find(curr * 2, time);
        find(curr -1, time+1 );
        find(curr +1, time+1);
    }
}
