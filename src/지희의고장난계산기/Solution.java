package 지희의고장난계산기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    static ArrayList<Integer> num;
    static int res;
    static int N;
    static int n;
    static int[] indexArr;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            num = new ArrayList<>();

            String[] input = bf.readLine().split(" ");
            for (int i = 0; i < 10; i++) {
                if(Integer.parseInt(input[i]) == 1){
                    num.add(i);
                }
            }
            String in = bf.readLine();
            N = in.length();
            res = Integer.parseInt(in);


            n = num.size();
            indexArr = new int[N];

            dfs(0);
        }



    }

    public static void dfs(int depth){
        if(depth == N){
            for (int i = 0; i < N; i++) {
                System.out.print(" "+num.get(indexArr[i]));
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            indexArr[depth] = i;
            dfs(depth+1);
            indexArr[depth] = 0;
        }

    }
}
