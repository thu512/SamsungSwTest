package View;


import java.util.Scanner;

class Solution {
	static int result=0;
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int test_case = 0; test_case < 10; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i]=sc.nextInt();
			}
			long result=0;
			for(int i=2; i<n-2; i++) {
				int l_max=Math.max(arr[i-2],arr[i-1]);
				int r_max=Math.max(arr[i+2],arr[i+1]);
				int max=Math.max(l_max, r_max);
				if(arr[i]>max) {
					result+=arr[i]-max;
				}
				
			}
			
			System.out.println("#"+(test_case+1)+" "+result);
			
		}
	}
	

	
}


