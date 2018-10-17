package 꽃길2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] priceMap;
    static int[][] checkMap;

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        priceMap = new int[n][n];
        checkMap = new int[n][n];


        String[] input;
        for (int i = 0; i < n; i++) {
            input = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                priceMap[i][j] = Integer.parseInt(input[j]);
            }
        }


        min = 999999999;

        int r1=0;
        int c1=0;
        int r2=0;
        int c2=0;
        int r3=0;
        int c3=0;

        for (int i = 0; i < n*n-2; i++) {
            r1 = i/n;
            c1 = i%n;
            if(dethFlow(r1,c1)){
                checkMap(r1,c1);
            }else{
                continue;
            }
            for (int j = i; j <n*n-1 ; j++) {
                r2 = j/n;
                c2 = j%n;
                if(dethFlow(r2,c2)){
                    checkMap(r2,c2);
                }else{
                    continue;
                }
                for (int k = j; k <n*n ; k++) {
                    r3 = k/n;
                    c3 = k%n;

                    //System.out.println(r1+"."+c1+" / "+r2+"."+c2+" / "+r3+"."+c3);
                    if(dethFlow(r3,c3)){
                        checkMap(r3,c3);
                        int price = 0;

                        for (int y = 0; y < n; y++) {
                            for (int x = 0; x < n; x++) {
                                if(checkMap[y][x]==1){
                                    price+= priceMap[y][x];
                                }
                            }
                        }
                        //돈계산
                        min = Math.min(min, price);
                    }else{
                        continue;
                    }
                    recoverMap(r3,c3);
                }
                recoverMap(r2,c2);
            }
            recoverMap(r1,c1);
        }



        System.out.println(min);

    }

    public static void checkMap(int r, int c){
        checkMap[r][c]=1;
        checkMap[r+1][c]=1;
        checkMap[r-1][c]=1;
        checkMap[r][c+1]=1;
        checkMap[r][c-1]=1;
    }

    public static void recoverMap(int r, int c){
        checkMap[r][c]=0;
        checkMap[r+1][c]=0;
        checkMap[r-1][c]=0;
        checkMap[r][c+1]=0;
        checkMap[r][c-1]=0;
    }

    public static boolean dethFlow(int r, int c){
        if(!(r-1 >=0 && r+1 <n && c-1>=0 && c+1<n)){
            return false;
        }
        if(checkMap[r][c] == 0 && checkMap[r+1][c] == 0 && checkMap[r-1][c] == 0 && checkMap[r][c+1] == 0 && checkMap[r][c-1] == 0){
            return true;
        }else{
            return false;
        }
    }
}
