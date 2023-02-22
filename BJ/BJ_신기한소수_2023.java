import java.io.BufferedReader;
import java.io.InputStreamReader;

// 맨 앞자리 수가 소수여야함 (2, 3 ,5 ,7).
// 뒷자리는 짝수와 5가 올 수 없음 (1, 3, 7, 9).

public class BJ_신기한소수_2023 {
    
    static int N;
    static StringBuilder sb;
    // 맨앞 자리 올 수 있는 수
    static String[] Left = {"2", "3", "5", "7"};
    // 뒤에 올 수 있는 수
    static String[] Right = {"1", "3", "7", "9"};
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0 ; i < 4 ; i++){
            Sosu(Left[i], 1);
        }

        System.out.println(sb.toString());
    }

    static void Sosu(String s, int len){
        // 재귀하면서 N 과 길이 같아지면 sb 추가 후 리턴
        if( len >= N){
            sb.append(s).append("\n");
            return;
        }

        for(int i = 0; i < 4; i++){
            String next = s + Right[i];
            if(check(next)){
                Sosu(next, len + 1);
            }
        }
    }

    // 소수인지 확인
    static boolean check(String s){
        
        int num = Integer.parseInt(s);
        int sqrt = (int)Math.sqrt(num);

        for(int i = 2; i <= sqrt; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}