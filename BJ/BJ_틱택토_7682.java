import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 골드 5 https://www.acmicpc.net/problem/7682 
// X, O 의 갯수 차이 생각 해야함.
// O 가 더 많을 수 없음.
// O 가 이겼을땐 X, O 갯수가 같아야함
// X가 이기거나 비겼을 땐 X가 더 많아야함.
public class BJ_틱택토_7682 {
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        String str;
        char[] map = new char[9];
        while(true){

            
            str = br.readLine();
            if(str.equals("end")) break;

            map = str.toCharArray();            
            
            int nx = 0;
            int no = 0;

                for(int i = 0; i < 9; i++){
                    if(map[i] == 'X') nx++;
                    else if(map[i] == 'O') no++;
                }
            //  둘다이기면 invalid
            if(xTicTacToe(map) && oTicTacToe(map)){
                sb.append("invalid").append("\n");
            }
            // x 가 이길때
            else if(xTicTacToe(map)){
          
                // x 가 o 보다 1 커야함
                if(no+1 == nx){
                    sb.append("valid").append("\n");
                    
                }
                else sb.append("invalid").append("\n");
            }
            // O 가 이겼을 때
            else if(oTicTacToe(map)){
                    
                // if(nx < no || Math.abs(no-nx) >= 2)
                // O 와 X 의 갯수가 같아야함
                if(nx == no && (nx+no) != 9 ){
                    sb.append("valid").append("\n");
                    
                }
                else sb.append("invalid").append("\n");
            }
            else{
            

                if(no+1 == nx && (no+nx) == 9){
                    sb.append("valid").append("\n");
                }
                else sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb.toString());
        
    }

    static boolean xTicTacToe(char[] map){
        if(((map[0] == map[1] && map[1] == map[2]) && map[0] == 'X') || 
           ((map[3] == map[4] && map[4] == map[5]) && map[3] == 'X') ||
           ((map[6] == map[7] && map[7] == map[8]) && map[6] == 'X') ||
           ((map[0] == map[3] && map[3] == map[6]) && map[0] == 'X') ||
           ((map[1] == map[4] && map[4] == map[7]) && map[1] == 'X') ||
           ((map[2] == map[5] && map[5] == map[8]) && map[2] == 'X') ||
           ((map[0] == map[4] && map[4] == map[8]) && map[0] == 'X') ||
           ((map[2] == map[4] && map[4] == map[6]) && map[2] == 'X')) 
           return true;

           else return false;

    }

    static boolean oTicTacToe(char[] map){
        if(((map[0] == map[1] && map[1] == map[2]) && map[0] == 'O') || 
        ((map[3] == map[4] && map[4] == map[5]) && map[3] == 'O') ||
        ((map[6] == map[7] && map[7] == map[8]) && map[6] == 'O') ||
        ((map[0] == map[3] && map[3] == map[6]) && map[0] == 'O') ||
        ((map[1] == map[4] && map[4] == map[7]) && map[1] == 'O') ||
        ((map[2] == map[5] && map[5] == map[8]) && map[2] == 'O') ||
        ((map[0] == map[4] && map[4] == map[8]) && map[0] == 'O') ||
        ((map[2] == map[4] && map[4] == map[6]) && map[2] == 'O'))
        return true;

        else return false;
    }

    
    
}
