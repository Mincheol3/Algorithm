import java.io.*;
import java.util.*;
public class BJ_거짓말_1043 {
    static int N, M, answer;
    static boolean truth[];
    static int[] parent;
    static ArrayList<int[]> list = new ArrayList<int[]>();
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i = 1; i <= N ;i++){
            parent[i] = i;
        }
        truth = new boolean[N+1];
        
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            truth[Integer.parseInt(st.nextToken())]= true;
        }
        ArrayList<int[]> list = new ArrayList<int[]>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] arr = new int[size];
            for(int j = 0; j < size; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < size-1; j++){
                if(truth[find(arr[j])]) truth[find(arr[j+1])] = true;
                else if(truth[find(arr[j+1])]) truth[find(arr[j])] = true;
                if(find(arr[j]) != arr[j+1]) union(arr[j], arr[j+1]);
            }
            list.add(arr);
        }
        for(int i = 0; i < M; i++){
            boolean flag = true;
            for(int j = 0; j < list.get(i).length; j++){
                if(truth[find(list.get(i)[j])]) {
                    flag =false;
                    break;
                }
            }
            if(flag) answer++;

        }
        
        System.out.println(answer);
        

    }
    static void union(int x, int y){
         int fx = find(x);
         int fy = find(y);
        
         if(fx <= fy) parent[fy] = fx;
         else parent[fx] =fy;
         
    }
    static int find(int x){
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }
}
