import java.io.*;
import java.util.*;

public class BJ_후위표기식_1918 {
    
    public static void main(String[] args) throws Exception{
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            switch(c){

                case '+':
                case '-':
                case '*':
                case '/':
                    while(!st.isEmpty() && priority(st.peek()) >= priority(c)){
                        sb.append(st.pop());
                    }
                    st.add(c);
                    break;
                case '(':
                    st.add(c);
                    break;
                case ')': 
                    while(!st.isEmpty() && st.peek() != '(') 
                    sb.append(st.pop());
                    st.pop();
                    break;
                default :
                    sb.append(c);
                
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(sb.toString());

        
    }
    public static int priority(char c){
        
        if( c == '(' || c == ')') return -1;
        if(c == '+' || c == '-') return 0;
        if(c == '*' || c == '/') return 1;
        else return -2;
    }
}
