package K번째접미어;


import java.util.Arrays;
import java.util.Scanner;

class Solution {


	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {
			int K= sc.nextInt();
			sc.nextLine();
			String txt = sc.nextLine();

			String[] arr = new String[txt.length()];

			for(int i=0; i<txt.length(); i++){
				arr[i]=txt.substring(i,txt.length());
			}
            Arrays.sort(arr);
			System.out.println("#"+(test_case+1)+" "+arr[K-1]);
		}
	}
}