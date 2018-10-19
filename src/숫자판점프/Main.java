package 숫자판점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static String[][] map;
    static ArrayList<String> check;
    static int res;
    static String str;

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        map = new String[5][5];
        for (int i = 0; i < 5; i++) {
            map[i]=bf.readLine().split(" ");
        }
        check = new ArrayList<>();
        res = 0;


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                str = map[i][j];
                dfs(i,j,0);
            }
        }

        System.out.println(res);
    }

    public static void dfs(int r, int c, int depth){

        if(depth == 5){
            if(!check.contains(str)){
                //System.out.println(str);
                check.add(str);
                res++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tr = r+dr[i];
            int tc = c+dc[i];

            if(tr>=0 && tr<5 && tc>=0 && tc<5){
                str+=map[tr][tc];
                dfs(tr,tc,depth+1);
                str=str.substring(0,str.length()-1);
            }
        }
    }
}
