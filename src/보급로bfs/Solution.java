package 보급로bfs;


import java.util.LinkedList;
import java.util.Queue;
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

			bfs();

			System.out.println("#" + (test_case + 1) + " "+min);
			min=999999999;
		}
	}
	public static void bfs(){
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0,0));
		while(!queue.isEmpty()){
			Point p = queue.poll();

			if(p.r == N-1 && p.c==N-1){
				min=Math.min(min,p.val);
				continue;
			}

			for(int i=0; i<4; i++){
				int tr=p.r+dr[i];
				int tc=p.c+dc[i];
				if(tr>=0 && tr<N && tc>=0 && tc<N && p.val+map[tr][tc]<dp[tr][tc]){
					dp[tr][tc]=p.val+map[tr][tc];
					queue.add(new Point(tr,tc,p.val+map[tr][tc]));
				}
			}

		}
	}
}
class Point{
	int r;
	int c;
	int val;

	public Point(int r, int c, int val) {
		this.r = r;
		this.c = c;
		this.val = val;
	}
}

