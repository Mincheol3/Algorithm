import java.io.*;
import java.util.*;

public class BJ_배refac_1092 {
    
    static int N, M;
    static ArrayList<Integer> crane = new ArrayList<Integer>();
    static ArrayList<Integer> box = new ArrayList<Integer>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
       

        if(crane.get(0) < box.get(0)){
            System.out.println(-1);
            return;
        }
        int cnt = 0;
        int ans = 0;
        while(cnt < M){
            int pre = 0;
            for(int i = 0; i < N; i++){
                // 더이상 뒤에 박스가 없으면 브레이크
                if(pre == box.size()) break;
                else if(crane.get(i) >= box.get(pre)){
                    box.remove(pre);
                    // i++;
                    cnt++;
                }
                else {
                    //크레인은 그대로 박스는 더 가벼운 박스
                    i--;
                    pre++;
                }
            }
            ans++;
        }
        System.out.println(ans);
        
    }
}
