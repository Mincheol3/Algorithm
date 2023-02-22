import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_사과나무_19539 {
 
    static int N, sum;
    static int[] tree;
    static int odd;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            sum += tree[i];
            if(tree[i] %2 == 1) odd++;
        }
        if(sum % 3 != 0){
            System.out.println("NO");
            return;
        }

        else{
            if(sum / 3 >= odd) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}
