import java.util.*;
import java.io.*;
public class BJ_지뢰찾기_2140 {
    
    static int N, M;
    static char[][] map;
    // 상 하 좌 우 좌상 좌하 우상 우하
    static int[] dy = {-1 ,1 ,0 , 0 ,-1, 1 ,-1 ,1};
    static int[] dx = {0, 0, -1, 1, -1 ,-1 ,1 ,1};
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();

        }

        // for(int i = 0 ; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         int cnt = 0;
        //         if(map[i][j] == '3'){
        //             for(int k = 0; k < 8; k++){
        //                 int ny = i + dy[k];
        //                 int nx = j + dx[k];
                        
        //                 if(nx < 0 || ny < 0 || ny >= N || nx >= N || map[ny][nx] != '#') continue;
        //                 map[ny][nx] = '*';
        //                 cnt++;
        //                 if(cnt == 3) break;
        //             }
        //         }
        //         else if(map[i][j] =='0'){
        //             for(int k = 0; k < 8; k++){
        //                 int ny = i + dy[k];
        //                 int nx = j + dx[k];
                        
        //                 if(nx < 0 || ny < 0 || ny >= N || nx >= N || map[ny][nx] != '#') continue;
        //                 map[ny][nx] = '.';
        //             }
        //         }
        //     }
        // }
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        if(N < 3){
            System.out.println(0); return;
        }
        int ans = (N-2) * (N-2);
        for(int i = 1; i < N -1 ; i++){
            for(int j = 1; j < N-1; j++){
                boolean check = false;

                for(int k = 0; k < 8; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if(map[ny][nx] != '#' && map[ny][nx] == '0'){
                        check = true;
                    }
                }
                if(check) ans--;
                else {
                    for(int k = 0; k < 8; k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
    
                        if(map[ny][nx] != '#' ){
                            map[ny][nx]--;
                        }
                    }
                }
            }
          
        }
        System.out.println(ans);
    }
}
