package NxM보드완주하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static char[][] map;

    static int[][] check;

    static int min;

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = 1;
        String input;
        while(true){
            input = bf.readLine();
            if(input == null){
                break;
            }

            N = Integer.parseInt(input.split(" ")[0]);
            M = Integer.parseInt(input.split(" ")[1]);
            map = new char[N][M];
            check = new int[N][M];

            for (int i = 0; i < N; i++) {
                map[i] = bf.readLine().toCharArray();
            }

            min = 999999999;


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    init();
                    if(map[i][j]!='*'){
                        check[i][j]=1;
                        dfs(i,j,0);
                        //check[i][j]=0;
                    }
                }
            }

            if(min==999999999){
                min = -1;
            }

            System.out.println("Case "+test_case+": "+min);

            test_case++;
        }
    }

    public static void dfs(int r, int c, int d){

        if(checkArr()){
            min = Math.min(min,d);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            int tr = r;
            int tc = c;
            while (true){

                tr+=dr[i];
                tc+=dc[i];
                if(tr>=0 && tr<N && tc>=0 && tc<M && check[tr][tc]==0){
                    check[tr][tc]=1;
                    cnt++;
                }else{
                    tr-=dr[i];
                    tc-=dc[i];
                    break;
                }

            }
            if(cnt>0){
                dfs(tr,tc,d+1);

                check[tr][tc]=0;
                for (int j = 0; j < cnt-1; j++) {

                    tr-=dr[i];
                    tc-=dc[i];
                    check[tr][tc]=0;
                }
            }

        }

    }

    public static boolean checkArr(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(check[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void init(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='*'){
                    check[i][j]=1;
                }else{
                    check[i][j]=0;
                }
            }
        }
    }
}
