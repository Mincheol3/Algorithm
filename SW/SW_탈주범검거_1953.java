package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_탈주범검거_1953 {
   static int T, N, M, R, C, L, ans;
   static int map[][];
   static int[] dx = {0, 0, -1, 1};
   static int[] dy = {-1, 1, 0, 0};
//   static int[][] visit;
   static boolean[][] visit;
   public static void main(String[] args) throws Exception {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      T = Integer.parseInt(br.readLine());
      StringTokenizer st;
      for (int t = 1; t<= T; t++) {
         st = new StringTokenizer(br.readLine());
         
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         L = Integer.parseInt(st.nextToken());
         ans = 0;
         
         map = new int[N][M];
//         visit = new int[N][M];
         visit = new boolean[N][M];
         for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
               map[i][j] = ChangeBit(Integer.parseInt(st.nextToken())); // 비트로 바꿔서 받음 . 
//               System.out.print(map[i][j]);
               
            }
//            System.out.println();
         }
         bfs(R,C);
//         dfs(R,C, 0);
         System.out.println("#" +t+ " " + ans);
         
      }

   }
   
   static void bfs(int y, int x) {
      
      visit[y][x] = true;
//      visit[y][x] =  true;
      
      Queue<Node> q = new LinkedList<>();
      
      q.offer(new Node(y, x, 1));
      
      while(!q.isEmpty()) {
         
         Node node = q.poll();
         int nodeY = node.y;
         int nodeX = node.x;
         int time = node.t;
//         System.out.println("y : " + nodeY+ " x : " + nodeX + " t : " + time);
         if(time == L +1) break;
         ans++;
         
         
         for(int i = 0 ; i < 4 ; i++) {
//            System.out.println("비트마스킹  값  "  + (map[nodeY][nodeX] & (1 <<(3 -i))));
            if((map[nodeY][nodeX] & (1 <<(3 -i))) != 0 ) { // 현재 위치에서 갈 수 있는 방향 체크 
                  
               int ny = nodeY + dy[i];
               int nx = nodeX + dx[i];
               
//               if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 0 || visit[ny][nx] > time) continue; // 범위 벗어나거나 빈곳
               if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 0 || visit[ny][nx]) continue;
//               System.out.println("ny : "  + ny + " nx : "  + nx);
               if(Check(map[ny][nx], i)) {
//                  visit[ny][nx] = time+1;
                  
                  visit[ny][nx] = true;
               
                  q.offer(new Node(ny, nx, time+1));    //queue 에 담고 하나씩 빼서 돈다   ..  연결된 지점들을 다 돌아야 함 /  
               }
            }
         }
         
         
         
      }
   }
   static void dfs(int y, int x, int t) {
      
      if(t == L+1) return;
      for(int i = 0 ; i < 4 ; i++) {
         if((map[y][x] & (1 <<(3 -i))) != 0 ) { // 현재 위치에서 갈 수 있는 방향 체크 
            int ny = y + dy[i];
            int nx = x + dx[i];
            
//            if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 0 || visit[ny][nx] > t) continue; // 범위 벗어나거나 빈곳
//            if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 0 || visit[ny][nx]) continue;
            if(Check(map[ny][nx], i)) {
//               visit[ny][nx] = t+1;
//               visit[ny][nx] = true;
               ans++;
               dfs(ny,nx, t+1);
               
            }
         }
      }
   }
   static boolean Check(int next, int i) {
      
      int x = 0;
   
      switch(i) {
      
      case 0 :  // 상으로 이동하는경우
         x = 4;  // 하와 연결     0010
         break;
      case 1 :  // 하로 이동하는 경우
         x = 8; // 상과 연결  1000
         break;
      case 2 :
         x = 1;          
         break;
      case 3 :
         x = 2;
         break;
      }
      
      if((next & x) != 0 ) return true;
      return false;
   }
   static int ChangeBit(int x) {
      
      switch(x) {
      
      case 1 :
         return 15;
      case 2 :
         return 12;
      case 3 :
         return 3;
      case 4 :
         return 9;
      case 5 :
         return 5;
      case 6 :
         return 6;
      case 7 :
         return 10;
      }
      return 0;
   }
   
   static class Node{
      
      int y, x, t;
      
      public Node (int y, int x , int t) {
         this.y = y;
         this.x = x;
         this.t = t;
      }
   }
}