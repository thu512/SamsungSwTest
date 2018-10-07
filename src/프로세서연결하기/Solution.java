package 프로세서연결하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    static int N;
    static int[][] map;
    static int[][] checkMap;
    static int[] checkArr;
    static int[] disArr;

    static ArrayList<Point> cpu;
    static int n;
    static int min;
    static int max;

    //하 상 우 좌
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
            checkMap = new int[N][N];
            cpu = new ArrayList<>();

            String[] input;
            for (int i = 0; i < N; i++) {
                input = bf.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    checkMap[i][j] = Integer.parseInt(input[j]);
                    if(map[i][j]==1){
                        if(i==0||j==0||i==N-1||j==N-1){
                            continue;
                        }
                        cpu.add(new Point(i,j));
                    }
                }
            }

            min = 999999999;
            max = 0;

            n = cpu.size();
            checkArr = new int[n];
            disArr = new int[n];


            dfs(0);

            //System.out.println("#"+test_case+" "+max);
            System.out.println("#"+test_case+" "+min);


        }
    }


    public static void dfs(int depth){
        if(depth == n){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    checkMap[i][j] = map[i][j];
                }
            }

            int len=0;
            int conCnt=0;
            for (int i = 0; i < n; i++) {
                Point p =cpu.get(i);
                if(checkLine(p.getR(), p.getC(),disArr[i])){
                    conCnt++;
                    len+=markLine(p.getR(), p.getC(),disArr[i]);
                    //System.out.println(i+" / "+len);
                }
            }

            if(conCnt > max){
//                System.out.println("\n"+conCnt);
//                for (int i = 0; i < n; i++) {
//                    System.out.print(" "+disArr[i]);
//                }
//                System.out.println("\n"+len);
                max = conCnt;
                min = 999999999;
                min = Math.min(min, len);
            }else if(conCnt == max){
//                System.out.println("\n"+conCnt);
//                for (int i = 0; i < n; i++) {
//                    System.out.print(" "+disArr[i]);
//                }
//                System.out.println("\n"+len);
                min = Math.min(min, len);
            }


            return;
        }

        for (int i = 0; i < 4; i++) {
            disArr[depth]=i;
            dfs(depth+1);
            disArr[depth]=0;
        }


    }


    public static int markLine(int r, int c, int d){
        int cnt = 0;
        if(d==0){
            for (int i = r+1; i < N; i++) {
                checkMap[i][c]=2;
                cnt++;
            }
        }else if(d==1){
            for (int i = r-1; i >=0; i--) {
                checkMap[i][c]=2;
                cnt++;
            }
        }else if(d==2){
            for (int i = c+1; i < N; i++) {
                checkMap[r][i]=2;
                cnt++;
            }
        }else if(d==3){
            for (int i = c-1; i >=0; i--) {
                checkMap[r][i]=2;
                cnt++;
            }
        }
        return cnt;
    }

    //0하 1상 2우 3좌
    public static boolean checkLine(int r, int c, int d){
        if(d==0){
            for (int i = r+1; i < N; i++) {
                if(checkMap[i][c]==1 || checkMap[i][c]==2){
                    return false;
                }
            }
        }else if(d==1){
            for (int i = r-1; i >=0; i--) {
                if(checkMap[i][c]==1 || checkMap[i][c]==2){
                    return false;
                }
            }
        }else if(d==2){
            for (int i = c+1; i < N; i++) {
                if(checkMap[r][i]==1 || checkMap[r][i]==2){
                    return false;
                }
            }
        }else if(d==3){
            for (int i = c-1; i >=0; i--) {
                if(checkMap[r][i]==1 || checkMap[r][i]==2){
                    return false;
                }
            }
        }

        return true;
    }
}
class Point{
    int r;
    int c;

    @Override
    public String toString() {
        return "Point{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}