import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_드래곤앤던전_16434 {
    
    static long maxHp, curHp, atk;
    static long spHp, spMon;
    static int N;
    // static Queue<Room> rooms = new LinkedList<Room>();
    static ArrayList<Room> rooms = new ArrayList<Room>();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        atk = Integer.parseInt(st.nextToken());
        long sAtk =atk;
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            rooms.add(new Room(t, a, h));
        }
       
            int n = 0;
            maxHp = 1;
            curHp = 1;
               while(n < N){
                    boolean isWin = true;
                    Room room = rooms.get(n);
                    if(room.t == 1){
                        // 전투
                        isWin = battle(room, curHp);
                    }
                    else{
                        atk += room.a;
                        if(maxHp < curHp + room.h){
                            curHp = maxHp;
                        }
                        else curHp += room.h;
                    }
                    if(isWin){
                        n++;
                    }
                    else {
                        n = 0;
                        maxHp = spMon;
                        curHp = spMon;
                        atk = sAtk;
                        
                    }
                }
                System.out.println(maxHp);
        
    }

    static class Room{

        int t, a, h;

        Room(int t, int a, int h){
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }

    static boolean battle(Room room, long hp){
        int monHp = room.h;
        int monAtk = room.a;

        while(true){
            // //용사 선공
            // monHp -= atk;
            // if(monHp <= 0) return true;
            // // 몬스터 후공
            // curHp -= monAtk;
            double n = (double)monHp/atk;
            double n2 = (double) curHp / monAtk;

            //용사가 총 공격해야하는 횟수
            long n3 = (long)(Math.ceil(n));
            // 몬스터가 공격 몇번해야 용사 죽이는지
            long n4 = (long)(Math.ceil(n2));
            // System.out.println(n4);

            if(n3 <= n4){
                curHp = curHp - monAtk*(n3-1);
                return true;
            }
            else{
                monHp = (int) (monHp - atk*n4);
                double mhp = (double)monHp/ atk;
                // spMon = (long) (Math.ceil(mhp) * monAtk + hp);
                spMon = (long) (Math.ceil(mhp) * monAtk)+ (n4-1)*monAtk+1;
                return false;
            }
            // System.out.println(Math.ceil(17/3));
            // if(curHp <= 0) {
            //     double mhp = (double)monHp/ atk;
            //     spMon = (long) (Math.ceil(mhp) * monAtk + hp);
            //     // System.out.println();
            //     // System.out.println(mhp);
            //     return false;
            // }
        }
    }
}
