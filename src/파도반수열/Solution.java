package 파도반수열;


import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[101];
		dp[0]=0;
		dp[1]=1;
		dp[2]=1;


		for (int i = 3; i <=100 ; i++) {
			dp[i]=dp[i-3]+dp[i-2];
		}

		for(int test_case = 0; test_case < T; test_case++) {
			int n = sc.nextInt();



			System.out.println("#"+(test_case+1)+" "+dp[n]);

		}
	}

}

