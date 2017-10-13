package Sum;


import java.util.*;

class Solution {
	
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int test_case = 0; test_case < 10; test_case++) {
			int n = sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			
			long max=0;
			int tmp1=0;
			int tmp2=0;
			for(int i=0; i<100; i++) {
				tmp1=0;
				tmp2=0;
				for(int j=0; j<100; j++) {
					tmp1+=arr[i][j];
					tmp2+=arr[j][i];
				}
				max=Math.max(tmp1, max);
				max=Math.max(tmp2, max);	
			}
			
			tmp1=0;
			tmp2=0;
			for(int i=0; i<100; i++) {
				tmp1+=arr[i][i];
				tmp2+=arr[i][99-i];
			}
			
			max=Math.max(tmp1, max);
			max=Math.max(tmp2, max);	
			
			System.out.println("#"+(test_case+1)+" "+(max));
			
		}
	}
	

	
}


