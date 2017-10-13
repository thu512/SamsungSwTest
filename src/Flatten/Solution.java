package Flatten;


import java.util.*;

class Solution {
	static int[] arr;
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int test_case = 0; test_case < 10; test_case++) {
			int n = sc.nextInt();
			arr = new int[100];
			
			for(int i=0; i<100; i++) {
				arr[i]=sc.nextInt();
			}
			
			
			long result=0;
			
			for(int i=0; i<n; i++) {
				dump();
			}
			Arrays.sort(arr);
			System.out.println("#"+(test_case+1)+" "+(arr[99]-arr[0]));
			
		}
	}
	

	public static void dump() {
		
		Arrays.sort(arr);
		arr[99]--;
		arr[0]++;
	}
}


