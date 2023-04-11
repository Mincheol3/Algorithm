import java.util.*;

public class PG_택배상자_131704 {

    public static int solution(int[] order) {

        Stack<Integer> st = new Stack<>();
        int answer = 0;
        int pre = 0;
        for (int i = 0; i < order.length; i++) {

            for (int j = pre + 1; j <= order[i]; j++) {

                st.add(j);
                pre = order[i];
            }
            if (!st.isEmpty() && st.peek() == order[i]) {
                answer++;
                st.pop();

            } else
                break;

        }

        return answer;
    }
}
