package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_낚시왕_17143 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0 ,0};
	static int R, C, M, ans;
	static int map[][];
	static ArrayList<shark> Shark = new ArrayList<>();
	public static void main(String[] args)  throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = i;
			Shark.add( new shark(true, r, c, s, d-1, z));   // 상어 저장
			
		}
		
		for(int i = 0; i < C; i++) {
			catchShark(i);
			
			moveShark();
			
			killShark();
		}
		System.out.println(ans);
		
	}
	
	static void catchShark(int col) {
		for(int i = 0; i < R; i++) {
			if(map[i][col] != 0) {
				ans+= Shark.get(map[i][col]).z;
				Shark.remove(map[i][col]);
				break;
			}
		}
	}
	
	static void moveShark() {
		for(shark sk : Shark) {
			int r = sk.r;
			int c = sk.c;
			int s = sk.s;
			int d = sk.d;
			
			switch(d) {
			
			case 0: //상 , 하
			case 1:
				s = s % (R*2 - 2); 
				for(int i = 0; i < s; i++) {
					if(r == 0) d = 1;
					else if( r == R -1) d = 0;
					
					r += dy[d];
				}
				sk.r = r;
				sk.d = d;
				break;
			case 2:
			case 3:
				s = s % (C*2 - 2); 
				for(int i = 0; i < s; i++) {
					if(c == 0) d = 2;
					else if( c == C -1) d = 3;
					
					c += dx[d];
				}
				sk.c = c;
				sk.d = d;
				
			}
		}
//		System.out.println(ans);
	}
	
	static void killShark() {
		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = 0;
			}
		}
		
		for(int i = 0; i < Shark.size(); i++) {
			int r = Shark.get(i).r;
			int c = Shark.get(i).r;
			int z = Shark.get(i).r;
			
			if(map[r][c] == 0) {
				map[r][c] = z;
			}
			else if(map[r][c] >= z) {
				Shark.remove(i);
			}
			else Shark.remove(map[r][c]);
				
		}
	}
	

	
	static class shark{
		
		int r, c, s, d, z;
		boolean dead;
			
		public shark(boolean dead ,int r, int c, int s, int d, int z) {
			this.dead = dead;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}
