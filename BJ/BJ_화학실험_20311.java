import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_화학실험_20311 {

    static reagent next;
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static PriorityQueue<reagent> pq = new PriorityQueue<reagent>((r1, r2) -> r2.num - r1.num);

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(st.nextToken());
            pq.offer(new reagent(i, n));

        }

        if(K > 1){

            reagent cur = pq.poll();
            reagent next = pq.poll();

            int ccnt = cur.num;
            int cidx = cur.idx;
            int ncnt = next.num;
            int nidx= next.idx;

            while(true){
                
                if(ccnt != 0 && ncnt != 0){
                    sb.append(cidx+1 + " ").append(nidx+1 + " ");
                    ccnt--;
                    ncnt--;
                }
                else if(ccnt == 0 && ncnt == 0){
                   
                    if(pq.size() == 0) break;
                    else if(pq.size() == 1){
                        if(pq.peek().num > 1){
                            System.out.println(-1); return;
                        }
                        else{
                            sb.append(pq.peek().idx+1);
                            break;
                        }
                    }
                    //pq size가 2 이상이면 
                    else {
                        cur = pq.poll();
                        ccnt = cur.num;
                        cidx = cur.idx;
                        next = pq.poll();
                        ncnt = next.num;
                        nidx = next.idx;
                    }
                }
                else if(ccnt == 0){

                    if(!pq.isEmpty()){
                        cur = pq.poll();
                        ccnt = cur.num;
                        cidx = cur.idx;
                    }
                    else {
                        System.out.println(-1);
                        return;
                    }
                }
                else if(ncnt == 0){
                    if(!pq.isEmpty()){
                        next = pq.poll();
                        ncnt = next.num;
                        nidx = next.idx;
                    }
                    else if(ccnt == 1){
                        sb.append(cidx+1);
                        ccnt--;
                    }
                    else{
                        System.out.println(-1);
                        return;
                    }
                }
                if(pq.isEmpty() && ccnt == 0 && ncnt == 0) break;
            }
            System.out.println(sb.toString());
        }
        else{
            if(pq.peek().num == 1){
                System.out.println(pq.peek().idx+1);
            }
            else{
                System.out.println(-1); return;
            }
        }

      

    }

    static class reagent {

        int idx;
        int num;

        reagent(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
