package 테트로미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int R;
	static int C;
	static int[][] map;
	static int[][] check;
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	static int max;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = bf.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			input = bf.readLine().split(" ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		max = 0;
		check = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				fuck(i,j);
				check[i][j]=1;
				dfs(i,j,0,map[i][j]);
				check[i][j]=0;
				
			}
		}
		
		System.out.println(max);
		
	}
	public static void fuck(int r, int c) {
		
		int sum = map[r][c];
		
		//상 
		int tr = r+(-1);
		int tc = c+0;
		boolean flag = true;
		if(tr>=0 && tr < R && tc>=0 && tc < C) {
			sum+=map[tr][tc];
		}else {
			flag = false;
		}
		if(flag) {
			//대좌 
			tr = r+(-1);
			tc = c+(-1);
			boolean flag1 = true;
			if(tr>=0 && tr < R && tc>=0 && tc < C) {
				sum+=map[tr][tc];
			}else {
				flag1 = false;
			}
			if(flag1) {
				//대 
				tr = r+(-1);
				tc = c+(1);
				boolean flag2 = true;
				if(tr>=0 && tr < R && tc>=0 && tc < C) {
					sum+=map[tr][tc];
				}else {
					flag2 = false;
				}
				
				if(flag2) {
					max = Math.max(max, sum);
				}
			}
		}
		
		
		
		sum = map[r][c];
		
		//하  
		tr = r+(1);
		tc = c+0;
		flag = true;
		if(tr>=0 && tr < R && tc>=0 && tc < C) {
			sum+=map[tr][tc];
		}else {
			flag = false;
		}
		if(flag) {
			//대좌 
			tr = r+(1);
			tc = c+(-1);
			boolean flag1 = true;
			if(tr>=0 && tr < R && tc>=0 && tc < C) {
				sum+=map[tr][tc];
			}else {
				flag1 = false;
			}
			if(flag1) {
				//대 
				tr = r+(1);
				tc = c+(1);
				boolean flag2 = true;
				if(tr>=0 && tr < R && tc>=0 && tc < C) {
					sum+=map[tr][tc];
				}else {
					flag2 = false;
				}
				
				if(flag2) {
					max = Math.max(max, sum);
				}
			}
			
		}
		
		
		
		
		sum = map[r][c];
		
		//좌 
		tr = r+(0);
		tc = c+(-1);
		flag = true;
		if(tr>=0 && tr < R && tc>=0 && tc < C) {
			sum+=map[tr][tc];
		}else {
			flag = false;
		}
		if(flag) {
			//대좌 
			tr = r+(-1);
			tc = c+(-1);
			boolean flag1 = true;
			if(tr>=0 && tr < R && tc>=0 && tc < C) {
				sum+=map[tr][tc];
			}else {
				flag1 = false;
			}
			if(flag1) {
				//대 
				tr = r+(1);
				tc = c+(-1);
				boolean flag2 = true;
				if(tr>=0 && tr < R && tc>=0 && tc < C) {
					sum+=map[tr][tc];
				}else {
					flag2 = false;
				}
				
				if(flag2) {
					max = Math.max(max, sum);
				}
			}
			
		}
		
		
		sum = map[r][c];
		
		// 우 
		tr = r+(0);
		tc = c+(1);
		flag = true;
		if(tr>=0 && tr < R && tc>=0 && tc < C) {
			sum+=map[tr][tc];
		}else {
			flag = false;
		}
		
		if(flag) {
			//대좌 
			tr = r+(1);
			tc = c+(1);
			boolean flag1 = true;
			if(tr>=0 && tr < R && tc>=0 && tc < C) {
				sum+=map[tr][tc];
			}else {
				flag1 = false;
			}
			if(flag1) {
				//대 
				tr = r+(-1);
				tc = c+(1);
				boolean flag2 = true;
				if(tr>=0 && tr < R && tc>=0 && tc < C) {
					sum+=map[tr][tc];
				}else {
					flag2 = false;
				}
				
				if(flag2) {
					max = Math.max(max, sum);
				}
			}
			
		}
		
		
	}
	
	
	public static void dfs(int r, int c, int depth, int sum) {
		
		
		if(depth == 3) {
//			for(int i = 0; i<R; i++) {
//				for(int j = 0; j<C; j++) {
//					System.out.print(" "+check[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("\n\n");
			
			max = Math.max(max, sum);
			return;
		}
		
		
		for(int i=0; i<4; i++) {
			int tr = r+dr[i];
			int tc = c+dc[i];
			
			if(tr>=0 && tr < R && tc>=0 && tc < C && check[tr][tc]==0) {
				check[tr][tc]=1;
				dfs(tr,tc,depth+1,sum+map[tr][tc]);
				check[tr][tc]=0;
			}
		}
		
	}

}
