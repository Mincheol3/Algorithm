package BJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_색종이_2563 {

	static int N, paper[][];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		paper = new int[100][100];
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j = 99 - y ; j > 89 - y; j--) {
				for(int k = x; k < x + 10; k++) {
					paper[j][k] = 1;
				}
			}
			
		
		}
		int count = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j <100; j++) {
				if(paper[i][j] == 1) count++;
			}
		}
		System.out.println(count);
	}

}
