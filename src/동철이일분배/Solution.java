package 동철이일분배;


import java.util.Scanner;

class Solution {
	static double[][] work;
	static int n;
	static int[] check;
	static double max=0;
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			n=sc.nextInt();
			check = new int[n];
			work = new double[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					work[i][j]=sc.nextDouble();
				}	
			}
			
			for(int i=0; i<n; i++) {
				check[i]=1;
				dfs(0, work[0][i]);
				check[i]=0;
			}
			
			
			System.out.printf("#%d %.6f\n",test_case,(max/(Math.pow(100, n)))*100);
			max=0;
		}
	}
	
	public static void dfs(int r,  double val) {

		if(r==n-1) {
			max=Math.max(max,val);
			return;
		}

		for(int i=0; i<n; i++) {
			if(check[i]!=1) {
				if(r==n-2 && max>=val*work[r+1][i]) {
					return;
				}
				if(work[r+1][i]==0) {
					return;
				}

				check[i]=1;
				dfs(r+1,val*work[r+1][i]);
				check[i]=0;
			}
		}
		return;
	}


}


