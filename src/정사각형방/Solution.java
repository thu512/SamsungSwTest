package 정사각형방;


import java.util.Scanner;

class Solution {
	static int[][] map;

	
	 //��, ��, ��, ��
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int N;
	
	static int dir=0;
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			N=sc.nextInt();
			
			map = new int[N][N];
			
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			int max_d=0;
			int max_p=N*N;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dfs(i,j,1);
					if(max_d<dir) {
						max_d=dir;
						max_p=map[i][j];
					}
					if(max_d==dir) {
						if(max_p>map[i][j]) {
							max_p=map[i][j];
						}
					}
					dir=0;
				}
			}
			
			System.out.println("#"+(test_case+1)+" "+max_p+" "+max_d);
			
		}
	}
	
	public static void dfs(int r, int c, int d) {
		
		
		
		dir=d;
		
		//System.out.println("i: "+r+" / j:"+c+" / d:"+d);
		for(int i=0; i<4; i++) {
			int tr=r+dr[i];
			int tc=c+dc[i];
			int cur=map[r][c];
			
			if((tr >= 0) && (tr < N) && (tc >= 0) && (tc < N) && cur+1==map[tr][tc]){
				dfs(tr,tc,d+1);
			}
		}
		return;
	}
	
	
}


