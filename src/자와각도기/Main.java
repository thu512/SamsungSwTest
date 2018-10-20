package 자와각도기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int K;

    static int[] arr;
    static int dig;

    static boolean ok;

    static ArrayList<Integer> check;

    public static void main(String[] args) throws  Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        arr = new int[N];
        s = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        s = bf.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            dig = Integer.parseInt(s[i]);
            ok=false;
            check = new ArrayList<>();
            dfs(0);
            if(ok==false){
                System.out.println("NO");
            }
        }
    }

    public static void dfs(int result){
        //System.out.println(check.toString());
        if(result == dig){
            System.out.println("YES");
            ok=true;
            return;
        }

        if(ok){
            return;
        }
        for (int i = 0; i < N; i++) {
            int tResult = result-arr[i];
            if(tResult<0){
                tResult = 360 - tResult;
            }
            if(!check.contains(tResult)){
                check.add(tResult);
                dfs(tResult);
                //check.remove(new Integer(tResult));
            }
            tResult = result+arr[i];
            if(tResult>360){
                tResult = tResult-360;
            }
            if(tResult>=0 && tResult<=360 && !check.contains(tResult)){
                check.add(tResult);
                dfs(tResult);
                //check.remove(new Integer(tResult));
            }
        }
    }
}
