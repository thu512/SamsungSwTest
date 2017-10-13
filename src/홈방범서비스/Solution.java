package 홈방범서비스;


import java.util.Scanner;

class Solution {
	static int[][] map;
	static int[] K;
	static int M;
	static int N;
	
	public static void main(String args[]) throws Exception	{
		K=new int[22];
		K[1]=1;
		for(int i=1; i<22; i++) {
			K[i]=K[i-1] + 4*(i-1);
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			N=sc.nextInt();
			M = sc.nextInt();
			int max=0;
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int k=1; k<=N+1; k++) {
						int cnt=search(i,j,k);
						if(cnt > max) {
							max=cnt;
						}
					}
				}	
			}
				
			System.out.println("#"+(test_case+1)+" "+max);
			
		}
			
	}
	public static int search(int r, int c, int k) {
		int cnt=0;
		
		int h=2*k -1;
		int x=h/2;
		int t=0;
		for(int i=r-x; i<=r; i++) {
			
			for(int j=c-t; j<=c+t; j++) {
				if(isRange(i,j)&&map[i][j]==1) {
					cnt++;
				}
			}
			t++;
		}
		
		t=x-1;
		for(int i=r+1; i<=r+x; i++) {
			
			for(int j=c-t; j<=c+t; j++) {
				if(isRange(i,j)&&map[i][j]==1) {						
					cnt++;
				}
			
			}
			t--;
		}
//		if(k==2) {
//			System.out.println("cnt: "+cnt+"cnt*M: "+cnt*M+" / K: "+K[k]+" k="+k);
//				
//		}
		if((cnt*M)-K[k] > 0 ) {
			//System.out.println("i: "+r+" / j: "+c+" / cnt: "+cnt);
			
			return cnt;
		}
		return 0;
		
		
	}
	
	public static boolean isRange(int i,int j) {
		return (i>=0 && i<N && j>=0 && j<N);
	}

}


