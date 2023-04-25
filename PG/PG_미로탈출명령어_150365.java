import java.util.*;

public class PG_미로탈출명령어_150365 {
    
    static String ans;
    static boolean iscomplete;
    static char[] arr = {'d', 'r', 'l' ,'u'};
    // 하 우 좌 상
    static int dx[] = {0, 1, -1, 0};
    static int dy[] = {1, 0, 0, -1};
    static int sr, sc, sk, sm, sn;
    static boolean visit[][][];
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
       
        PriorityQueue<Node> pq = new PriorityQueue<>((e1,e2) -> e1.cnt == e2.cnt ? e1.str.compareTo(e2.str) : e1.cnt-e2.cnt);
        sr = r;
        sc = c;
        sk = k;
        sm = m;
        sn = n;
        
        visit = new boolean[n+1][m+1][k+1];
        pq.add(new Node(x,y,0,""));
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            // System.out.println(node.cury + " " + node.curx + " " + node.str + " " +node.cnt);
            if(node.cnt == k){
                 if(node.cury == r && node.curx == c){
                     return node.str;
                 }continue;
            }
            for(int i = 0; i < 4; i++){
                int ny = node.cury + dy[i];
                int nx = node.curx + dx[i];
                // 범위체크
                if(ny < 1 || nx <1 || ny > n || nx > m || visit[ny][nx][node.cnt+1]) continue;
                    
                    visit[ny][nx][node.cnt+1] = true;
                    pq.add(new Node(ny,nx,node.cnt+1,node.str + arr[i]));
            }
           
        }
        
        return "impossible";
        
        
    }
    static class Node{
        int cury;
        int curx;
        int cnt;
        String str;
        
        public Node(int cury, int curx, int cnt, String str){
            this.cury =cury;
            this.curx= curx;
            this.cnt =cnt;
            this.str = str;
        }
    }
    
}
