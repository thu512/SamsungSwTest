package 활주로건설;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution
{

    static int[][] map;
    static int N;
    static int L;

    public static void main(String args[]) throws Exception
    {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {

            String[] input;

            input = bf.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            L = Integer.parseInt(input[1]);


            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                input = bf.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }


            boolean[] checkArr = new boolean[N];

            boolean flag = true;
            int result = 0;
            //행 탐색
            for (int i = 0; i < N; i++) {
                initCheckArr(checkArr);
                flag = true;
                for (int j = 0; j < N-1; j++) {
                    if(map[i][j] != map[i][j+1]){
                        if((map[i][j]-1) == map[i][j+1] && checkDown(i,j,0,checkArr)){
                            for (int k = j+1; k <= j+L; k++) {
                                checkArr[k]=true;
                            }
                            j+=(L-1);
                        }else if((map[i][j]+1) == map[i][j+1] && checkUp(i,j,0,checkArr)){
                            for (int k = j; k > j-L; k--) {
                                checkArr[k]=true;
                            }
                        }else{
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag){
                    result++;
                }
            }
            //System.out.println(result);

            //열 탐색
            for (int i = 0; i < N; i++) {
                initCheckArr(checkArr);
                flag = true;
                for (int j = 0; j < N-1; j++) {
                    if(map[j][i] != map[j+1][i]){
                        if((map[j][i]-1) == map[j+1][i] && checkDown(j,i,1,checkArr)){
                            for (int k = j+1; k <= j+L; k++) {
                                checkArr[k]=true;
                            }
                            j+=(L-1);
                        }else if((map[j][i]+1) == map[j+1][i] && checkUp(j,i,1,checkArr)){
                            for (int k = j; k > j-L; k--) {
                                checkArr[k]=true;
                            }
                        }else{
                            //System.out.println("실퍠: "+i);
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag){
                    result++;
                }
            }

            System.out.println("#"+test_case+" "+result);

        }
    }

    //d: 0 -> 행 / 1 -> 열
    public static boolean checkDown(int r, int c, int d, boolean[] check){
        boolean result = true;

        if(d == 0){
            if((c+L) >= N){
                return false;
            }
            for (int i = c+1; i <= c+L ; i++) {

                if((map[r][c]-1) != map[r][i]){
                    return false;
                }
                if(check[i]){
                    return false;
                }
            }

        }else if(d == 1){
            if((r+L) >= N){
                return false;
            }
            for (int i = r+1; i <= r+L ; i++) {
                if((map[r][c]-1) != map[i][c]){
                    return false;
                }
                if(check[i]){
                    return false;
                }
            }
        }

        return result;
    }


    public static boolean checkUp(int r, int c, int d, boolean[] check){
        boolean result = true;

        if(d == 0){
            if((c-L+1) < 0){
                return false;
            }
            for (int i = c; i > c-L ; i--) {

                if(map[r][c] != map[r][i]){
                    return false;
                }
                if(check[i]){
                    return false;
                }
            }

        }else if(d == 1){
            if((r-L+1) < 0){
                return false;
            }
            for (int i = r; i > r-L ; i--) {
                if(map[r][c] != map[i][c]){
                    return false;
                }
                if(check[i]){
                    return false;
                }
            }
        }

        return result;
    }

    public static void initCheckArr(boolean[] check){
        for (int i = 0; i <check.length; i++) {
            check[i]=false;
        }
    }
}
