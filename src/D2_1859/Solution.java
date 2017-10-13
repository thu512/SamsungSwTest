package D2_1859;


import java.util.Scanner;

class Solution {
	static int result=0;
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				arr[i]=sc.nextInt();
			}
			long max=arr[n];
			boolean max_changed=false;
			long cnt=0;
			long total=0;
			long result=0;
			boolean flag=false;
			for(int i=n-1; i>0; i--) {
				if(max<=arr[i]) {
					if(i==1) {
						flag=true;
						break;
					}
					result+= max*cnt - (total);
					max=arr[i];
					
					total=0;
					cnt=0;
				}else {
					max_changed=true;
					total+=arr[i];
					cnt++;
				}
			}
			if(flag&&!max_changed) {
				result=0;
			}else {
				result+= (max*cnt) - (total);
			}
			
			
			
			
			System.out.println("#"+(test_case+1)+" "+result);
			
		}
	}
	

	
}


