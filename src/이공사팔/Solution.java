package 이공사팔;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N;
	static int[][] map;
	static int[] indexArr;
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		
		String[] input;
		for(int i = 0; i < N; i++) {
			input = bf.readLine().split(" ");
			for(int j = 0 ; j<N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		max = 0;
		indexArr = new int[5];
		dfs(0);
		
		System.out.println(max);
	}
	
	//0:상 / 1:하 / 2:좌 / 3:우 
	public static void dfs(int depth) {
		if(depth == 5) {
			int[][] tmp = new int[N][N];
			
			for(int i =0; i<N; i++) {
				tmp[i] = map[i].clone();
			}
//			for(int i =0; i<N; i++) {
//				for(int j = 0; j<N; j++) {
//					System.out.print(" "+tmp[i][j]);
//				}
//				System.out.println();
//			}
			System.out.println("\n\n");
			System.out.println(Arrays.toString(indexArr));
			int m = 0;
			for(int i = 0; i<5; i++) {
				int d = indexArr[i];
				
				switch(d) {
				case 0:
					
						for(int c = 0; c < N; c++) {
							for(int r = 0; r<N-1; r++) {
								if(tmp[r+1][c] == 0) {
									for(int k=r+1; k<N; k++) {
										if(tmp[k][c]!=0) {
											if((tmp[r][c] == tmp[k][c])) {
												tmp[r][c]+=tmp[k][c];
												tmp[k][c] = 0;
											}
											
											
											break;
										}
									}
								
								}else {
									if((tmp[r][c]!=0 || tmp[r+1][c]!=0)&&(tmp[r][c] == tmp[r+1][c])) {
										tmp[r][c]+=tmp[r+1][c];
										tmp[r+1][c] = 0;
										
									}
								}
								
							}
						}
						for(int c = 0; c < N; c++) {
							for(int r = 0; r<N-1; r++) {
								if(tmp[r][c] == 0) {
									for(int k=r+1; k<N; k++) {
										if(tmp[k][c]!=0) {
											tmp[r][c] = tmp[k][c];
											tmp[k][c]=0;
											break;
										}
									}
								
								}
							}
						}
						
					
					
					break;
				case 1:
					
						for(int c = 0; c < N; c++) {
							for(int r = N-1; r>=1; r--) {
								if(tmp[r-1][c] == 0) {
									for(int k=r-1; k>=0; k--) {
										if(tmp[k][c]!=0 ) {
											if((tmp[r][c] == tmp[k][c])) {
												tmp[r][c] += tmp[k][c];
												tmp[k][c]=0;
											}
											
											break;
										}
									}
								
								}else {
									if((tmp[r][c]!=0 || tmp[r-1][c]!=0)&&(tmp[r][c] == tmp[r-1][c])) {
										tmp[r][c]+=tmp[r-1][c];
										tmp[r-1][c] = 0;
										
									}
								}
								
							}
						}
						for(int c = 0; c < N; c++) {
							for(int r = N-1; r>=1; r--) {
								if(tmp[r][c] == 0) {
									for(int k=r-1; k>=0; k--) {
										if(tmp[k][c]!=0) {
											tmp[r][c] = tmp[k][c];
											tmp[k][c]=0;
											break;
										}
									}
								
								}
							}
						}
						
					
					break;
				case 2:
					
					
						
						for(int r = 0; r < N; r++) {
							for(int c = 0; c < N-1; c++) {
								if(tmp[r][c+1] == 0) {
									for(int k = c+1; k < N; k++) {
										if(tmp[r][k]!=0 ) {
											if((tmp[r][c] == tmp[r][k])) {
												tmp[r][c] += tmp[r][k];
												tmp[r][k]=0;
											}
											
											break;
										}
									}
								}else {
									if((tmp[r][c]!=0 || tmp[r][c+1]!=0)&&(tmp[r][c] == tmp[r][c+1])) {
										tmp[r][c] += tmp[r][c+1];
										tmp[r][c+1] = 0;
										
									}
								}
								
								
							}
						}
						
						for(int r = 0; r < N; r++) {
							for(int c = 0; c < N-1; c++) {
								if(tmp[r][c] == 0) {
									for(int k = c+1; k < N; k++) {
										if(tmp[r][k]!=0) {
											tmp[r][c] = tmp[r][k];
											tmp[r][k]=0;
											break;
										}
									}
								}
							}
						}
						
					
					break;
				case 3:
					
					
						
						for(int r = 0; r < N; r++) {
							for(int c = N-1; c >= 1; c--) {
								if(tmp[r][c-1] == 0) {
									for(int k = c-1; k >= 0; k--) {
										if(tmp[r][k]!=0) {
											if((tmp[r][c] == tmp[r][k])) {
												tmp[r][c] += tmp[r][k];
												tmp[r][k]=0;
											}
											
											break;
										}
									}
								}else {
									if((tmp[r][c]!=0 || tmp[r][c-1]!=0)&&(tmp[r][c] == tmp[r][c-1])) {
										tmp[r][c] += tmp[r][c-1];
										tmp[r][c-1] = 0;
										
									}
								}
								
								
							}
						}
						
						for(int r = 0; r < N; r++) {
							for(int c = N-1; c >=1; c--) {
								if(tmp[r][c] == 0) {
									for(int k = c-1; k >= 0; k--) {
										if(tmp[r][k]!=0) {
											tmp[r][c] = tmp[r][k];
											tmp[r][k]=0;
											break;
										}
									}
								}
							}
						}
						
					break;
					
				}
				
				if(indexArr[0]==3 && indexArr[1]==0 &&indexArr[2]==3 && indexArr[3]==0) {
					for(int x = 0; x< N; x++) {
						for(int j = 0; j< N; j++) {
							//m = Math.max(m, tmp[x][j]);
							System.out.print(" "+tmp[x][j]);
						}
						System.out.println();
					}
					System.out.println("\n\n");
				}
				
				
			}
			
			
			for(int x = 0; x< N; x++) {
				for(int j = 0; j< N; j++) {
					m = Math.max(m, tmp[x][j]);
					//System.out.print(" "+tmp[x][j]);
				}
				//System.out.println();
			}
			//System.out.println("\n\n");
			
			max = Math.max(max, m);
			return;
		}
		
		
		for(int i =0; i<4; i++) {
			indexArr[depth]=i;
			dfs(depth + 1);
			indexArr[depth]=0;
		}
	}

}
//10
//16 16 8 32 32 0 0 8 8 8
//16 0 0 0 0 8 0 0 0 16
//0 0 0 0 0 0 0 0 0 2
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
