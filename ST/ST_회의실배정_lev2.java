import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ST_회의실배정_lev2 {
    static int N, M;
    static PriorityQueue<Room> rooms = new PriorityQueue<Room>((e1, e2) -> e1.name.equals(e2.name) ? e1.s - e2.s : e1.name - e2.name);
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N; i++){
            br.readLine();
        }


       }

       static class Room{
        String name;
        int s;
        int e;
        Room(String name, int s, int e){
            this.name = name;
            this.s = s;
            this.e = e;
        }
       }
}
