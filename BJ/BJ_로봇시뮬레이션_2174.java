import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_로봇시뮬레이션_2174 {
    
    static StringTokenizer st;
    static int A, B, M, N;
    static int[][] map;
    static ArrayList<Robot> robots = new ArrayList<Robot>();
    static ArrayList<Command> commands = new ArrayList<Command>();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\SSAFY\\robots.txt")));
        // int t = Integer.parseInt(br.readLine());
        // System.out.println(t);
        
        // for(int T = 0; T < t; T++){

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[B+1][A+1];
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i < B; i++){
            Arrays.fill(map[i], 0);
        }
        // 로봇  위치랑 방향 입력이 안받아짐  
        for(int i = 1 ; i <= N; i++){
             st = new StringTokenizer(br.readLine());
           
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                String dir = st.nextToken();
                robots.add(new Robot(x, y, dir));
                map[y][x] = i; 
                
            
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            
                int x = Integer.parseInt(st.nextToken());
                String dir = st.nextToken();
                int y = Integer.parseInt(st.nextToken());
                
                commands.add(new Command(x, dir, y));
            
        }

        for(int i = 0 ; i < M; i++){

            Command c = commands.get(i);

            int rn = c.robotnum;
            String cmd = c.cmd;
            int num = c.num;

            int x = robots.get(rn).x;
            int y = robots.get(rn).y;
            String dir = robots.get(rn).dir;

            
            while(num > 0){
                System.out.println("로봇번호" +rn);
                System.out.println("명령 " +cmd);
                System.out.println("반복 횟수 " +num);
                System.out.println(robots.get(rn).x);
                System.out.println(robots.get(rn).y);
                System.out.println(robots.get(rn).dir);
                switch(cmd){

                    case "L" :
                        
                        if(dir.equals("N")){
                            robots.get(rn).dir = "W";
                            dir = "W";
                        }
                        else if(dir.equals("W")){
                            robots.get(rn).dir = "S";
                            dir = "S";
                        }
                        else if(dir.equals("S")){
                            robots.get(rn).dir = "E";
                            dir = "E";
                        }
                        else {
                            robots.get(rn).dir = "N";
                            dir = "N";
                        }
                        break;
                    
                    case "R" :
                        
                        if(dir.equals("N")){
                            robots.get(rn).dir = "E";
                            dir = "E";
                        }
                        else if(dir.equals("W")){
                            robots.get(rn).dir = "N";
                            dir = "N";
                        }
                        else if(dir.equals("S")){
                            robots.get(rn).dir = "W";
                            dir = "W";
                        }
                        else {
                            robots.get(rn).dir = "S";
                            dir = "S";
                        }
                        break;
                    
                    case "F" :
                        
                        if(dir.equals("N")){

                            if(y < B && map[y+1][x] != 0){
                                System.out.println("Robot " + (rn+1) +" crashes into robot " +map[y+1][x]);
                                return;
                            }
                            else if(y >= B){
                                System.out.println("Robot " +(rn+1) +" crashes into wall");
                                return;
                            }
                            map[y][x] = 0;
                            map[y+1][x] = rn+1;
                            robots.get(rn).y++;
                            y++;
                          
                        }
                        else if(dir.equals("S")){
                            if(y > 1 && map[y-1][x] != 0){
                                System.out.println("Robot " + (rn+1) +" crashes into robot " +map[y-1][x]);
                                return;
                            }
                            else if(y <= 1){
                                System.out.println("Robot " + (rn+1) +" crashes into wall");
                                return;
                            }
                            map[y][x] = 0;
                            map[y-1][x] = rn+1;
                            robots.get(rn).y--;
                            y--;
                           
                        }
                        else if(dir.equals("W")){
                            if(x <= 1){
                    
                                System.out.println("Robot " + (rn+1) +" crashes into wall");
                                return;
                                
                            }
                            else if(x > 1 && map[y][x-1] != 0){
                                System.out.println("Robot " + (rn+1) +" crashes into robot " +map[y][x-1]);
                                return;
                            }
                            map[y][x] = 0;
                            map[y][x-1] = rn+1;
                            robots.get(rn).x--;
                            x--;
                           
                        }
                        else if(dir.equals("E")){
                            if(x >= A){
                    
                                System.out.println("Robot " + (rn+1) +" crashes into wall");
                                return;
                                
                            }
                            else if(x < A && map[y][x+1] != 0){
                                System.out.println("Robot " + (rn+1) +" crashes into robot " +map[y][x+1]);
                                return;
                            }
                            map[y][x] = 0;
                            map[y][x+1] = rn+1;
                            robots.get(rn).x++;
                            x++;
                            
                        }  
                        break;
                }
                num--;
                
            }

        }
        System.out.println("OK");
    // }
        
    }
    static String direction(String dir){

        return "r";
    }

    public static class Command{
        int robotnum;
        String cmd;
        int num;

        Command(int robotnum, String cmd, int num){
            this.robotnum = robotnum - 1;
            this.cmd = cmd;
            this.num = num; 
        }
    }
    public static class Robot{
        int x;
        int y;
        String dir;

        Robot(int x, int y, String dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

}

