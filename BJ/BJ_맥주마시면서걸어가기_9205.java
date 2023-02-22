package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_맥주마시면서걸어가기_9205 {
	
	static int T, N, sy, sx, ey , ex;
	static PriorityQueue<cu> pq = new PriorityQueue<cu>();
	static ArrayList<cu> CU = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1 ; t <= T; t++) {
			
			CU.clear();
			pq.clear();
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i ++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				CU.add(new cu(y, x));
			
			}
			
			st = new StringTokenizer(br.readLine());
			
			
			ey = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			
				boolean check =false;
				pq.offer(new cu(sy,sx));
				boolean[] visit = new boolean[N];
				while(!pq.isEmpty()) {
					
					cu c = pq.poll();
					int y = c.y;
					int x = c.x;
					if(distance(ey,ex, y, x)) {
//						System.out.println("happy");
						sb.append("happy").append("\n");
						check = true;
						break;
					}
					for(int j = 0; j < N ; j++) {
//						System.out.println("j = " + j);
						if(distance(y, x, CU.get(j).y, CU.get(j).x) && !visit[j]) {
//							System.out.println("j = " + j);
							pq.offer(CU.get(j));
							visit[j] = true;
							
						}
					}
				}
				
//			 if(!check) System.out.println("sad");
			 if(!check) sb.append("sad").append("\n");
		}
		System.out.println(sb.toString());

	}
	static boolean distance(int x1, int y1 ,int x2, int y2) {
		
		if(Math.abs(x1-x2) + Math.abs(y1-y2) <= 1000) return true;
		else return false;
	}
	
	
	static class cu implements Comparable<cu>{
		int y,x;
		
		public cu(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(cu c1) {
			int dis1 = Math.abs(this.y-sy) + Math.abs(this.x - sx);
			int dis2 = Math.abs(c1.y-sy) + Math.abs(c1.x - sx);
			
			if(dis1 <= dis2 ) return -1;
			else return 1;
		}
	}

}
