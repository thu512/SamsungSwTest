package 뱀;


import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	
	static int[] dr={-1, 0 , 1, 0};
	static int[] dc={0, 1 , 0, -1};


	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];

		int K=sc.nextInt();

		for(int i=0; i<K; i++){
			int r=sc.nextInt();
			int c=sc.nextInt();
			map[r-1][c-1]=2;
		}

		int l=sc.nextInt();
		ArrayList<Point> p = new ArrayList<>();
		for(int i=0; i<l; i++){
			int t=sc.nextInt();
			char d=sc.next().charAt(0);
			p.add(new Point(t+1,d));
			//System.out.println(p.toString());
		}

		//초기화
		loc head = new loc(0,0,3);
		loc tail = new loc(0,0,3);
		map[0][0]=3; //뱀 초기위치
		int dir=1; //뱀의 진행 방향
		//방향 위:0 / 오:1 / 아:2 / 왼:3

		int time=0;
		while(true){

			//1. 조건 체크 (머리가 몸이랑 만났는지(map에서 1인 부분), map초과)
			//2. 조건 맞을시 현재 time 찍고 종료
			//3. 조건 안맞을시 사과 있는지(2)? 체크
			//4. 사과있으면 통과
			//5. 없으면 꼬리좌표 0으로 변경후 꼬리좌표 줄임

			time++;
			for(int i=0; i<p.size(); i++){
				if(time==p.get(i).t){
					if(p.get(i).d=='L'){
						if(dir==0){
							dir=3;
						}else if(dir==1){
							dir=0;
						}else if(dir==2){
							dir=1;
						}else{
							dir=2;
						}
					}else{
						if(dir==0){
							dir=1;
						}else if(dir==1){
							dir=2;
						}else if(dir==2){
							dir=3;
						}else{
							dir=0;
						}
					}
					p.remove(i);
					break;
				}
			}
			int tr=head.r+dr[dir];
			int tc=head.c+dc[dir];
			//System.out.println(tr+" / "+tc);
			if((!(tr>=0 && tr<N && tc>=0 && tc<N)) || (map[tr][tc]!=0 && map[tr][tc]!=2)){
				break;
			}

			if(map[tr][tc]==2){
				head.r=tr;
				head.c=tc;
				head.val++;
				map[tr][tc]=head.val;

			}else{
				head.r=tr;
				head.c=tc;
				head.val++;
				map[tr][tc]=head.val;
				map[tail.r][tail.c]=0;
				for(int i=0; i<4; i++){
					int r=tail.r+dr[i];
					int c=tail.c+dc[i];
					if(r>=0 && r<N && c>=0 && c<N && map[r][c]==tail.val+1){
						tail.r=r;
						tail.c=c;
						tail.val++;
						break;
					}
				}

			}
			//System.out.println("=====================");
			//for(int i=0; i<N; i++){
			//	for(int j=0; j<N; j++){
			//		System.out.print(map[i][j]+" ");
			//	}
			//	System.out.println("");
			//}
			//System.out.println("==============================");
		}
		System.out.println((time));
	}
}
class loc{
	int r;
	int c;
	int val;
	public loc(int r, int c,int val) {
		this.r = r;
		this.c = c;
	}
}

class Point{
	int t;
	char d;

	@Override public String toString() {
		return "Point{" +
				"t=" + t +
				", d=" + d +
				'}';
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public char getD() {
		return d;
	}

	public void setD(char d) {
		this.d = d;
	}

	public Point(int t, char d) {

		this.t = t;
		this.d = d;
	}
}

