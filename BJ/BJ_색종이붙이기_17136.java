import java.util.*;
import java.io.*;

public class BJ_색종이붙이기_17136 {
    static int ans;
    static int[][] map;
    static int[] paper = { 0, 5, 5, 5, 5, 5 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[10][10];

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MAX_VALUE;
        
        dfs(0, 0, 0);
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

    public static void dfs(int y, int x, int cnt) {
        if (x == 10 && y >= 9) {
            ans = Math.min(cnt, ans);
            return;
        }
        if (x == 10) {
            dfs(y + 1, 0, cnt);
            return;
        }
        if (cnt >= ans)
            return;

        if (map[y][x] == 1) {
            // 큰 색종이부터 붙여봄.
            for (int i = 5; i > 0; i--) {
                if(isattach(y, x, i) && paper[i] > 0){
                    attach(y, x, i);
                    paper[i]--;
                    dfs(y, x+1, cnt+1);
                    detach(y, x, i);
                    paper[i]++;
                }
            }
        }
        else dfs(y, x+1, cnt);
    }

    //색종이 붙이기
    public static void attach(int y, int x, int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[y + i][x + j] = size;
            }
        }
    }
    // 떼기
    public static void detach(int y, int x, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[y + i][x + j] = 1;
            }
        }
    }

    // 해당size의 색종이 붙일 수 있는지 체크
    public static boolean isattach(int y, int x, int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (y + i >= 10 || x + j >= 10 || map[y + i][x + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
