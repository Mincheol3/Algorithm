package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_키순서_5643 {

	static int T, N, M, ans;
	static boolean[][] stu;
	static int Cnt1, Cnt2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine()); // 입력받기
			stu = new boolean[N + 1][N + 1]; // 대소관계 배열
			StringTokenizer st;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				stu[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}

			for (int i = 1; i <= N; i++) {
				Cnt1 = 0;
				Cnt2 = 0;
				//  작은 애
				shorts(i, new boolean[N + 1]);
				//  큰 애
				tall(i, new boolean[N + 1]);
				if (Cnt1 + Cnt2 + 1 == N) ans++;
			}
			System.out.println("#" + t + " " + ans);
		}

	}

	static void shorts(int b, boolean[] visited) { // 작은애
		visited[b] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && stu[i][b]) {
				shorts(i, visited);
				Cnt1++;
			}
		}
	}

	
	static void tall(int a, boolean[] visited) { // 키 큰애
		visited[a] = true;
		for (int j = 1; j <= N; j++) {
			if (!visited[j] && stu[a][j]) {
				tall(j, visited);
				Cnt2++;
			}
		}
	}

}
