package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_햄버거다이어트_5215 {
	static boolean[] isSelected;
	static int T, N, L , MAX;
	static ArrayList<int[]> list = new ArrayList<>(); // 칼로리와 점수를 받기위해 배열을 가지는 Arraylist 생성
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for( int t = 1; t <= T; t++ ) {
			list.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			isSelected = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());			
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
//				System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
				
			}
			MAX = 0; //점수초기화
			generateSubset(0);
			System.out.print("#" +t+ " ");
			System.out.println(MAX);
		}
	}
public static void generateSubset(int cnt) {  //부분집합 체크해서 최고점수 얻기
		int cal = 0;
		int score = 0;
		if(cnt == N) { 
			
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
				score+= list.get(i)[0];
				cal += list.get(i)[1];
				}
			}
			if(cal <= L && score > MAX) { // 조건 체크
				MAX = score;
			}
			
			return;
		}
	
		isSelected[cnt] = false;
		generateSubset(cnt+1);
		isSelected[cnt] = true;
		generateSubset(cnt+1);
	}

}
