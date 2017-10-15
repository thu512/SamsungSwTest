package 디저트카페2;


import java.util.Scanner;

class Solution {
	static int[] visit = new int[101];
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];



			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					map[i][j]=sc.nextInt();
				}
			}

			int result=0;

			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){

				    //1부터 가야함 직사각형 길이기 때문에 0일수 없다.
					for(int a=1; a<=N; a++){
						for(int b=1; b<=N; b++){



							if(j-b>=0 && j+a<N && i+a+b<N && (a+b)*2 >result){
								int td=i;
								int tc=j;
								clear();
								boolean flag=true;

								//우측 아래 방향 탐색
								for(int x=0; x<a; x++){
									td++;
									tc++;
									if(visit[map[td][tc]]!=1){
										visit[map[td][tc]]=1;
									}else{
										//이미 먹은 디저트이므로 탐색 중지
										flag=false;
										break;
									}
								}

								if(!flag){
									continue;
								}

								//좌측 아래방향 탐색
								for(int x=0; x<b; x++){
									td++;
									tc--;

									if(visit[map[td][tc]]!=1){
										visit[map[td][tc]]=1;
									}else{
										flag=false;
										break;
									}
								}

								if(!flag){
									continue;
								}


								//좌측 윗방향 탐색
								for(int x=0; x<a; x++){
									td--;
									tc--;

									if(visit[map[td][tc]]!=1){
										visit[map[td][tc]]=1;
									}else{
										flag=false;
										break;
									}
								}


								if(!flag){
									continue;
								}


								//우측 윗방향 탐색
								for(int x=0; x<b; x++){
									td--;
									tc++;

									if(visit[map[td][tc]]!=1){
										visit[map[td][tc]]=1;
									}else{
										flag=false;
										break;
									}

								}

								if(!flag){
									continue;
								}



								//직사각형 탐색이 다됬으므로 result값 갱신

								result = (a+b)*2;


							}

						}
					}
				}
			}

			if(result==0){
			    result=-1;
            }
			System.out.println("#"+(test_case+1)+" "+result);
			
		}
	}

	public static void clear(){
		for(int i=0; i<101; i++){
			visit[i]=0;
		}
		return;
	}

}


