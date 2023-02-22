package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_게리맨더링_17471 {
	
	static int N;
	static int people[];
	static boolean bj[][];
	static int tgt[];
	static int max;
	static boolean[] select;
	static int parent[];
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		bj = new boolean[N+1][N+1];
		people = new int[N+1];
		select = new boolean[N+1];
		tgt = new int[N];
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken()); // people[i] -- i 구역의 인구 수
			max += people[i];
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n ; j++) {
				int x = Integer.parseInt(st.nextToken());
				bj[i][x] = true;
				if(bj[i][x]) {
					union(i,x);
				}
			}
			
		}
		
	}
	
	static void comb(int idx, int cnt) {
		if(cnt == N) {
			int num = 0;
			for(int i = 1; i <= N; i++) {
				if(select[i]) num++;
			}
			if(num == 0 || num == N) return;
			int[] tgu = new int[num];
			int[] fgu = new int[N-num];
			int t = 0;
			int f = 0;
			for(int i = 1; i <= N; i++) {
				if(select[i]) {
					tgu[t] = i;
					t++;
				}
				else {
					fgu[f] = i;
					f++;
				}
			}
			
			
			return;
		}
		
		for(int i = idx; i <= N; i++) {
			
				select[i] =  true;
				comb(idx + 1, cnt++);
				select[i] = false;
			}
			
		}
	
	static int find(int x) {
		if(parent[x] == x)
			return x;
		return find(parent[x]);
	}
	static void union(int y, int x) {
		int ry = find(y);
		int rx = find(x);
		
		if(ry > rx) {
			parent[y] = rx;
		}
		else parent[x] = ry;
	}
	
//	static boolean dfs(int[] gu) {
//		int cnt = 1;
//		if(cnt == gu.length) return true;
//		
//		for(int i = 1; i <= gu.length; i++) {
//			
//		}
//	}
	
}
