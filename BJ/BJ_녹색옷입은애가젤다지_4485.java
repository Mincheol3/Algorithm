package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_4485 {
	
	static int N;
	static int[][] Map, cost;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int cnt = 1;
		while(N != 0) {
			
			Map = new int[N][N];
			cost = new int[N][N];
			for(int i = 0; i < N; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					Map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;	
					}
				}
			
			cost[0][0] = Map[0][0];
			dijkstra();
			
			System.out.println("Problem " +cnt+ ": " +cost[N-1][N-1]);
	
			N = Integer.parseInt(br.readLine());
			cnt++;
			
		}
	}
	static class rupee{
		int y, x, c;
		
		public rupee(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}
	
	static void dijkstra() {
		
		PriorityQueue<rupee> pq = new PriorityQueue<rupee>((n1,n2) -> n1.c - n2.c);
		pq.add(new rupee(0 ,0, cost[0][0]));
		
		while(!pq.isEmpty()) {
			rupee rp = pq.poll();
		for(int i = 0 ; i < 4 ; i++) {
			int ny = rp.y + dy[i];
			int nx = rp.x + dx[i];
			
			if(ny >= N || nx >= N || ny <0 || nx < 0) continue;
			if(cost[ny][nx] > Map[ny][nx] + rp.c) {
				cost[ny][nx] = Map[ny][nx] + rp.c;
//				System.out.println(ny + " " + nx + " " + cost[);
				pq.add(new rupee(ny,nx,cost[ny][nx]));
				}
			}
		}
	}

}
