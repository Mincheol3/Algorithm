package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_연구소_14502 {
	static boolean visit[][];
	static int N, M;
	static int[][] lab;
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static Queue<Virus> que = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		lab = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int x = Integer.parseInt(st.nextToken());
				lab[i][j] = x;
				if(x == 2) {
					que.offer(new Virus(i, j));
				}
			}
		}
		
	}
	
	static void comb(int cnt) {
		if(cnt == 3) {
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++)
		}
		
	}
	
	static int spvirus(int[][] virus) { // 바이러스 갯수 새기
		int cnt = 0 ;
		while(!que.isEmpty()) {
			
			Virus v = que.poll();
		    cnt++;
			for(int i = 0; i < 4 ; i++) {
				int ny = v.y + dy[i];
				int nx = v.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || virus[ny][nx] != 0) continue;
				virus[ny][nx] = 2;
				que.offer(new Virus(ny,nx));
			
		}
	}
		return cnt;
		
}
	
	static class Virus{
		int y, x;
		
		public Virus(int y, int x) {
			this.y = y;
			this.x = x;
			
		}
	}

}
