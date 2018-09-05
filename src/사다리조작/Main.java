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




    }
    public static void dfs(int row, int cnt, int target){
        if(result != 999999999){
            return;
        }

        if(cnt == target){
            if(check()){
                result = cnt;
                return;
            }
        }

        for (int i = 1; i <= H; i++) {

        }



    }


    public static boolean check(){
        int cur = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            cur=i;
            for (int j = 0; j < H; j++) {
                if(map[cur][j]==1){
                    cur++;
                }else if(j>0 && map[cur][j-1]==1){
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
