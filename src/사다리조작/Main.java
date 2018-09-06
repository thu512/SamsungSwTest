package 사다리조작;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int H;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        map = new int[31][12];

        result = 999999999;

        for (int i = 0; i < M; i++) {
            input = bf.readLine().split(" ");
            map[Integer.parseInt(input[0])][Integer.parseInt(input[1])]=1;
        }

        for (int i = 0; i < 4; i++) {
            dfs(1, 0, i);
            if(result != 999999999){
                break;
            }
        }

        if(result == 999999999){
            result = -1;
        }

        System.out.println(result);

    }
    public static void dfs(int row, int cnt, int target){
        if(result != 999999999){
            return;
        }

        if(cnt == target){
            if(check()){
                result = cnt;
            }
            return;
        }

        for (int i = row; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if(map[i][j]!=1){
                    if(map[i][j-1]!=1 && map[i][j+1]!=1){
                        map[i][j]=1;
                        dfs(i,cnt+1,target);
                        map[i][j]=0;
                    }
                }
            }
        }

        return;

    }


    public static boolean check(){
        int cur = 0;
        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            cur=i;
            for (int j = 1; j <= H; j++) {
                if(map[j][cur]==1){
                    cur++;
                }else if(cur-1>0 && map[j][cur-1]==1){
                    cur--;
                }
            }
            if(cur==i){
                flag = true;
            }else{
                flag= false;
                break;
            }
        }

        return flag?true:false;
    }
}
