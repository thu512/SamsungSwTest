package 등산로조성;


import java.util.Scanner;

class Solution {
	static int[][] map;
	static int[][] check;
	
	 //��, ��, ��, ��
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int N;
	static int K;
	static int highest;
	static int max=0;
	static boolean fix=false;
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			N=sc.nextInt();
			K=sc.nextInt();
			map = new int[N][N];
			check = new int[N][N];
			highest=0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(highest < map[i][j]) {
						highest=map[i][j];
					}
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(highest==map[i][j]) {
						fix=false;
						check[i][j]=1;
						//System.out.println("--------------------------------");
						dfs(i,j,1,highest);
						check[i][j]=0;
					}
					
				}
			}
			
			System.out.println("#"+(test_case+1)+" "+max);
			max=0;
		}
	}
	
	public static void dfs(int r, int c, int d,int h) {
		
		
		if(max<=d) {
			max=d;
		}
		//System.out.println("i: "+r+" / j:"+c+" / d:"+d);
		for(int i=0; i<4; i++) {
			int tr=r+dr[i];
			int tc=c+dc[i];
			
			if ((tr >= 0) && (tr < N) && (tc >= 0) && (tc < N) && (check[tr][tc] != 1)) {
				if(h > map[tr][tc]) {
					
					check[tr][tc] = 1;
					dfs(tr,tc,d+1,map[tr][tc]);
					check[tr][tc] = 0;
					
					
				}else {
					if(!fix && (h> (map[tr][tc]-K))) {
						
						check[tr][tc] = 1;
						fix=true;
						dfs(tr,tc,d+1,h-1);
						check[tr][tc] = 0;
						fix=false;
					}
				}
			}
		}
		return;
	}
	
	
}


