package 하나로;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Solution {




	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {

			for(int i=0; i<(1<<5); i++){
				for(int j=0; j<5; j++){
					if((i&(1<<j))!=0){
						System.out.print(j);
					}

				}
				System.out.println("");
			}

			System.out.println("#" + (test_case + 1) + " ");
		}
	}

}


