// import java.io.BufferedReader;
// import java.io.InputStreamReader;
import java.io.*;
// import java.*;
import java.util.StringTokenizer;

public class BJ_행성탐사_5549 {
    
    static int M, N, K;
    static char[][] Map;
    static int[][][] arr;
    static StringBuilder sb = new StringBuilder();    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        arr = new int[M+1][N+1][3];

        Map = new char[M+1][N+1];

        for (int i = 1 ; i <= M; i++){
            // st = new StringTokenizer(br.readLine());
            
            Map[i] = br.readLine().toCharArray();

            for(int j = 0; j< N; j++){
                if(Map[i][j] == 'J'){
                    arr[i][j+1][0] = 1;
                }
                else if(Map[i][j] == 'O'){
                    arr[i][j+1][1] = 1;
                }
                else arr[i][j+1][2] = 1;
            }    
            // for(int j = 1; j <= N; j++){
            //     Map[i][j] = st.nextToken().toCharArray()
            // }
        }

        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                for(int k = 0; k < 3; k++){
                    arr[i][j][k] += arr[i-1][j][k];
                }
            }
        }

        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                for(int k = 0; k < 3; k++){
                    arr[i][j][k] += arr[i][j-1][k];
                }
            }
        }
        // for (int i = 1; i <= M; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.println(Map[i][j]);
        //     }
        //     System.out.println();
        // }

        for(int i = 0 ; i < K; i++){
            st = new StringTokenizer(br.readLine());
            
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            for(int k = 0 ; k < 3; k++){
                int n = arr[y2][x2][k] - arr[y-1][x2][k] - arr[y2][x-1][k] + arr[y-1][x-1][k];
                sb.append(n).append(" ");
            }
            sb.append("\n");    
            // check(y, x, y2, x2);
        }
        System.out.println(sb.toString());

    }
    static void check(int x1, int y1, int x2, int y2){
        int J = 0;
        int O = 0;
        int I = 0;
        for(int i = x1; i <= x2; i++){
            for(int j = y1-1; j<= y2-1; j++){
                if(Map[i][j] == 'J') J++;
                else if(Map[i][j] == 'O') O++;
                else I++;
            }
        }
        sb.append(J+" ").append(O + " ").append(I).append("\n");
        
    }
}
