package 거듭제곱;


import java.util.Scanner;

class Solution {
	static int N=0;
	static int M=0;
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int test_case = 0; test_case < 10; test_case++) {
			int x = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.println("#"+(test_case+1)+" "+mul(N,1));
		}
	}
	public static int mul(int m, int n) {
		if(n==M) {
			return m;
		}else {
			return mul(m*N,n+1);
		}
	}
}


