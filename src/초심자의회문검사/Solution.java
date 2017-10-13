package 초심자의회문검사;


import java.util.Scanner;

class Solution {
	


	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int test_case = 0; test_case < T; test_case++) {
			StringBuilder sb = new StringBuilder(sc.nextLine());

			int result=0;
			System.out.println(sb.toString());
			System.out.println(sb.reverse().toString());
			if(sb.toString().equals(sb.reverse().toString())){
				result=1;
			}
			System.out.println("#"+(test_case+1)+" "+result);
		}
	}
}


