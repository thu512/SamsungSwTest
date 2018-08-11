package 최장증가부분수열;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 0; test_case < T; test_case++) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            int[] dp = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextInt();
            }

            dp[0]=1;

            for (int i = 1; i < n; i++) {
                dp[i]=1;

                for (int j = 0; j < i ; j++) {
                    if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                    }
                }
            }

            int max=0;

            for (int i = 0; i <n ; i++) {
                max=Math.max(max,dp[i]);
            }

            System.out.println("#"+(test_case+1)+" "+max);
        }
    }
}
