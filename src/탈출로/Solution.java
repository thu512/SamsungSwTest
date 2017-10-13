package 탈출로;


import java.util.*;

class Solution {
	
	//�� �� �� ��
	static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {1, 0, -1, 0};
    //
    static int[][] type= {
    		{0,0,0,0},
    		{1,1,1,1},
    		{0,1,0,1},
    		{1,0,1,0},
    		{1,0,0,1},
    		{1,1,0,0},
    		{0,1,1,0},
    		{0,0,1,1}
    };
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int R=sc.nextInt();
			int C=sc.nextInt();
			int L=sc.nextInt();
			int[][] map = new int[N][M];
			int[][] visit = new int[N][M];
			int[][][] board = new int[N][M][4];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j]=sc.nextInt();
					board[i][j]=type[map[i][j]];
				}
			}
			Queue<Point> queue = new LinkedList<>();
			Point c = new Point(R,C,1);
			visit[R][C]=1;
			int cnt=1;
			queue.add(c);
			while(!queue.isEmpty()) {
				Point p=queue.poll();
				for(int i=0; i<4; i++) {
					int tr=p.r+dRow[i];
					int tc=p.c+dCol[i];
					int tt=p.t+1;
					int oop_d = (i-2+4)%4;
					if(tr>=0 && tr<N && tc>=0 && tc<M && visit[tr][tc]!=1 && tt<=L && board[p.r][p.c][i]==1 && board[tr][tc][oop_d]==1) {
						cnt++;
						visit[tr][tc]=1;
						//System.out.println("tr: "+tr+" / tc: "+tc);
						queue.add(new Point(tr,tc,tt));
						
					}
				}
			}
			
			System.out.println("#"+(test_case+1)+" "+cnt);
		}
	}
	
}

class Point{
	int r;
	int c;
	int t;
	public Point(int r, int c, int t) {
		this.r=r;
		this.c=c;
		this.t=t;
		
	}
	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + ", t=" + t + "]";
	}
	
}
