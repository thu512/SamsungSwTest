package 달란트2;


import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int dal = sc.nextInt();
			int group = sc.nextInt();

			int mok=dal/group;

			long result=1;

			if(mok*group < dal){
				int na= dal%group;

				for (int i = 0; i <na ; i++) {
					result*=(mok+1);
				}
				for (int i = 0; i <group-na ; i++) {
					result*=mok;
				}
			}else{
				for (int i = 0; i <group ; i++) {
					result*=mok;
				}
			}
			
			System.out.println("#"+(test_case+1)+" "+result);
			
		}
	}

}


