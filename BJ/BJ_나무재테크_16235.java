import java.util.*;
import java.io.*;

public class BJ_나무재테크_16235 {
    
    static int N, M, K;
    static int farm[][][];
    static int nutriton[][];
    static int dx[] = {0 ,0, -1 ,1, -1, 1, 1, -1};
    static int dy[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static PriorityQueue<Wood> woods = new PriorityQueue<>((e1,e2) -> e1.o - e2.o);
    static PriorityQueue<Wood> woods2 = new PriorityQueue<>((e1,e2) -> e1.o - e2.o);
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        farm = new int[N+1][N+1][2]; // 0 은 현재 1 죽은 나무
        nutriton = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                nutriton[i][j] = Integer.parseInt(st.nextToken());
                farm[i][j][0] = 5;
            }
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            woods.add(new Wood(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 1; i <= K; i++){
            //봄
            if(!woods.isEmpty()){
                while(!woods.isEmpty()){
                    Wood w = woods.poll();
                    int wx = w.x;
                    int wy = w.y;

                    if(farm[wx][wy][0] >= w.o){
                        farm[wx][wy][0] -= w.o;
                        woods2.add(new Wood(wx, wy, w.o+1));
                    }
                    //여름
                    else{
                        farm[wx][wy][1] += w.o/2;
                    }
                    // 가을
                    if((w.o+1)%5 == 0){
                        for(int j = 0; j < 8; j++){
                            int ny = wx + dy[j];
                            int nx = wy + dx[j];

                            if(ny < 1 || nx < 1 || ny >N || nx >N) continue;
                            woods2.add(new Wood(ny,nx,1));
                        }
                    }
                    //겨울
                    for(int k = 1; k < N; k++){
                        for(int q= 1; q < N; q++){
                            farm[k][q][0] += farm[k][q][1] + nutriton[k][q];
                            farm[k][q][1] = 0;
                        }
                    }
                    
                }
            }
            else{
                while(!woods2.isEmpty()){
                    Wood w = woods2.poll();
                    int wx = w.x;
                    int wy = w.y;

                    if(farm[wx][wy][0] >= w.o){
                        farm[wx][wy][0] -= w.o;
                        woods.add(new Wood(wx, wy, w.o+1));
                    }
                    //여름
                    else{
                        farm[wx][wy][1] += w.o/2;
                    }
                    // 가을
                    if((w.o+1)%5 == 0){
                        for(int j = 0; j < 8; j++){
                            int ny = wx + dy[j];
                            int nx = wy + dx[j];

                            if(ny < 1 || nx < 1 || ny >N || nx >N) continue;
                            woods.add(new Wood(ny,nx,1));
                        }
                    }
                    //겨울
                    for(int k = 1; k < N; k++){
                        for(int q= 1; q < N; q++){
                            farm[k][q][0] += farm[k][q][1] + nutriton[k][q];
                            farm[k][q][1] = 0;
                        }
                    }
                    
                }
            }
        }
        int ans = Math.max(woods.size(), woods2.size());
        System.out.println(ans);

    }
    static class Wood{
        int x;
        int y;
        int o;

        public Wood(int x, int y, int o){
            this.x=  x;
            this.y = y;
            this.o = o;
        }
    }
}
