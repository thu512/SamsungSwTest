package 퇴사;


import java.util.*;

class Solution {
	
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] t = new int[N+1];
		int[] p = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			t[i]=sc.nextInt();
			p[i]=sc.nextInt();
			dp[i]=p[i];
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<i; j++) {
				if(i-j >= t[j]) {
					dp[i]=Math.max(p[i]+dp[j], dp[i]);
				}
				
			}
		}
		int max=0;
		for(int i=1; i<=N; i++) {
			if(i+t[i]<=N+1) {
				if(max<dp[i]) {
					max=dp[i];
				}
			}
		}
		System.out.println(max);
		
	}
	
}


