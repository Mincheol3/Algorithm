package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_백설공주와일곱난쟁이_3040 {
	static int[] Array = new int[9];
	static int[] ans = new int[7];
	static StringBuilder sb = new StringBuilder();
	static boolean done;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			Array[i] = Integer.parseInt(br.readLine());
		}
//		Arrays.sort(Array);
		comb(0,0);
		
		

	}
	
	static void comb(int tgtIdx, int srcIdx) {
		if(done) return;
		if(tgtIdx == 7) {
			int sum = 0;
			for(int i = 0 ; i < 7 ; i++) {
				sum +=ans[i];
				if(sum > 100) break;
			}
			if(sum == 100) {
				done = true;
				for(int i = 0; i < 7; i++) {
					System.out.println(ans[i]);
				}
			}
			return;
		}
		
		for(int i = srcIdx ; i < 9; i++) {
			
			ans[tgtIdx] = Array[i];  
			comb(tgtIdx + 1, i+1);
		}
	}

}
