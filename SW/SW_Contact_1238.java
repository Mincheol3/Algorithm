package sw;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_Contact_1238 {
	
	static boolean[][] Check;
	static int N, S, Min, ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			Check = new boolean[101][101];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N/2; i++) {
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				Check[y][x] = true;
			}
			Check[0][S] = true;
			ans = 0;
			Min = 0;
			dfs(S, 0);
			
			for(int i = 0 ; i < 101; i++) {
//				System.out.println(i);
				for(int j = 0 ; j < 101; j++) {
//					if(Check[i][j])
//					System.out.print(j + " ");
					Check[i][j] = false;
				}
//				System.out.println();
			}
			System.out.println("#" +t+ " " + ans);
		}
	}
	
	static void dfs(int Start, int depth) {
		int num = Start;
		
		for(int i = 1; i <= 100; i++) {
			if(!Check[num][i] || Check[0][i])continue;
				Check[0][i] = true;
				if(Min <= depth) {
					if(depth > Min) {
						ans = i;
						Min =depth;
					}
					else if(depth == Min && ans < i){
						ans = i;
					}
//					System.out.println(num + " -> " + i + " " + depth + " " + ans);
				}
				dfs(i, depth+1);
			
		}
	}

}
