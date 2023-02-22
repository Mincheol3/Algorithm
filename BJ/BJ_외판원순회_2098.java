package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_외판원순회_2098 {

	static long min = Long.MAX_VALUE;
	static int N;
	static int cost[][];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1][N+1];
		StringTokenizer st ;
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken()); // i 에서 j 가는 비용
			}
			
		}
		for(int i = 1; i <= N; i++) {
			Arrays.fill(cost[0], 0);
			dfs(i, i, 0, 0);
		}
		System.out.println(min);
	}
	static void dfs(int x,int sx, long c, int cnt) {
		cost[0][sx] = 1;
		if(cnt == N -1) {
			if(cost[sx][x] == 0) return;
			min = Math.min(min, c + cost[sx][x]);  
			return;
		}
			int index = 0;
			int val = Integer.MAX_VALUE;
			for(int j = 1; j <= N; j++) {
				if(cost[0][j] == 1 || cost[sx][j] == 0) continue;
				if(val >= cost[sx][j]) {
					val = cost[sx][j];
					index = j;
				}
			}
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 1; i<= N; i++) {
				if(cost[sx][i] == val) {
					arr.add(i);
				}
			}
			for(int i = 0; i < arr.size(); i++) {
			dfs(x, arr.get(i), c + val, cnt+1);
			}
			cost[0][sx] = 0;
		
	}
}
