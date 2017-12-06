package 부분수열의합2;


import java.util.Scanner;

class Solution {

	static int[] arr;
	static int[] check;
	static int[] value;

	static int N;
	static  int k;

	static int result=0;


	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			N=sc.nextInt();
			k=sc.nextInt();
			check = new int[N];
			arr = new int[N];
			value = new int[N];

			for(int i=0; i<N; i++){
				value[i]=sc.nextInt();
			}

			for(int i=0; i<N; i++){
				check[i]=1;
				arr[0]=i;
				dfs(1);
				check[i]=0;
			}


			System.out.println("#"+(test_case+1)+" "+result);
			result=0;
		}
	}


	public static void dfs(int depth) {
		int sum=0;
		for (int i = 0; i < N; i++) {
			if(check[i]==1){
				sum+=value[i];
			}
		}

		if(sum>k){
			return;
		}

		if (depth == N) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
			if(sum==k){
				result++;
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(check[i]==0){
				check[i]=1;
				arr[depth]=i;
				dfs(depth+1);
				check[i]=0;
			}
		}

		return;

	}
}


