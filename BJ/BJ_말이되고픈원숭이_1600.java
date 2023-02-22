package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_말이되고픈원숭이_1600 {
	static int min = -1;
	static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2}; 
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int[] dy = {-1, 1 ,0 , 0};
	static int[] dx = {0, 0, -1 , 1};
	static int K, N, M;
	static int Map[][];
	static boolean Check[][][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		Check = new boolean[N][M][K+1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
		
			}
		}
		int ans = move(0,0,0);
		
		System.out.println(ans);
	}
	
	static int move(int y, int x, int cnt) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y, x, 0, K));
		Check[y][x][K] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.y == N-1 && n.x == M -1) return n.count;
		
			for(int i = 0; i < 4; i++) {
			int ny = n.y + dy[i];
			int nx = n.x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= M || Map[ny][nx] == 1 || Check[ny][nx][n.k]) continue;
			Check[ny][nx][n.k] = true;
			q.offer(new Node(ny,nx,n.count +1 , n.k));
		
			}
			
			if(n.k > 0) {
				
				for(int i = 0; i < 8; i++) {
					int ny = n.y + hdy[i];
					int nx = n.x + hdx[i];
					
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || Map[ny][nx] == 1 || Check[ny][nx][n.k-1]) continue;
					Check[ny][nx][n.k-1] = true;
					q.offer(new Node(ny,nx,n.count +1 , n.k-1));
				}
			}
			
		}

		return -1;
	}
	
	static class Node{
		int y, x ,count ,k;
		
		public Node(int y, int x , int count ,int k) {
			this.y = y;
			this.x = x;
			this.count = count;
			this.k = k;
		}
	}

}
