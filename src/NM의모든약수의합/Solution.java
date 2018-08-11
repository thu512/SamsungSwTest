package NM의모든약수의합;


import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {


        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int result=0;
            for (int i = 0; i <= m; i++) {
                if(result>=1000000007){
                    result/=1000000007;
                }
                result+=Math.pow(n,i);
            }

            System.out.println("#" + (test_case + 1)+" "+result);

        }
    }

}


