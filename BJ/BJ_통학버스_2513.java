import java.util.*;
import java.io.*;

public class BJ_통학버스_2513 {

    static int N, K, S, ans;
    static ArrayList<apart> left = new ArrayList<apart>();
    static ArrayList<apart> right = new ArrayList<apart>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        //학교기준 오른쪽과 왼쪽을 나눠서 저장
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(x < S){
                left.add(new apart(x, n));
            }
            else if(x > S){
                right.add(new apart(x, n));
            }
        }
        // 학교와 거리가 먼 순서로 정렬
        Collections.sort(left, (e1, e2) -> {
            return e1.x - e2.x;
        });

        Collections.sort(right, (e1,e2) -> {
            return e2.x-e1.x;
        });
        // 현재까지의 합계
        int sum = 0;
        // 제일 먼 곳의 x 좌표
        int num = 0;
        while(left.size() > 0){
            num =left.get(0).x;
            for(int i = 0; i < left.size(); i++){
                if(sum+left.get(i).n <= K){
                    sum += left.get(i).n;
                    left.remove(i); 
                    i--;
                }
                else{
                    left.get(i).n -= K - sum;
                    break; 
                }
                if(sum >= K) break;
            }
          
            ans += (S -num)*2;
            sum =0;
        
        }
       
        while(right.size() > 0){
            num =right.get(0).x;
            for(int i = 0; i < right.size(); i++){
                if(sum+right.get(i).n <= K){
                    sum += right.get(i).n;
                    right.remove(i);
                    i--;
                }
                else{
                    right.get(i).n -= K - sum;
                    break; 
                }
                if(sum >= K) break;
            }
            
            ans += (num - S)*2;
            sum = 0;
        }
        
        System.out.println(ans);
    }
    static class apart{

        int x;
        int n;

        apart(int x, int n){

            this.x = x;
            this.n = n;
        }
    }
}
