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
			check = new int[n+1];
			work = new double[n+1][n+1];
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					work[i][j]=sc.nextDouble();
				}	
			}
			

			dfs(0);

			
			
			System.out.printf("#%d %.6f\n",test_case,(max/(Math.pow(100, n)))*100);
			max=0;
		}
	}
	
	public static void dfs(int r) {

		if(promising(r)){
			if(r==n) {
				int sum=1;
				for(int i=1; i<=n; i++){
					sum*=work[i][check[i]];
				}
				max=Math.max(max,sum);
			}else{
				for(int i=1; i<=n; i++){
					check[r+1]=i;
					dfs(r+1);

				}
			}
		}


		return;
	}

	public static boolean promising(int i){
		boolean s=true;
		int k=0;
		while(k<i && s){
			if(check[k]==check[i]){
				s=false;
			}
			k++;
		}
		return s;
	}
}


