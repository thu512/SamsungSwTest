package 농작물수확하기;


import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int n=sc.nextInt();
			sc.nextLine();
			
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				String num=sc.nextLine();
				for(int j=0; j<n; j++) {
					arr[i][j]=Integer.parseInt(String.valueOf(num.charAt(j)));
					
				}
				
			}
			
			int sum=0;
			int x=n/2;
			
			for(int i=0; i<=x; i++) {
				for(int j=x-i; j<=x+i; j++) {
					sum+=arr[i][j];
					
				}
			}
			for(int i=x+1; i<n; i++) {
				for(int j=x-(n-1-i); j<=x+(n-1-i); j++) {
					sum+=arr[i][j];
					
				}
			}
			
			
			System.out.println("#"+(test_case+1)+" "+sum);
			
		}
	}

}


