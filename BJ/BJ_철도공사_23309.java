import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_철도공사_23309 {
    
    static int N, M;
    static StringBuilder sb = new StringBuilder();
     public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 노드, 역 초기화
        Node now = null;
        Station station = new Station();

        st = new StringTokenizer(br.readLine());

        // 최초 역 연결하기
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            Node newNode = new Node(num);
            station.add(now, newNode);
            now = newNode;
        }
        //공사 시행하기
        while(M > 0){
            
    
            int extranum = 0;
            st = new StringTokenizer(br.readLine());

            String work = st.nextToken();
            int targetnum = Integer.parseInt(st.nextToken());
            Node targetNode = station.find(targetnum);
            
            if(st.hasMoreTokens()) extranum = Integer.parseInt(st.nextToken());

            if(work.equals("BN")){
                    sb.append(targetNode.next.num).append("\n");
                    Node newNode = new Node(extranum);
                    station.add(targetNode, newNode);
            }
            else if(work.equals("BP")){
                    sb.append(targetNode.prev.num).append("\n");
                    Node newNode = new Node(extranum);
                    station.add(targetNode.prev, newNode);
            }
            else if(work.equals("CN")){
                sb.append(targetNode.next.num).append("\n");
                station.delete(targetNode.next);
            }
            else {
                sb.append(targetNode.prev.num).append("\n");
                station.delete(targetNode.prev);
            }
            M--;
            
        }
        System.out.println(sb.toString());
        

        
    }

    static class Node{
        int num;
        Node prev;
        Node next;
        Node(int num){
            this.num = num;
            this.prev = null;
            this.next = null;
        }
    }

    static class Station{
        Node head;
        
        Station(){
            head = null;
        }


        void add(Node target, Node newNode){
            if(target == null){
                head = newNode;
                newNode.next = newNode.prev = newNode;
                return;
            }
            newNode.prev = target;
            newNode.next = target.next;
            target.next.prev = newNode;
            target.next = newNode;
        }

        void delete(Node target) {
            target.prev.next = target.next;
            target.next.prev = target.prev;

            if(target.num == this.head.num)this.head = target.next;
            target = null;
        }
        
        Node find(int n){
            Node now = head;
            while(now.num != n){
                if(now.num == n) break;
                now = now.next;
            }
            return now;
        }
    }
}
