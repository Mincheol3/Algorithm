import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_개똥벌레_3020 {
    
    static int N, H, ans;
    static int[] Arr1, Arr2;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Arr1 = new int[N/2];
        Arr2 = new int[N/2];

        for(int i = 0; i < N / 2; i++){
            Arr1[i] = Integer.parseInt(br.readLine());
            Arr2[i] = Integer.parseInt(br.readLine());
        }
        int[] result = new int[H+1];
        int low = 1;
        int high = H;
        int min = 200000000;

        while(low <= high){
           int h = (low+high)/2;
            int cnt = 0;
            for(int i = 0 ; i < N/2; i++){

                if(h <= Arr1[i]) cnt++;
                if(h > H - Arr2[i]) cnt++;

            }

            min = Math.min(cnt, min);
            high = h -1;
        }
        // int ans = 0;
        //  low = 1;
        //  high = H;
        // while(low <= high){
        //     int h = (low+high)/2;
        //      int cnt = 0;
        //      for(int i = 0 ; i < N/2; i++){
 
        //          if(h <= Arr1[i]) cnt++;
        //          if(h > H - Arr2[i]) cnt++;
 
        //      }
        //      if(cnt == min) ans ++;
        //      high = h -1;
        //  }
        //  low = 1;
        //  high = H;
        // while(low <= high){
        //     int h = (low+high)/2;
        //      int cnt = 0;
        //      for(int i = 0 ; i < N/2; i++){
 
        //          if(h <= Arr1[i]) cnt++;
        //          if(h > H - Arr2[i]) cnt++;
 
        //      }
        //      if(cnt == min) ans ++;
        //      low = h +1;
        //  }
        //  min = (H)/2 == min ? min -1 : min;
        System.out.println(min + " " + ans);
    }
}
