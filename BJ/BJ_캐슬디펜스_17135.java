package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_캐슬디펜스_17135 {
	
	static int N, M, D;
	static int[][] map;
	static int[] tgt = new int[3];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 3) {
			//complete code
			
			return;
		}
		
		for(int i = srcIdx; i < M; i++) {
			tgt[tgtIdx] = i;
			comb(srcIdx+1, tgtIdx+1);
			comb(srcIdx+1, tgtIdx);
		}
	}
	
	static void attack() {
		ArrayList<Enemy> tg = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			int min = 300;
			Archer ac = new Archer(N, tgt[i]); // 각 궁수별 위치
			ArrayList<Enemy> em = new ArrayList<>(); // 각 궁수별 적
			for(int j = N-1; i >= 0; i--) {
				for(int k = 0; j < M; k++) {
					if(map[j][k] == 1) {
						if(!(distance(ac.y, ac.x, j, k) <= D) && !(distance(ac.y, ac.x, j, k) <= min)) continue; // 적의 위치가 범위내에 있으면
						Math.min(distance(ac.y, ac.x, j, k),min);
						em.add(new Enemy(j,k));
					}					
				}
			}
			int x = 100;
			int y = 100;
			for(int e = 0; e < em.size(); e++) {
				if(x > em.get(e).x) {
				x = Math.min(em.get(e).x , x);
				y = em.get(e).y;
				}
			}
//			tg.add(new Enemy(y,x)); // 공격할 애들 정함
		}
	}
	static int distance(int ay, int ax, int ey, int ex) {
		
		return (Math.abs(ay-ey) + Math.abs(ax-ex));
	}
	
	static class Archer{
		int y, x;
		
		public Archer(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static class Enemy{
		int y, x;
		
		public Enemy(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
