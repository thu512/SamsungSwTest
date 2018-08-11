package 특별한소수;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {


		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {

			int d = sc.nextInt();
			int s = sc.nextInt();
			int e = sc.nextInt();
			int result =0;
			Boolean[] arry = new Boolean[e+1];
			ArrayList<Integer> res = new ArrayList<>();
			Arrays.fill(arry, false);
			arry[1]=true;
			for (int i = 2; i < arry.length; i++) {
				if(arry[i-1]==false){
					res.add(i-1);
				}
				if(arry[i]==true){
					continue;
				}
				for (int j = i+i; j <arry.length ; j+=i) {
					arry[j]=true;
				}
			}

			for (int i = 0; i <res.size() ; i++) {
				if(res.get(i)>=s && res.get(i)<=e && String.valueOf(res.get(i)).contains(String.valueOf(d))){

					result++;
				}
			}

			System.out.println("#" + (test_case + 1)+" "+result);

		}
	}

}


