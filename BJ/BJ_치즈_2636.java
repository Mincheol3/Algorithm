package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_치즈_2636 {
	
	static int[] dx = {0 , 0, -1, 1};
	static int[] dy = {-1 , 1, 0, 0};
	static int N, M;
	static int[][] cheese;
	static boolean[][] check;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheese = new int[N][M];
		check = new boolean[N][M];
		int temp = 0;
		for(int i =0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j] == 1) temp++;
			}
		}
		outair(0,0);
		int time = 0;
		while(true) {
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(cheese[i][j] == 1) {
						if(melt(i,j)){
							cnt++;
						}
					}
				}
			}
//			System.out.println(cnt + " " + time);
			if(cnt == 0){
				break;
			}
			else temp = cnt;
			time++;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					check[i][j] = false;
					if(cheese[i][j] == 2) {
						cheese[i][j] = 0;
					}
				}
			}
			outair(0,0);
			
		}
		System.out.println(time);
		System.out.println(temp);

	}
	static boolean melt(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			if (cheese[ny][nx] == 2) {
				cheese[y][x] = 0; 
				return true;
			}
		}
		 return false;
	}
	
	static void outair(int y, int x) {
		
		check[y][x] = true;
		cheese[y][x] = 2;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= M || cheese[ny][nx] == 1 || check[ny][nx]) continue;
			outair(ny,nx);
			
		}
	}
}
