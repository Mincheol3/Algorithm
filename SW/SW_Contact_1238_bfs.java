package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_Contact_1238_bfs {
	
	static boolean[][] Check;
	static int N, S, ans;
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			Check = new boolean[101][101]; //숫자의 범위가 1 ~ 100 이라고 해서, 0 인덱스는 더미로 두고 생성 
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N/2; i++) { // 입력받기.
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				Check[y][x] = true; // 연결관계가 있는 번호는 true
			}
			ans = bfs(S); // 첫 시작 값을 넘겨줍니다 !
			System.out.println("#" +t+ " " + ans);
			for(int i = 0 ; i < 101; i++) {  // 배열 초기화 부분

				for(int j = 0 ; j < 101; j++) {

					Check[i][j] = false;
				}

			}
			
		}

	}
	
	static int bfs(int Start) { //시작하는 값을 파라미터로 받습니다.
		Queue<Integer> que = new LinkedList<>();
		que.add(Start);
		Check[0][Start] = true; // 저는 Check의 1행을 visit 으로 활용 했습니다. Check[0][1] == true 이면 1번을 방문한적이 있다는  뜻입니다.
		int[] depth = new int[101]; // 각 번호의 깊이를 기록하기 위해 생성
		depth[Start] = 1; //첫번째 받은 번호의 깊이는 1.
		while(!que.isEmpty()) {
			 Start = que.poll(); 
			
			for(int i = 1; i <= 100; i++) {
				if(!Check[0][i] && Check[Start][i]) { // i 번호를 방문한적이 없고, Start와 연결되어 있다면
					que.add(i); // i 번호를 큐에 추가 
					Check[0][i] =true; // i 번호를 방문했다고 체크
					depth[i] += depth[Start] +1; // i 는 Start와 연결된 숫자이기 때문에 Start 깊이에서  + 1
				}
			}
		}
		int idx = 1;
		for(int i = 1; i <=100; i++) { // 제일 큰 값을 구하기 위한 for 문
			if(depth[i] >= depth[idx]) {  // i가 곧 숫자이고  depth[i] 에는 해당 숫자의 깊이가 들어있습니다.
				idx = i;				//for문이 100 까지 돌기때문에 최대값 계산은 따로 할 필요없습니다
			}							
		}
		return idx;
	}
}
