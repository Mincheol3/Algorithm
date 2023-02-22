package BJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_쿼드트리_1992 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] Array;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Array = new char[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Array[i] = st.nextToken().toCharArray();
			
		}
		QuadTree(N, 0,0);
		System.out.println(sb.toString());
	}
	static void QuadTree(int N,  int x , int y) { // 4 분할하며 체크
		if(check(N,x,y)) {
			sb.append(Array[x][y]);
			return;
		}
		
		sb.append("(");
		QuadTree(N/2, x, y); // 좌상
		QuadTree(N/2,x, y + N/2); // 우상
		QuadTree(N/2, x+N/2,y); //좌하
		QuadTree(N/2, x + N/2, y +N/2);//우하
		sb.append(")");
		
		
		
	}
	
	static boolean check(int N , int x ,int y) {  // 압축가능한지 체크
		
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(Array[x][y] != Array[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
