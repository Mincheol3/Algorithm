package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_달이차오른다가자_1194 {
	static int N, M;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static char[][] map;
	static boolean[] key;
	static int cnt;
	static boolean[][][] visit;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int sy = 0;
		int sx = -1;
		key = new boolean[6];
		map = new char[N][];
		visit = new boolean[N][M][N*M];
		for(int i = 0 ; i < N; i++) {
			map[i]  = br.readLine().toCharArray();
			if(sx == -1) {
			for(int j = 0; j < M ; j++) {
				if(map[i][j] == '0') {
					sy = i;
					sx = j;
//					System.out.println(sx);
					break;
					}
				}
			}
		}
//		System.out.println(sx);
		System.out.println(move(sy,sx,0));
	}
	
//	static int move(int sy, int sx, int cnt) {
//		if(map[sy][sx] == 1) return cnt;
//		for(int i = 0; i < 4; i++) {
//			int ny = sy + dy[i];
//			int nx = sx + dx[i];
//			
//			
//			if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == '#') continue; // 벽이거나 범위 넘으면 out
//			int k = map[ny][nx];
//			if(65 <= k && k <= 70 && !key[k-65]) continue;
//			if(97 <= k && k <= 102) {
//				key[k-97] = true;
//				move(ny, nx, cnt++);
//			}
//			else move(ny, nx, cnt++);
//			
//			
//		}
//		
//		return -1;
//	}
	static int move(int sy ,int sx, int cnt) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(sy,sx,0, cnt));
		visit[sy][sx][0] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(map[n.y][n.x] == '1') return n.count;
			for(int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == '#' || visit[ny][nx][n.n]) continue;
				
				int k = map[ny][nx];
//				System.out.println(map[ny][nx] + " "+ k);
			
				
				if(65 <= k && k <= 70 && !key[k-65]) continue;
				if(97 <= k && k <= 102) {
					key[k-97] = true;
					visit[ny][nx][n.n]= true; 
					
					q.offer(new Node(ny,nx,n.n +1,n.count+1));
				}
				else if(65 <= k && k <= 70) {
					visit[ny][nx][n.n]= true; 
					q.offer(new Node(ny, nx, n.n, n.count+1));
				}
				else if(k == 46) {
					visit[ny][nx][n.n] = true;
					q.offer(new Node(ny,nx,n.n, n.count+1));
				}
					
				else {
					visit[ny][nx][n.n]= true;
					q.offer(new Node(ny,nx,n.n,n.count+1)); //키 가지고 있을때
				}
			}
			
		}
		
		
		return -1;
	}
	
	static class Node{
		int y;
		int x;
		int n;
		int count;
		public Node(int y, int x ,int n, int count) {
			this.y = y;
			this.x = x;
			this.n = n;
			this.count = count;
		}
	}

}
