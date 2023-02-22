package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷젤다_4485_pro {
	
	static int N;
	static int map[][];
	static boolean[][] visit;
	static int cost[][];
	
	static int[] dy = {-1, 1, 0, 0,};
	static int[] dx = {0 , 0, -1, 1};
	
	static PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>((e1,e2) -> e1.c - e2.c);
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			cost = new int[N][N];
			visit = new boolean[N][N];
			
	for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;	
				}
			}
			dijkstra();
			
			System.out.println("Problem " +t+ ": " +cost[N-1][N-1]);
			t++;
		}

	}
	static void dijkstra() {
		cost[0][0] = map[0][0];
		pqueue.offer(new Edge(0, 0, map[0][0]));
		
		while(!pqueue.isEmpty()) {
			
			Edge e = pqueue.poll();
			
			if(visit[e.y][e.x]) continue;
			visit[e.y][e.x] = true;
			
			for(int i = 0; i < 4; i++) {
				int ny = e.y + dy[i];
				int nx = e.x + dx[i];
				if(ny >= N || nx >= N || ny <0 || nx < 0 || visit[ny][nx]) continue;
				
				if(e.c + map[ny][nx] < cost[ny][nx]) {
					cost[ny][nx] = e.c + map[ny][nx];
					pqueue.offer(new Edge(ny,nx, cost[ny][nx]));
				}
			}
		}
	}
	
	static class Edge{
		int y;
		int x;
		int c;
		
		public Edge (int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}

}
