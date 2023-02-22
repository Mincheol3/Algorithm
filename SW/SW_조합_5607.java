package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_조합_5607 {
	
	static int T, N, R;
	static long fac[] = new long[1000001];
	static int MOD = 1234567891;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		factorial();
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t<= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			
			long a1 = fac[N];   //  N! % MOD   분자부분
			
			long a2 = (fac[N-R]*fac[R])%MOD;  // 분모 부분  
			
			long a3= power(a2, MOD-2);
			
			System.out.println("#"+ t + " " + a1*a3 % MOD);
			
		}
		

	}
	
	static void factorial() {
		fac[0] = 1;
		for(int i = 1; i <= 1000000; i++) {
			fac[i] = fac[i-1] * i % MOD;
		}
	}
	
//	static long power(long x , long y) {
//		if(y == 1) {
//			return x;
//		}
//		long a = power(x, y/2) % MOD;
//		if(y % 2 == 0) {  // 지수가 짝수이면
//			return a * a % MOD;    // ex)  a^100 % MOD ==> (a^50)^2 %MOD
//		}else { 
//			return ((a * a) % MOD * x) % MOD; // ex) a^101 % MOD => ((a^50)^2 % MOD * a) % MOD
//		}
//	}
	
	static long power(long x, long y) {
		long result = 1L;
		
		while( y > 0) {
			if (y % 2 == 1) result = (result * x) % MOD;
			
			y = y >> 1;  // 지수 반토막
			x = (x * x) % MOD;
		}
		return result;
	}

}
