package bj;

import java.util.Scanner;

public class BJ_1로만들기_1463_pro_재귀 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(dp(N));
	}
	
	static int dp(int n) {
		if(n == 1) return 0;
		if(n == 2) return 1;
		
		if(n % 2 == 0 && n % 3 == 0) return Math.min(Math.min(1+dp(n-1), 1+dp(n/2)),Math.min(1+dp(n-1), 1+dp(n/3))); 
		
		else if(n % 2 == 0) return Math.min(1+dp(n-1), 1+dp(n/2));
		
		else if(n % 3 == 0) return Math.min(1+dp(n-1), 1+dp(n/3));
		
		else return (1+dp(n-1));
	}

}
