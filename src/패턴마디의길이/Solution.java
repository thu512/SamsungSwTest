package 패턴마디의길이;


import java.util.*;

class Solution {
	
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int test_case = 0; test_case < T; test_case++) {
			String msg = sc.nextLine();
			int result=0;
			for(int i=1; i<msg.length()/2; i++) {
//				System.out.println(msg.substring(0, i));
//				System.out.println(msg.substring(i,i+i));
				
				if(msg.substring(0, i).equals(msg.substring(i+1,i+1+i))) {
					result=i;
					result++;
					break;
				}
			}
			
			System.out.println("#"+(test_case+1)+" "+result);
		}
	}
	
}


