package BJ;  // 연결리스트로 풀면 편할 것 같아 시도 했으나, 시간 초과가 나서 , boolean 형 체크 배열을 만들어서 풀었습니다. 주석부분은 연결리스트 코드입니다 !.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_알파벳_1987 {
	
	static int[] dy = {-1, 1, 0 ,0};
	static int[] dx = {0, 0, -1, 1};
	static int R, C, ans,cnt ;
	static boolean Check[];
	static LinkedList<Character> list = new LinkedList<>();
	static char[][] map;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		Check = new boolean[26];
		map = new char[R][];
		ans = 1;
		for(int i = 0; i < R ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		nextStep(0,0);
		System.out.println(ans);

	}
	
	static void nextStep(int y, int x) {
//		list.add(map[y][x]);
		Check[map[y][x]- 'A'] = true;
	
		cnt++;
		ans = Math.max(cnt, ans);
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

//			if(ny < 0 || ny >= R || nx < 0 || nx >= C || list.contains(map[ny][nx])) {
//				continue;
//			}
			if(ny < 0 || ny >= R || nx < 0 || nx >= C || Check[map[ny][nx] - 'A']) {
				continue;
			}
			
			nextStep(ny, nx);
//			list.removeLast(); // 방금 방문했던 알파벳 제거.
			Check[map[ny][nx] - 'A'] = false;
			cnt--; // 방금 방문한 카운트 --
			
		}
		
	}

}
