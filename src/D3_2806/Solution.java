package D3_2806;

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	static int Answer;
	static int n;
	static int[] col;
	static int result=0;
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			n = sc.nextInt();
			col=new int[n+1];
			col[0]=0;
			queen(0);
			
	
			System.out.println("#"+(test_case+1)+" "+result);
			result=0;
		}
	}
	public static void queen(int i) {
		if(promising(i)) {
			if(i==n) {
				result++;
			}else {
				for(int j=1; j<=n; j++) {
					col[i+1]=j;
					queen(i+1);
				}
			}
		}
	}
	
	public static boolean promising(int i) {
		boolean s = true;
		int k = 1;
		while(k<i && s) {
			if(col[i]==col[k] || (Math.abs(col[i]-col[k]) == i-k)) {
				s=false;
			}
			k++;
		}
		return s;
	}
}


