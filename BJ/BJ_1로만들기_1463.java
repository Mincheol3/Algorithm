package bj;

import java.util.Scanner;

public class BJ_1로만들기_1463 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] p = new int[N+1];
		p[1] = 0;
		p[2] = 1;
		p[3] = 1;
		
		for(int i = 4; i <= N; i++) {
			if(i % 2 != 0 && i % 3 != 0) { // 2 랑  3이랑 둘다 안 나누어 질 때
				p[i] = 1 + p[i-1];
			}
			if(i % 2 == 0 && i % 3 == 0) {
				p[i] =  Math.min(1+p[i-1],Math.min(1 + p[i/2], 1 + p[i/3]));
			}
			else if (i % 3 == 0) {
				p[i] = 1 + p[i/3];
			}
			else if(i % 2 == 0) {
				p[i] = 1 +p[i-1];
			}
			System.out.println(i + " " + p[i]);
		}
//	System.out.println(p[N]);
		
	}

}
