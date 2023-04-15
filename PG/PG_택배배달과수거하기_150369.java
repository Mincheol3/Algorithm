import java.util.*;

public class PG_택배배달과수거하기_150369 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        PriorityQueue<Integer> d = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] != 0) {
                d.add(i);
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (pickups[i] != 0) {
                p.add(i);
                break;
            }
        }

        int box = cap;
        int idx = 0;
        long ans = 0;
        while (!d.isEmpty() || !p.isEmpty()) {
            int dn = 0;
            int pn = 0;

            // 배달부터
            if (!d.isEmpty()) {
                idx = d.poll();
                dn = idx;
                while (box > 0 && idx >= 0) {
                    box -= deliveries[idx];
                    deliveries[idx] = 0;
                    idx--;
                }
                if (box < 0) {
                    deliveries[idx + 1] -= box;
                    d.add(idx + 1);
                } else if (box == 0) {
                    while (idx >= 0 && deliveries[idx] == 0) {
                        idx--;
                    }
                    if (idx >= 0)
                        d.add(idx);
                }

            }
            box = 0;
            // 수거
            if (!p.isEmpty()) {
                idx = p.poll();
                pn = idx;
                while (box < cap && idx >= 0) {
                    box += pickups[idx];
                    pickups[idx] = 0;
                    idx--;
                }
                if (box > cap) {
                    pickups[idx + 1] += box - cap;
                    p.add(idx + 1);
                } else if (box == cap) {
                    while (idx >= 0 && pickups[idx] == 0) {
                        idx--;
                    }
                    if (idx >= 0)
                        p.add(idx);
                }
            }
            box = cap;
            int max = Math.max(pn, dn);

            answer += (max + 1) * 2;

        }

        return answer;
    }
}
