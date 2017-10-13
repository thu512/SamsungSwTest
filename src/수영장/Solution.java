package 수영장;


import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int sum=0;
			int day = sc.nextInt();
			int month = sc.nextInt();
			int three = sc.nextInt();
			int year = sc.nextInt();
			int[] plan = new int[13];
			int[] money = new int[13];
			
			for(int i=1; i<=12; i++) {
				plan[i]=sc.nextInt();
			}
			
			for(int i=1; i<=12; i++) {
				money[i]=Math.min(money[i-1]+plan[i]*day, money[i-1]+month);
				if(i>=3) {
					money[i]=Math.min(money[i-3]+three, money[i]);
				}
			}
			if(money[12]>year) {
				System.out.println("#"+(test_case+1)+" "+year);
			}else {
				System.out.println("#"+(test_case+1)+" "+money[12]);
			}
				
		}
	}
	
}


