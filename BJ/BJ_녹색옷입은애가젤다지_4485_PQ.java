package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_4485_PQ {
	
	static int N;
	static int[][] Map, cost;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
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
			dijkstra(0,0);
			System.out.println("Problem 1: "+cost[N-1][N-1]);
			N = Integer.parseInt(br.readLine());
			
		}
	}
	
	static void dijkstra(int y, int x) {
		
		for(int i = 0 ; i < 4 ; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= N || nx >= N || ny <0 || nx < 0) continue;
			if(cost[ny][nx] > Map[ny][nx] + cost[y][x]) {
				cost[ny][nx] = Map[ny][nx] + cost[y][x];
//				System.out.println(ny + " " + nx + " " + cost[);
				dijkstra(ny,nx);
			}
		}
	}

}
