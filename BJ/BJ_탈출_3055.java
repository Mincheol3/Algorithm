import java.io.*;
import java.util.*;

public class BJ_탈출_3055 {

    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static boolean[][] visit2;
    static int dx[] = { 0, 0, -1, 1 };
    static int dy[] = { -1, 1, 0, 0 };
    static Queue<Node> water = new LinkedList<>();
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        visit = new boolean[R][C];
        visit2 = new boolean[R][C];

        int sx = 0;
        int sy = 0;
        boolean c = false;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            if (!c) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'S') {
                        sx = i;
                        sy = j;
                        c = true;
                    }
                }
            }
            for (int k = 0; k < C; k++) {
                if (map[i][k] == '*')
                    q.add(new Point(i, k, 0));
            }
        }
        q.add(new Point(sx, sy, 0));
        int time = 0;
        while (!q.isEmpty()) {
            // System.out.println("time : " + time);
            // System.out.println("Water");
            // System.out.println("Hedgehog");

            Point p = q.poll();
            // System.out.println(p.x + " " + p.y);
            for (int d = 0; d < 4; d++) {
                int ny = p.x + dy[d];
                int nx = p.y + dx[d];

                if (map[p.x][p.y] == '*') {
                    if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] != '.')
                        continue;
                    if(map[ny][nx] != 'S')map[ny][nx] = '*';
                    q.add(new Point(ny, nx, 0));
                } else {
                    if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == '*' || map[ny][nx] == 'X'
                            || visit[ny][nx])
                        continue;
                    if (map[ny][nx] == 'D') {
                        System.out.println(p.t + 1);
                        return;
                    }
                    visit[ny][nx] = true;
                    map[ny][nx] = 'S';
                    // System.out.println("next " + ny + " " + nx);
                    q.add(new Point(ny, nx, p.t + 1));
                }
            }

            time++;
        }
        System.out.println("KAKTUS");
    }

    static class Point {
        int x;
        int y;
        int t;

        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
