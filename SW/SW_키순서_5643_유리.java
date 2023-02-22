package sw;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 단방향 그래프
 * 음.. 들어오는 수랑 나가는 수로 따지면..?
 * 진입 진출 노드 확인하면서 이어져있는지 체크하면서?
 * 
 */

public class SW_키순서_5643_유리{
	
	static int N, M, ans; // N: 학생들의 수, M: 학생의 키를 비교한 횟수, ans: 지 키 순서 아는 애 수
	static int sCnt, tCnt; // sCnt: 나보다 작은 애 수, tCnt: 나보다 큰 애 수
	static int[][] matrix; // 인접행렬
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테케 수
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			matrix = new int[N+1][N+1];
			
			// 답 초기화시켜주기
			ans = 0;
			
			for(int i=0; i<M; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				// 단방향
				matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
				
			}
			
			// 입력확인
			// print();
			
			// 진입노드 수랑 진출노드 수 세기
			for(int i=1; i<=N; i++) {
				sCnt = 0;
				tCnt = 0;
				// 나보다 작은 애
				shorter(i, new boolean[N+1]);
				// 나보다 큰 애
				taller(i, new boolean[N+1]);
				if(sCnt + tCnt + 1 == N) ans++;
			}
			
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	// 작은 애 수 구하기 (행이 작은 쪽 열이 큰 쪽 -> 체크하는 쪽은 행이어야)
	static void shorter(int b, boolean[] visited) {
		visited[b] = true;
		for(int i=1; i<=N; i++) {
			if(!visited[i] && matrix[i][b]!=0) {
				shorter(i, visited);
				sCnt++;
			}
		}
	}

	// 큰 애 수 구하기 (행이 작은 쪽 열이 큰 쪽 -> 체크하는 쪽은 열이어야)
	static void taller(int a, boolean[] visited) {
		visited[a] = true;
		for(int j=1; j<=N; j++) {
			if(!visited[j] &&  matrix[a][j]!=0) {
				taller(j, visited);
				tCnt++;
			}
		}
	}
	 
	static void print() {
		for(int[] nn : matrix) {
			System.out.println(Arrays.toString(nn));
		}
	}
}
