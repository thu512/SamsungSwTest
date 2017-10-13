package 파리퇴치;


import java.util.Scanner;

class Solution {
	
	static int[][] map;
	static int N;
	static int M;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {

			N=sc.nextInt();
			M=sc.nextInt();

			map = new int[N][N];
			int max=0;

			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					map[i][j]=sc.nextInt();
				}
			}
			for(int i=0; i<=N-M; i++){
				for(int j=0; j<=N-M; j++){
					max=Math.max(max,count(i,j));
				}
			}
			System.out.println("#"+(test_case+1)+" "+max);
		}
	}
	public static int count(int r, int c){
		int sum=0;
		for(int i=r; i<r+M; i++){
			for(int j=c; j<c+M; j++){
				sum+=map[i][j];
			}
		}
		return sum;
	}
}


