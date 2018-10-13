package 보호필름2;


import java.util.Scanner;

class Solution {
    static int[][] arr;
    static int[][] temp;
    static int D; //두께
    static int W; //가로
    static int K; //심사기준

    static int min;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            arr = new int[D][W];
            temp = new int[D][W];
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < W; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int result = 0;
            init();
            if(check()){
                System.out.println("#" + (test_case + 1) + " " + result);
                continue;
            }

            min = 999999999;

            dfs(-1,0);

            System.out.println("#" + (test_case + 1) + " " + min);

        }
    }
    public static void print(int val){
        System.out.println(" ");
        System.out.println(val+"=============================");

        for(int i=0; i<D; i++){
            for(int j=0; j<W; j++){
                System.out.print(temp[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("=============================");
        System.out.println(" ");
    }
    public static void dfs(int depth, int val){
        if(check()){
            //print(val);
            min= Math.min(min,val);
            return;
        }

        if(depth==D-1){
            return;
        }


        for (int i = 0; i < 3; i++) {
            if(i==0){
                dfs(depth+1,val);
            }else{
                change(depth+1, i);
                dfs(depth+1, val+1);
                recover(depth+1);
            }
        }
        
    }


    public static void change(int r, int n){
        for (int i = 0; i < W; i++) {
            temp[r][i]=n-1;
        }
    }
    public static void recover(int r){
        for (int i = 0; i < W; i++) {
            temp[r][i]=arr[r][i];
        }
    }



    public static void init(){
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < W; j++) {
                temp[i][j]=arr[i][j];
            }
        }
    }

    public static boolean check(){
        for (int i = 0; i < W; i++) {
            int m = temp[0][i];
            int cnt=1;
            boolean flag = false;
            for (int j = 1; j < D; j++) {
                if(m==temp[j][i]){
                    cnt++;
                }else{
                    m=temp[j][i];
                    cnt=1;
                }
                if(cnt==K){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
}


