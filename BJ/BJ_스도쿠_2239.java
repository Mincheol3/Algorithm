package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_스도쿠_2239 {
	static boolean nineCheck;
	static boolean sdocu[][][] = new boolean[10][10][10];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 1; i <= 9; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = br.readLine();
			for(int j = 1; j <= 9; j++) {
				
				sdocu[i][j][str.charAt(j-1)-'0'] = true;
			}
		}
//		int row = 1;
//		int col = 1;
//		for(int i = 1; i <= 9; i++) {
//			if(Check)
//		}
		solve(1,1);
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				for(int k = 1; k<= 9; k++) {
					if(sdocu[i][j][k]) {
						System.out.print(k);
						break;
					}
				}
			}
			System.out.println();
		}
	}
	
	static boolean Check(int row,int col,  int num) { // 주어진 행과 열에 해당 num 이 있는지 
			for(int j = 1; j<= 9; j++) {
				if(sdocu[row][j][num]) return false;
				if(sdocu[j][col][num]) return false;
			}
	
		return true;
	}
	
	static void solve(int row, int col) {
		if(row % 3 == 0 && (col % 3 == 1 && col > 3)) {
			Check9(row, col);
		}
		if(!nineCheck) return;
		if(row == 10) return;
		
		for(int i = 1; i <= 9; i++) {
//			nineCheck = true;
			if(Check(row,col,i)) {
				sdocu[row][col][i] = true;
				if(col <9) solve(row, col+1);
				else solve(row+1,1);
				sdocu[row][col][i] = false;
			}
		}
	}
	
	static void Check9(int row, int col) {  // 사각형이 1 ~ 9 까지 포함하고있는지
		boolean[] nine = new boolean[10];
		for(int i = row -2; i <= row; i++) {
			for(int j = col-3; j < col; j++) {
				for(int k = 1; k <= 9; k++) {
					if(sdocu[i][j][k]) {
						nine[k] =true;
						break;
					}
				}
			}
		}
		for(int i = 1; i <= 9; i++) {
			if(!nine[i]) {
				nineCheck = false;
				return;
			}
		}
		nineCheck = true;
	}

}
