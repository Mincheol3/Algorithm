package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Ladder1_1210 {
	static int dir;  // 탐색 방향 설정 ?   0 위로 / 1 왼쪽 / 2 오른쪽
	static int[][] ladder;
	static int Idx; // 도착지점의 X 인덱스 값
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			ladder = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
							
			}
			for(int i = 0; i < 100; i++) {
				if(ladder[99][i] == 2 ) {  // 도착지점의 X 값을 찾기 위해
					Idx = i;
					break;
				}
			}

			sb.append("#").append(tc).append(" ");
			findX(Idx, 99, 0);   // 도착지점의 X 인덱스, 도착지점의 Y인덱스 99, 첫 시작은 무조건 위로 올라가므로 방향성 값인 0
			
		}
		System.out.println(sb.toString());

	}
	static void findX(int Xidx, int Yidx, int dir) {  //도착지점부터 거슬러 올라가서 시작점의 X 찾기 !!
		if(Yidx == 0) {
			sb.append(Xidx).append("\n");
			return ;
		}
		switch(dir) {
		case 0 :  
			if(Xidx > 0 && ladder[Yidx-1][Xidx-1] == 1) {  // 위로 올라가기 전 윗 쪽 좌측에 1 이 있다면 좌측으로 가라는 dir 1을 넘겨주고 Yidx 값 감소
				findX(Xidx, Yidx-1, 1);
			}
			else if(Xidx < 99 && ladder[Yidx -1][Xidx +1] == 1) { // 위로 올라가기 전 오른쪽에 1 이 있다면 좌측으로 가라는 dir 2을 넘겨주고 Yidx 값 감소
				findX(Xidx, Yidx-1, 2);
			}
			else findX(Xidx, Yidx-1, 0); //없으면 그냥 위로 한칸.
			break;
		case 1 :
			if(Xidx > 0 && ladder[Yidx][Xidx-1] == 1) { //좌측으로 가라는  dir 1을 받았기 때문에  조건 검사하고 좌측에 또 1이라면 Xidx 감소 Yidx 는 그대로 dir 도 1
				findX(Xidx-1, Yidx, 1);
			}
			else if(Xidx < 99 && ladder[Yidx -1][Xidx +1] == 1) { // 바로 옆에 1이 없고 한칸위의 오른쪽에 1 이 있다면 dir 2 넘겨주고 한칸 위로.
				findX(Xidx, Yidx-1, 2);
			}
			else if(Xidx > 0 && ladder[Yidx-1][Xidx-1] == 1) {  // 바로 옆에는 1이 없지만 한칸위의 좌측에 1이 있다면 dir 1 넘겨주고 한칸 위로.
				findX(Xidx, Yidx-1, 1);
			}
			else findX(Xidx, Yidx-1, 0); // 모두가 아니라면 그냥 한칸위로 dir 은 0
			break;
		case 2 :
			if(Xidx < 99 && ladder[Yidx][Xidx +1] == 1) {  // case 1과 로직 동일.
				findX(Xidx+1, Yidx, 2);
			}
			else if(Xidx < 99 && ladder[Yidx -1][Xidx +1] == 1) {
				findX(Xidx, Yidx-1, 2);
			}
			else if(Xidx > 0 && ladder[Yidx-1][Xidx-1] == 1) {
				findX(Xidx, Yidx-1, 1);
			}
			else findX(Xidx, Yidx-1, 0);
			break;
			
		}
	
	}

}
