package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9205_맥주마시면서걸어가기 {
   
   static int n; // n: 맥주를 파는 편의점의 개수
   static ArrayList<Position> position = new ArrayList<>(); // 좌표 정보 저장
   static boolean[] visit; // 방문체크
   
   static StringBuilder sb = new StringBuilder();
   
   public static void main(String[] args) throws Exception {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      // 테케 수
      int T = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=T; t++) {
         
         n = Integer.parseInt(br.readLine()); // 편의점의 개수
         visit = new boolean[n+2]; // 집, 편의점, 페스티벌
         position.clear();
         
         // 좌표 정보 입력
         for(int i=0; i<n+2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            position.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
         }
         
         bfs();
         
      }
      
      System.out.print(sb.toString());
   }
   
   static void bfs() {
      
      
      Position festival = position.get(n+1);
      
       Queue<Position> queue = new LinkedList<Position>();
       queue.offer(position.get(0));
      

      
      visit[0] = true;
      
      while(!queue.isEmpty()) {

         
         Position pos = queue.poll();

         if(dist(pos, festival) <= 1000) {
            sb.append("happy").append("\n");
            return;
         }
         
        
         for(int i=1; i<n+2; i++) {
            if(!visit[i]) {
               if(dist(pos, position.get(i))<=1000) {
                  queue.add(position.get(i));

                  visit[i] = true;
               }
            }
         }
         
      }
     
      sb.append("sad").append("\n");
   }
   
   
   static int dist(Position p1, Position p2) {
      return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
   }
   
   
   static class Position {
      
      int x, y;
      
      public Position(int x, int y) {
         this.x = x;
         this.y = y;
      }

      @Override
      public String toString() {
         return "Position [x=" + x + ", y=" + y + "]";
      }
      
   }
}