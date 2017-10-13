package String;


import java.util.*;

class Solution {
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int test_case = 0; test_case < 10; test_case++) {
			int x = sc.nextInt();
			sc.nextLine();
			String key = sc.nextLine();
			String msg = sc.nextLine();
			
			int n=key.length();
			int cnt=0;
			for(int i=0; i<=msg.length()-n; i++) {
				if(msg.substring(i, i+n).equals(key)) {
					cnt++;
				}
			}
			
			System.out.println("#"+(test_case+1)+" "+cnt);
			
		}
	}
	

	
}


