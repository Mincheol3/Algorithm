package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_달팽이숫자_1954 {
	static int T;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int num = Integer.parseInt(br.readLine());
			int[][] Arr = new int[num][num];
			int size = num;
			int number = 1;
			int col = 0;
			int row = -1;
			int change = 1; // 위치조정
			while(true) {
		
				for(int i = 0; i < num; i++) {
					row += change;
					Arr[col][row] = number++;
				}
				num--;
				if(num == 0) break; //종료
				for(int i = 0; i < num; i++){
					col += change;
					Arr[col][row] = number++;
				}
				change *= -1;
				
			}
			System.out.println("#" + t );
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					System.out.print(Arr[i][j] + " " );
				}
				System.out.println();
			}
		}
	}

}
