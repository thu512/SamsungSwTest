package 로봇청소기;


import java.util.Scanner;
class Solution {
	
	static int N;
	static int M;
	static int cnt=0;
	static int[][] map;
	static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new int[N][M];
		
		int r=sc.nextInt(); 
		int c=sc.nextInt();
		int d=sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		while(true) {
			if(map[r][c] == 0) {
				map[r][c]=2;
				cnt++;
			}
			
			boolean ret=false;
			for(int i=0; i<4; i++) {
				int td=(d-1+4)%4;
				int tr=r+dRow[td];
				int tc=c+dCol[td];
				
				if(map[tr][tc]==0) {
					r=tr;
					c=tc;
					d=td;
					ret=true;
					break;
				}else {
					d=td;
				}
			}
			if(!ret) {
				if(map[r-dRow[d]][c-dCol[d]]==1) {
					System.out.println(cnt);
					break;
				}else {
					r=r-dRow[d];
					c=c-dCol[d];
				}
			}
		}
		
		
	}
	
	
	
}


