package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_RGB거리_1149 {
	
	static int[][] memoi;
	static int N;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		memoi = new int[N][3];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			memoi[i][0] = Integer.parseInt(st.nextToken()); // 빨강
			memoi[i][1] = Integer.parseInt(st.nextToken()); // 초록
			memoi[i][2] = Integer.parseInt(st.nextToken()); // 파랑
		}
		
		for(int i = 1; i < N; i++) {  // 끝나는 색 별로 이전까지의 값들중 최솟값 더해줌.
			memoi[i][0] += Math.min(memoi[i-1][1], memoi[i-1][2]);  
			memoi[i][1] += Math.min(memoi[i-1][0], memoi[i-1][2]);
			memoi[i][2] += Math.min(memoi[i-1][1], memoi[i-1][0]);
		}
		
		System.out.println(Math.min(Math.min(memoi[N-1][0], memoi[N-1][1]), memoi[N-1][2])); // 세개중 가장 작은 값 .
	}

}
