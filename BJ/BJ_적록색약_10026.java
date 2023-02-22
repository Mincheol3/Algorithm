package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_적록색약_10026 {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int N, ans, ans2;
	static char[][] Map;
	static boolean visit1[][], visit2[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Map = new char[N][];
		visit1 = new boolean[N][N];
		visit2 = new boolean[N][N];
	
		StringTokenizer st;
		
		for(int i = 0 ; i < N; i++) {

			Map[i] = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {

			}

		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit1[i][j]) {
					dfs(i,j,visit1);
					ans++;
				}
				if(Map[i][j] == 'G') Map[i][j] = 'R';
				
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit2[i][j]) {
					dfs(i,j,visit2);
					ans2++;
				}
			}
		}
		System.out.print(ans + " " + ans2);
		
	}
	
	static void dfs(int y, int x, boolean[][] visit) {

		char c = Map[y][x];
		
		for(int i = 0; i < 4 ; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || c != Map[ny][nx] || visit[ny][nx] ) continue;
			visit[ny][nx] = true;
			dfs(ny,nx, visit);
		}

	}
	
//	static void dfs2(int y, int x, boolean[][] visit) {
//
//		char c = Map[y][x];
//		
//		for(int i = 0; i < 4 ; i++) {
//			int ny = y + dy[i];
//			int nx = x + dx[i];
//			
//			if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] ) continue;
//			visit[ny][nx] = true;
//			
//			if((Map[ny][nx] == 'R' || Map[ny][nx] == 'G') && (c =='R' || c == 'G')) {
//				visit[ny][nx] = true;
//				dfs2(ny,nx,visit2);
//			}
//			else if(Map[ny][nx] == c) {
//				visit[ny][nx] = true;
//				dfs2(ny,nx, visit2);
//			}
//		}
//
//	}
	
	
}
