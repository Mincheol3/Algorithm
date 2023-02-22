package sw;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import sw.SW_최소스패닝트리_3124.Edge;

import java.io.BufferedReader;

public class SW_최소스패닝트리_K_pro {

	static int T, V, E;
	static long sum;
	static int[] parent;
	static Edge[] edge;
	static int cnt;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			cnt = 0 ;
			parent = new int[V+1];
			edge = new Edge[E];
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edge[i] = new Edge(x, y, c);
			}
			
			sum = 0;
			Arrays.sort(edge, (n1,n2) -> n1.c - n2.c);
			
			makeSet();
			for(int i = 0; i < E; i++) {
				Edge e = edge[i];
				
//				if(findSet(e.v1) == findSet(e.v2)) continue; // 기본적인 findset union 활용
//				
//				union(e.v1, e.v2);
//				sum+= e.c;
//				cnt++;
				if(union(e.v1, e.v2)) {  // union 변형
					sum += e.c;
					cnt++;
				}
				
				if(cnt == V-1) break;
			}
		}
		
		
	}
	
	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
//	static void union(int x, int y) {  // findSet 이 중복으로 연산됨
//		int py = findSet(y);
//		int px = findSet(x);
//		if(px < py) parent[py] = px;
//		else parent[px] = py;
//	}
	
	static boolean union(int x, int y) {
		
		int py = findSet(y);
		int px = findSet(x);
		
		if(px == py) return false;
		if(px < py) parent[py] = px;
		else parent[px] = py;
		return true;
	}
	
	static class Edge{
		int v1;
		int v2;
		int c;
		
		public Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}

}
