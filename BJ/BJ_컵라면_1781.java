import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_컵라면_1781 {

    static int N, pre;
    static long ans;
    static PriorityQueue<Integer> select = new PriorityQueue<Integer>();
    static PriorityQueue<report> pq = new PriorityQueue<report>((r1, r2) -> r1.d == r2.d ? r2.n - r1.n : r1.d - r2.d);

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new report(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int cnt = 1;

        while (!pq.isEmpty()) {
            report r = pq.poll();
            int d = r.d;
            int n = r.n;

            if (select.size() < d) {
                select.offer(n);
            } else if (select.size() == d) {
                if (!select.isEmpty()) {
                    if (select.peek() < n) {
                        select.poll();
                        select.offer(n);

                    }

                } else
                    select.offer(n);

            }

        }
        // System.out.println(select.toString());
        while (!select.isEmpty()) {
            ans += select.poll();
        }

        System.out.println(ans);
    }

    static class report {

        int d;
        int n;

        report(int d, int n) {
            this.d = d;
            this.n = n;
        }
    }
}
