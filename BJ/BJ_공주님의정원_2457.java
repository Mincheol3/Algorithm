import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class BJ_공주님의정원_2457 {

    static int N, ans;
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static Stack<Integer> s = new Stack<>();
    static PriorityQueue<flower> pick = new PriorityQueue<flower>((f1,f2)-> f1.em == f2.em ? f2.ed - f1.ed : f2.em - f1.em);
    static PriorityQueue<flower> pq = new PriorityQueue<flower>(new Comparator<flower>() {

        @Override
        public int compare(flower o1, flower o2) {

            if (o1.sm == o2.sm && o1.sd == o2.sd) {

                if (o1.em == o2.em)
                    return o2.ed - o1.ed;
                else {
                    return o2.em - o1.em;
                }
            } else if (o1.sm == o2.sm && o1.em == o2.em) {

               
                    return o1.sd - o2.sd;
               
            } else if (o1.sm == o2.sm) {
                return o2.em - o1.em;
            }
            return o1.sm - o2.sm;
        }

    });

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map.put("abc", 1);
        System.out.println(map.get("abc"));
        map.
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new flower(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        flower f = pq.poll();
        int sm = f.sm;
        int sd = f.sd;
        int em = f.em;
        int ed = f.ed;
        int preem = em;
        int preed = ed;
        int cured = ed;
        int curem = em;
        pick.offer(new flower(sm,sd,em,ed));
        while(!pq.isEmpty()){

            f = pq.poll();
            if(!pick.isEmpty()){
                // if(pick.peek().sm == f.sm) continue;
                if(pick.peek().em > f.em || (pick.peek().em == f.em && pick.peek().ed >= f.ed)) continue;
                if(f.sm < preem || (preem == f.sm && preed >= f.sd)){
                    // pick.poll();
                    if(pick.size() != 1 && pick.peek().sm < f.sm){
                        pick.poll();
                    }
                    System.out.println(f.sm + " " + f.sd + " " + f.em + " " + f.ed);
                    pick.offer(new flower(f.sm, f.sd, f.em, f.ed));
                    continue;
                }
                preem = pick.peek().sm;
                preed = pick.peek().sd;
                System.out.println(preem + " " + preed);
            
            }
        }
        System.out.println(pick.size());
    }

    static class flower {

        int sm;
        int sd;
        int em;
        int ed;

        flower(int sm, int sd, int em, int ed) {

            this.sm = sm;
            this.sd = sd;
            this.em = em;
            this.ed = ed;
        }
    }
}
