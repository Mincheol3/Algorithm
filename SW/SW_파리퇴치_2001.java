package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_파리퇴치_2001 {
	static int T, N, M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int max = 0;
			int sum = 0;
			map = new int[N][N];
			for(int i = 0; i < N; i++) { //배열에 값 저장
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
//					System.out.print(map[i][j] + " ");
				}
//				System.out.println();
				//br.read();
			}
			for(int i = 0; i < N; i++) {  
				for(int j = 0; j < N; j++) {
					if(i + M-1 < N && j + M-1 < N) { //파리채 범위제한
						for(int k = i; k < i +(M); k++) {
							for(int u = j; u < j+(M); u++) {  
								sum+= map[k][u];	// 파리 죽인 수
							}
						}
					}
					if(max < sum) { // 최대값 조정
						max = sum;
					}
					sum = 0; // 초기화
				}
			}
			System.out.println("#" +t + " " + max);
			
		}
	}

}
