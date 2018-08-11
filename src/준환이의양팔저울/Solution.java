package 준환이의양팔저울;

import java.util.Scanner;

public class Solution {
    static int[] arr0;
    static int[] fact_arr = {1,1,2,6,24,120,720,5040,40320,362880};
    static int cnt=0;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            int n = sc.nextInt();
            arr0 = new int[n];
            for (int i = 0; i < n; i++) {
                arr0[i]=sc.nextInt();
            }
            //cnt=fact_arr[n];
            int[] arr = new int[n];
            for (int i = 0; i <= n; i++) {
                combine(arr,0,n,i,0);
            }


            System.out.println("#" + (test_case + 1) + " "+cnt);
            cnt=0;
        }
    }

    public static void combine(int[] arr, int index, int n, int r, int target) {
        if (r == 0) {
            print(arr,index);
            int[] check = new int[n];
            int one_cnt=0;
            for (int i = 0; i < index; i++) {
                check[arr[i]]=1;
                one_cnt++;
            }

            for (int i = 0; i <n ; i++) {
                System.out.print(check[i]+" ");
            }
            System.out.println("");
            int sum_L=0;
            int sum_R=0;

            for (int i = 0; i < n; i++) {
                if(check[i]==1){
                    sum_L+=arr0[i];
                }else{
                    sum_R+=arr0[i];
                }
            }
            System.out.println("R: "+sum_R+" L: "+sum_L);
            if(sum_L > sum_R){
                cnt+=fact_arr[one_cnt];
                if(one_cnt == 0 || one_cnt==n){
                    cnt+=fact_arr[n-r];
                }
                System.out.println("cnt: "+cnt);
            }

        } else if (target == n) {
            return;
        } else {
            arr[index] = target;
            combine(arr, index + 1, n, r - 1, target + 1);
            combine(arr, index, n, r, target + 1);

        }
    }

    public static void print(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

}
