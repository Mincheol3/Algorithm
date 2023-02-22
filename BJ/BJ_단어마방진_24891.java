import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_단어마방진_24891 {

    static int L, N;
    static String[] words;
    static boolean[][] visited = new boolean[20][5];

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        words = new String[N];

        for (int i = 0; i < N; i++){
            
            words[i] = br.readLine();
        }

        Arrays.sort(words);


        

    }

    static void DFS(int cnt){
        
        if(cnt == L){
            boolean flag = true;

            for(int i = 0; i < L; i++){
                for(int j = i+1; j < L; j++){
                    
                }
            }
        }
    }
}
