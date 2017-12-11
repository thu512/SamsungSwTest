package Ladder2;


import java.util.Scanner;

class Solution {

	//오, 아, 왼, 위
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int[][] map;

	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);

		
		for(int test_case = 0; test_case < 10; test_case++) {
			int N = sc.nextInt();
			
			map = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j]=sc.nextInt();
				}
			}

			int min=999999999;
			int index=0;
			for (int i = 0; i < 100; i++) {
				int a_r=0;
				int a_c=i;
				if(map[a_r][a_c]==0){
					continue;
				}
				//오, 아, 왼, 위
				int d=1;
				int result=0;
				int cnt=0;
				while(true){

					cnt++;
					int R_tr=a_r+dr[0];
					int R_tc=a_c+dc[0];

					int L_tr=a_r+dr[2];
					int L_tc=a_c+dc[2];

					int D_tr=a_r+dr[1];
					int D_tc=a_c+dc[1];

					if(D_tr==100){

						break;
					}

					//진행방향 위쪽
					if(d==1){
						//오른쪽으로 길이 있을때
						if(R_tc<100 && map[R_tr][R_tc]==1){
							d=0;
							a_r=R_tr;
							a_c=R_tc;

						}
						//왼쪽으로 길이 있을때
						else if(L_tc>-1 && map[L_tr][L_tc]==1){
							d=2;
							a_r=L_tr;
							a_c=L_tc;
						}else{
							a_r=D_tr;
							a_c=D_tc;
						}
						continue;
					}
					//진행방향 왼쪽
					if(d==2){
						if(map[D_tr][D_tc]==1){
							d=1;
							a_r=D_tr;
							a_c=D_tc;
						}else{
							a_r=L_tr;
							a_c=L_tc;
						}
						continue;
					}
					//진행방향 오른쪽
					if(d==0){
						if(map[D_tr][D_tc]==1){
							d=1;
							a_r=D_tr;
							a_c=D_tc;
						}else{
							a_r=R_tr;
							a_c=R_tc;
						}
						continue;
					}


				}

				//System.out.println(i+": "+cnt);
				if(min>cnt){
					min=cnt;
					index=i;
				}

				if(min==cnt){
					index = Math.max(index,i);
				}
			}




			

			System.out.println("#"+(test_case+1)+" "+index);
			
		}
	}
	

	
}


