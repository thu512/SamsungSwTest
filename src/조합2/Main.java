package 조합2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[m];

        cnt = 0;
        dfs(0,m,0);
        System.out.println(cnt);
    }

    public static void dfs(int depth, int k, int target){
        if(k==0){
            cnt++;
            return;
        }

        if(target == n){
            return;
        }

        arr[depth] = target;

        dfs(depth+1,k-1,target+1);
        dfs(depth,k,target+1);
    }
}
