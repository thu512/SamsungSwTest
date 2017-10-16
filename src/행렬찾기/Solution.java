package 행렬찾기;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Solution {


	static int n;
	static int[][] arr;
	static int max_r;
	static int max_c;
	static int max;
	//하,상,좌,우
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {
			n=sc.nextInt();

			arr= new int[n+1][n+1];
			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					arr[i][j]=sc.nextInt();
				}
			}

			ArrayList<sq> s = new ArrayList<>();

			for(int i=1; i<=n; i++){
				for(int j=1; j<=n; j++){
					if(arr[i][j]!=0){
						dfs(i,j);
						s.add(new sq(max_r-i+1,max_c-j+1,(max_r-i+1)*(max_c-j+1)));
						max_r=0;
						max_c=0;
					}

				}
			}

			Collections.sort(s, new Comparator<sq>() {
				@Override public int compare(sq o1, sq o2) {
					if(o1.getSize()<o2.getSize()){
						return -1;
					}else if(o1.getSize()>o2.getSize()){
						return 1;
					}else{
						if(o1.getR()<o2.getR()){
							return -1;
						}else if(o1.getR()>o2.getR()){
							return 1;
						}else{
							return 0;
						}
					}
				}
			});

			System.out.print("#"+(test_case+1)+" "+s.size()+" ");
			for(int i=0; i<s.size(); i++){
				System.out.print(s.get(i).getR()+" "+s.get(i).getC()+" ");
			}
			System.out.println("");

		}
	}

	public static void dfs(int r, int c){


		for(int i=0; i<4; i++){
			int td=r+dr[i];
			int tc=c+dc[i];

			if(td>0 && td<=n && tc>0 && tc<=n && arr[td][tc]!=0){
				arr[td][tc]=0;
				max_r=Math.max(max_r,td);
				max_c=Math.max(max_c,tc);
				dfs(td,tc);
			}
		}
		return;
	}

}
class sq{
	int r;
	int c;
	int size;

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public sq(int r, int c, int size) {
		this.r = r;
		this.c = c;
		this.size = size;
	}
}

