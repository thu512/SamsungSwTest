package 회문1;


import java.util.Scanner;

class Solution {
	static int result=0;
	static char[][] msg;
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int test_case = 0; test_case < 10; test_case++) {
			int n = sc.nextInt();
			sc.nextLine();
			msg=new char[8][8];
			for(int i=0; i<8; i++) {
				String tmp=sc.nextLine();
				msg[i]=tmp.toCharArray();
				
			}
			
			
			
			for(int i=0; i<8; i++) {
				int j=0;
				while(j+n<=8) {
					if(palen(i, j,j+n-1, 1)) {
						j++;
						result++;
					}else {
						j++;
					}
				}
				
				
				j=0;
				while(j+n<=8) {
					if(palen(i, j,j+n-1, 0)) {
						j++;
						result++;
					}else {
						j++;
					}
				}
			}
			
			System.out.println("#"+(test_case+1)+" "+result);
			result=0;
		}
	}
	
	//mod �� 1�̸� ���ι��� �˻� / 0�̸� ���ι��� �˻�
	public static boolean palen(int r, int s, int e, int mod) {
		boolean result=true;
		if(mod==1) {
			for(int i=s; i<=(s+e)/2; i++) {
				if(msg[r][i]!=msg[r][(s+e)-i]) {
					result=false;
				}
			}
			
		}else {
			
			for(int i=s; i<=(s+e)/2; i++) {
				if(msg[i][r]!=msg[(s+e)-i][r]) {
					result=false;
				}
			}
			
		}
		
		
		
		return result;
	}
	
}


