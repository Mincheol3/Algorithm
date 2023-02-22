import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_로또_6603 {
    
    static StringBuilder sb = new StringBuilder();
    static int k;
    static int[] S;
    static StringTokenizer st;
    static int[] result;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while(true){

        st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        if(k == 0 ) break;
        S = new int[k];
        result = new int[k];
        for(int i = 0; i < k; i++) {

            S[i] = Integer.parseInt(st.nextToken());
        }
        comb(0, 0);
        // System.out.println(sb.toString());

    }
    }
    static void comb( int start, int depth){

        if(depth == 6){
            print();
            // int cnt = 0;
            // for(int i = 0; i < S ; i++){
                
            //     if(check[i] == 1){
            //         System.out.print(K[i] + " ");
            //         cnt++;
            //     }
            // }
            // System.out.println();
            // sb.append("\n");
        }
        
        // for(int i = start; i < k; i++){

        //     result[i] = 1;
        //     comb(start+1, depth +1);
        //     result[i] = 0;
        // }

        for(int i = start; i < k; i++) {
			result[i] = 1;
			comb(i+1, depth+1);
			result[i] = 0;
		}
    }
    private static void print() {
		for(int i =0; i < k; i++) {
			if(result[i] == 1) {
				System.out.print(S[i]+" ");
			}
		}
		System.out.println();
	}
}
