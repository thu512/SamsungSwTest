package 디저트카페;


import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int N= sc.nextInt();
			int[][] map=new int[N][N];
			int[] visit = new int[101];
			int result=0;
			
			clearArr(visit);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int a=1; a<N; a++) {
						for(int b=1; b<N; b++) {
							
							if(j+a<N && i+a+b < N  && j-b>=0 && (a+b)*2 >result) {
								clearArr(visit);
								boolean isAble = true;
								int curi = i;
								int curj=j;
								
								for(int n=0; n<a; n++) {
									curi++;
									curj++;
									if(visit[map[curi][curj]]!=1) {
										visit[map[curi][curj]]=1;
									}else {
										isAble=false;
										break;
									}
									
								}
								if(!isAble) {
									continue;
								}
								
								for(int n=0; n<b; n++) {
									curi++;
									curj--;
									if(visit[map[curi][curj]]!=1) {
										visit[map[curi][curj]]=1;
									}else {
										isAble=false;
										break;
									}
									
								}
								if(!isAble) {
									continue;
								}
								
								for(int n=0; n<a; n++) {
									curi--;
									curj--;
									if(visit[map[curi][curj]]!=1) {
										visit[map[curi][curj]]=1;
									}else {
										isAble=false;
										break;
									}
									
								}
								if(!isAble) {
									continue;
								}
								
								for(int n=0; n<b; n++) {
									curi--;
									curj++;
									if(visit[map[curi][curj]]!=1) {
										visit[map[curi][curj]]=1;
									}else {
										isAble=false;
										break;
									}
									
								}
								if(!isAble) {
									continue;
								}
								
								result = (a+b)*2;
								
							}
						}
					}
				}
			}
			if(result == 0) {
				result = -1;
			}
			System.out.println("#"+(test_case+1)+" "+result);
			
		}
	}
	
	public static void clearArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i]=0;
		}
	}
}


