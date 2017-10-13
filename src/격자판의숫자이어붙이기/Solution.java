package 격자판의숫자이어붙이기;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
	static int[][] map;

	
	 //��, ��, ��, ��
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static ArrayList<String> arr;
	static char[] ch;
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			
			
			map = new int[4][4];
			arr=new ArrayList<>();
			ch=new char[7];
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					ch[0]=String.valueOf(map[i][j]).charAt(0);
					
					dfs(i,j,1);
					
				}
			}
			HashSet hs = new HashSet(arr);
			System.out.println("#"+(test_case+1)+" "+hs.size());
			
		}
	}
	
	public static void dfs(int r, int c, int d) {

		if(d==7) {

			arr.add(String.valueOf(ch));
			return;
		}
		
		for(int i=0; i<4; i++) {
			int tr=r+dr[i];
			int tc=c+dc[i];
			if((tr >= 0) && (tr < 4) && (tc >= 0) && (tc < 4)){
				
				ch[d]=String.valueOf(map[tr][tc]).charAt(0);
				dfs(tr,tc,d+1);
			}
		}
		return;
	}
	
	
}


