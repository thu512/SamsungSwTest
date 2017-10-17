package 째로탈출;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	
	static char[][] map;
	static int[][] visitB;
	static int[][] visitR;
	static int N,M;
	static int R_r;
	static int R_c;
	static int B_r;
	static int B_c;

	static int O_r;
	static int O_c;


	//하,상,우,좌
	static int[] dr={1,-1,0,0};
	static int[] dc={0,0,1,-1};

	static boolean result;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map=new char[N][M];
		visitR=new int[N][M];
		visitB=new int[N][M];

		for(int i=0; i<N; i++){
			String line = sc.nextLine();
			for(int j=0; j<M; j++){
				map[i][j]=line.charAt(j);
				if(map[i][j]=='R'){
					R_r=i;
					R_c=j;
				}else if(map[i][j]=='B'){
					B_r=i;
					B_c=j;
				}else if(map[i][j]=='O'){
					O_r=i;
					O_c=j;
				}
			}
		}
		result = false;

		bfs();


		System.out.println(result?1:0);

	}

	public static void bfs(){
		Queue<Ball> queue = new LinkedList<>();
		queue.add(new Ball(R_r,R_c,B_r,B_c,0));

		while(!queue.isEmpty()){
			Ball cur=queue.poll();
			visitR[cur.r_r][cur.r_c]=1;
			visitB[cur.b_r][cur.b_c]=1;

			if(cur.cnt>10){
				continue;
			}

			//System.out.println("br: "+cur.b_r+" bc: "+cur.b_c+" rr: "+cur.r_r+" rc: "+cur.r_c+" cnt: "+cur.cnt);
			for(int i=0; i<4; i++){
				int btr=cur.b_r;
				int btc=cur.b_c;
				int rtr=cur.r_r;
				int rtc=cur.r_c;
				boolean b=false;
				boolean r=false;

				for(int x=0; x<2; x++){
					while(true){
						if(map[btr+dr[i]][btc+dc[i]]=='#' || (btr+dr[i]==rtr&&btc+dc[i]==rtc)){
							break;
						}else{
							btr+=dr[i];
							btc+=dc[i];
						}
						//System.out.println("br: "+btr+" bc: "+btc);
						if(map[btr][btc]=='O'){
							//System.out.println("br: "+btr+" bc: "+btc+"체크");
							b=true;
						}
					}

					while(true){
						if(map[rtr+dr[i]][rtc+dc[i]]=='#' || (rtr+dr[i]==btr && rtc+dc[i]==btc)){
							break;
						}else{
							rtr+=dr[i];
							rtc+=dc[i];
						}
						//System.out.println(" rr: "+rtr+" rc: "+rtc);
						if(map[rtr][rtc]=='O'){
							//System.out.println(" rr: "+rtr+" rc: "+rtc+"체크");
							r=true;
						}
					}
				}
				if(b&&r){
					result=false;
					return;
				}
				if(!b && r){
					result=true;
					return;
				}


				if(btr==cur.b_r && btc==cur.b_c && rtr==cur.r_r && rtc==cur.r_c){
					continue;
				}
				//if(visitB[btr][btc]!=1 && visitR[rtr][rtc]!=1){
					queue.add(new Ball(rtr,rtc,btr,btc,cur.cnt+1));
				//}

			}


		}

	}
}


class Ball{
	int r_r;
	int r_c;
	int b_r;
	int b_c;
	int dir;
	int cnt;

	public Ball(int r_r, int r_c, int b_r, int b_c, int cnt) {
		this.r_r = r_r;
		this.r_c = r_c;
		this.b_r = b_r;
		this.b_c = b_c;
		this.cnt = cnt;
	}
}