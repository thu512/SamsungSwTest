package 부분수열의합;


import java.util.Scanner;
import java.util.Stack;

class Solution {

	static int[] arr;
	static Stack<Integer> st;
	static int k;
	static int result=0;

	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int n=sc.nextInt();
			k=sc.nextInt();
			arr= new int[n];
			st = new Stack<>();

			for(int i=0; i<n; i++){
				arr[i]=sc.nextInt();
			}

			for(int i=0; i<(1<<n); i++){
				int sum=0;
				for(int j=0; j<n; j++){
					if((i&(1<<j))!=0){
						//System.out.print(arr[j]);
						sum+=arr[j];
					}
					if(sum>k){
						break;
					}
				}
				if(sum==k){
					result++;
				}
				//System.out.println("");
			}

			System.out.println("#"+(test_case+1)+" "+result);
			result=0;
		}
	}

}


