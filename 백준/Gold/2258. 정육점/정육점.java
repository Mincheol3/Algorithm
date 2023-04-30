import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int weight;
    static int min;
    static int[] meat, cost;
    static PriorityQueue<meat> pq = new PriorityQueue<>((e1, e2) -> e2.c == e1.c ? e2.w - e1.w : e1.c - e2.c);

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        meat = new int[N];
        cost = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new meat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int prew = pq.peek().w;
        int prec = pq.poll().c;
        // 같은 가격 고기 개수
        int cnt = 1;
        int cost = 0;
        weight += prew;

        while (!pq.isEmpty()) {
            meat m = pq.poll();
            int w = m.w;
            cost = m.c;

            weight += w;
            // 이전 가격과 현재 가격이 같으면
            if (prec / cnt == cost) {
                cnt++;
                // 같은 가격의 고기를 산 수
                cost = cost * cnt;

                // 원하는 무게 됐으면
                if (weight >= M && min == Integer.MAX_VALUE) {
                    min = cost;

                }
                // 이전 가격보다 비쌀 때
            } else if (prec/cnt < cost) {
                // System.out.println(weight);
                cnt = 1;

                if (weight >= M) {
                    System.out.println(Math.min(cost, min));
                    return;
                }
            }

            prec = cost;
            // prew = w;
        }
        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
            return;
        }
        if (weight >= M) {
            System.out.println(prec);
        } else
            System.out.println(-1);

    }

    static class meat {

        int w;
        int c;

        meat(int w, int c) {
            this.w = w;
            this.c = c;
        }
    }
}
