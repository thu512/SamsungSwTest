package 적록색약;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	static int[][] map;


	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int N;

	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[N][N];
		char[][] map2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			String input = sc.nextLine();

			map[i]=input.toCharArray();
			map2[i]=input.toCharArray();

		}


		int result1 =0;
		Queue<Item> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!='X'){
					result1++;
					queue.add(new Item(i,j,map[i][j]));
					map[i][j]='X';
					while(!queue.isEmpty()){
						Item item = queue.poll();
						for (int k = 0; k < 4; k++) {
							int tr = item.getR()+dr[k];
							int tc = item.getC()+dc[k];
							if(tr>=0 && tr<N && tc>=0 && tc<N && map[tr][tc]==item.getColor()){
								queue.add(new Item(tr,tc,item.getColor()));
								map[tr][tc]='X';
							}
						}
					}
				}

			}
		}

		int result2 =0;
		queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map2[i][j]!='X'){
					result2++;
					queue.add(new Item(i,j,map2[i][j]));
					map2[i][j]='X';
					while(!queue.isEmpty()){
						Item item = queue.poll();
						for (int k = 0; k < 4; k++) {
							int tr = item.getR()+dr[k];
							int tc = item.getC()+dc[k];
							if(item.getColor() == 'R' || item.getColor() == 'G'){
								if(tr>=0 && tr<N && tc>=0 && tc<N && (map2[tr][tc]=='R'||map2[tr][tc]=='G')){
									queue.add(new Item(tr,tc,item.getColor()));
									map2[tr][tc]='X';
								}
							}else{
								if(tr>=0 && tr<N && tc>=0 && tc<N && map2[tr][tc]==item.getColor()){
									queue.add(new Item(tr,tc,item.getColor()));
									map2[tr][tc]='X';
								}
							}

						}
					}
				}

			}
		}


		System.out.println(result1+" "+result2);

	}
	
	static class Item{
		int r;
		int c;
		char color;

		public Item(int r, int c, char color) {
			this.r = r;
			this.c = c;
			this.color = color;
		}

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

		public char getColor() {
			return color;
		}

		public void setColor(char color) {
			this.color = color;
		}
	}
}


