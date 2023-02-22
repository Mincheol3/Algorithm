import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_오큰수_17298 {
    
    static int N;
    static int Arr[];
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception{
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Arr = new int[N+1];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
            
        }

        for(int i = 1; i <= N; i++){

            while(!stack.isEmpty() && Arr[stack.peek()] < Arr[i]){
                Arr[stack.pop()] =Arr[i];    
            }
            stack.add(i);
        }
        
        while(!stack.isEmpty()){

            Arr[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++){

            sb.append(Arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
