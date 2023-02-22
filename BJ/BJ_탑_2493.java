package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_탑_2493 {
	static int N;
	static ArrayDeque<int[]> stack = new ArrayDeque<>();
//	static Stack<int[]> stack = new Stack<>(); // idx 번호와 탑 높이를 함께 넣기위해  배열을 갖는 스택
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int top;
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i <= N; i++ ) {
			top = Integer.parseInt(st.nextToken()); //현재 탑 높이
			while(!stack.isEmpty()) {  // 스택이 비어있지 않을때
				if(stack.peek()[1] > top) { // 앞의 탑이 현재의 탑보다 높다면
					sb.append(stack.peek()[0]).append(" ");
					//System.out.print(stack.peek()[0] + " "); //탑의 번호 출력
					break;
				}
				stack.pop(); //앞의 탑이 현재탑보다 높지 않다면 팝 
			}
			if(stack.isEmpty()) {
				sb.append(0).append(" ");
				//System.out.print("0 "); //스택이 비었으면 0 출력
			}
			stack.push(new int[] {i, top}); // 탑 번호와 높이 추가.
		}
		System.out.println(sb);
	
	}

}
