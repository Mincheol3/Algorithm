package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_최소스패닝트리_3124 {
	
	static ArrayList<Integer> valArr;
	static int T, V, E;
	static int[] Matrix;
	static Queue<Edge> que;
	static long ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			que = new PriorityQueue<>((n1,n2) -> n1.val -n2.val);
//			visit = new boolean[V+1];
			Matrix = new int[V+1];
			valArr = new ArrayList<>();
			setMatrix();
	
			
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				que.add(new Edge(x, y, c));
			}
			
			for(int i = 0; i < E; i++) {
				Edge e = que.poll();
				if(findSet(e.start) == findSet(e.end)) continue;
				union(e.start, e.end);
				ans += e.val;
				
			}
//			for(int i = 0 ; i < valArr.size(); i++) {
//				ans += valArr.get(i);
//				}
			System.out.println("#" +t+ " " + ans);
			que.clear();
		}

	}
	static void setMatrix() {
		for(int i = 1; i <= V; i++) {
			Matrix[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(Matrix[x] == x) return x;
		else return Matrix[x] = findSet(Matrix[x]);
		
	}
	static void union(int y, int x) {
		int py = findSet(y);
		int px = findSet(x);
		
		if(py != px) Matrix[py] = px;
	}
	static class Edge{
		int start;
		int end;
		int val;
		
		Edge(int start, int end, int val){
			this.start = start;
			this.end = end;
			this.val = val;
		}
	}

}
