package 스도쿠검증;


import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int[][] matrix = new int[9][9];

			for (int i = 0; i <9 ; i++) {
				for (int j = 0; j <9 ; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			int[] check;
			boolean flag=true;

			for (int i = 0; i < 9; i++) {
				flag = true;
				check = new int[10];
				for (int j = 0; j <9 ; j++) {
					if(check[matrix[i][j]]==0){
						check[matrix[i][j]]=1;
					}else{
						flag=false;
						break;
					}
				}
				if(!flag){
					break;
				}
			}

			if(!flag){
				System.out.println("#"+(test_case+1)+" 0");
				continue;
			}

			for (int i = 0; i < 9; i++) {
				flag = true;
				check = new int[10];
				for (int j = 0; j <9 ; j++) {
					if(check[matrix[j][i]]==0){
						check[matrix[j][i]]=1;
					}else{
						flag=false;
						break;
					}
				}
				if(!flag){
					break;
				}
			}

			if(!flag){
				System.out.println("#"+(test_case+1)+" 0");
				continue;
			}


			for (int k = 0; k <3 ; k++) {
				flag = true;
				check = new int[10];

				for (int i = k*3; i < k*3+3; i++) {
					for (int j = k*3; j <k*3+3 ; j++) {
						if(check[matrix[i][j]]==0){
							check[matrix[i][j]]=1;
						}else{
							flag=false;
							break;
						}
					}
					if(!flag){
						break;
					}
				}
				if(!flag){
					break;
				}
			}


			if(!flag){
				System.out.println("#"+(test_case+1)+" 0");
				continue;
			}

			System.out.println("#"+(test_case+1)+" 1");
			
		}
	}

}


