package 요리사;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution
{

    static int n;
    static int[] indexArr;
    static int[] check;
    static int min;
    static int[][] arr;

    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T=Integer.parseInt(bf.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(bf.readLine());

            arr = new int[n][n];

            String[] input;
            for (int i = 0; i < n; i++) {
                input = bf.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            min = 999999999;

            check = new int[n];
            indexArr = new int[n];

            for (int i = 0; i < n; i++) {
                check[i]=1;
                indexArr[0]=i;
                dfs(1);
                check[i]=0;
            }

            System.out.println(min);
        }
    }

    public static void dfs(int depth){
        if(depth == n){
//              System.out.println("s1: "+(arr[indexArr[0]][indexArr[1]]+arr[indexArr[1]][indexArr[0]]));
//              System.out.println("s2: "+(arr[indexArr[2]][indexArr[3]]+arr[indexArr[3]][indexArr[2]]));

            int s1 = 0;
            for (int i = 0; i < n/2; i+=n/2) {
                s1 += (arr[indexArr[i]][indexArr[i+1]]+arr[indexArr[i+1]][indexArr[i]]);
            }

            int s2 = 0;
            for (int i = n/2; i < n; i+=n/2) {
                s2 += (arr[indexArr[i]][indexArr[i+1]]+arr[indexArr[i+1]][indexArr[i]]);
            }



            //min = Math.min(min, result);
            for (int i = 0; i < n; i++) {
                System.out.print(" "+indexArr[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if(check[i]==0){
                check[i]=1;
                indexArr[depth]=i;
                dfs(depth+1);
                check[i]=0;
            }
        }

    }
}
