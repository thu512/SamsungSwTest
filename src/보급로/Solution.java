package 보급로;


import java.util.Scanner;

class Solution {


	static int N;
	static int[][] map;
	static int[][] visit;
	static int min=999999999;
	static int[] dr={1,-1,0,0};
	static int[] dc={0,0,1,-1};
	static int[][] dp;
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {

			N= sc.nextInt();
			sc.nextLine();

			map=new int[N][N];
			visit=new int[N][N];
			dp=new int[N][N];

			String input="";
			for(int i=0; i<N; i++){
				input=sc.nextLine();

				for(int j=0; j<N; j++){
					map[i][j]=Integer.parseInt(Character.toString(input.charAt(j)));
					dp[i][j]=999999999;
				}
			}
			visit[0][0]=1;
			dfs(0,0,0);

			System.out.println("#" + (test_case + 1) + " "+min);
			min=999999999;
		}
	}
	public static void dfs(int r, int c, int sum){
		if(r==N-1 && c==N-1){
			min=Math.min(min,sum);
			return;
		}

		for(int i=0; i<4; i++){
			int tr=r+dr[i];
			int tc=c+dc[i];

			if(tr>=0 && tr<N && tc>=0 && tc<N && visit[tr][tc]!=1 && (sum+map[tr][tc])<dp[tr][tc] &&(sum+map[tr][tc])<min){
				visit[tr][tc]=1;
				dp[tr][tc]=sum+map[tr][tc];
				dfs(tr,tc,sum+map[tr][tc]);
				visit[tr][tc]=0;
			}
		}
		return;

	}
}


