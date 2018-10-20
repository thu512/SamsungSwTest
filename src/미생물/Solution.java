package 미생물;


import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	//(��: 1, ��: 2, ��: 3, ��: 4)
	//                  ��    ��   ��   ��
	static int[] dr= {0,-1, 1, 0, 0};
	static int[] dc= {0, 0, 0,-1, 1};
	
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int K=sc.nextInt();
			ArrayList<Group> mis= new ArrayList<>();
			ArrayList<Group> equal= new ArrayList<>();
			
			for(int i=0; i<K; i++) {
				int r=sc.nextInt();
				int c=sc.nextInt();
				int num=sc.nextInt();
				int dir=sc.nextInt(); //(��: 1, ��: 2, ��: 3, ��: 4)
				
				mis.add(new Group(r,c,num,dir));
			}
			
			for(int i=0; i<M; i++) {
				
				for(int j=0; j<K; j++) {
					int r=mis.get(j).getR();
					int c=mis.get(j).getC();
					int num=mis.get(j).getNum();
					int dir=mis.get(j).getDir();
					
					if(r+dr[dir] > 0 && r+dr[dir]<N-1 && c+dc[dir]>0 && c+dc[dir]<N-1) {
						mis.get(j).setR(r+dr[dir]);
						mis.get(j).setC(c+dc[dir]);
					}else {
						if(num/2 ==0) {
							mis.remove(j);
							K--;
							j--;
						}else {
							mis.get(j).setR(r+dr[dir]);
							mis.get(j).setC(c+dc[dir]);
							if(dir%2==0) {
								mis.get(j).setDir(dir-1);
							}else {
								mis.get(j).setDir(dir+1);
							}
							
							mis.get(j).setNum(num/2);
						}
						
					}
				}
//				System.out.println("---------------------------");
//				for(int u=0; u<mis.size(); u++) {
//					System.out.println(mis.get(u).getR()+" / "+mis.get(u).getC()+" / "+mis.get(u).getNum()+" / "+mis.get(u).getDir());
//				}
				
				for(int x=0; x<K-1; x++) {
					equal.add(mis.get(x));
					for(int y=x+1; y<K; y++) {
						if((mis.get(x).getR()==mis.get(y).getR()) && (mis.get(x).getC()==mis.get(y).getC())) {
							equal.add(mis.get(y));
							mis.remove(y);
							y--;
							K--;
						}
					}
					if(equal.size()==1) {
						equal.clear();
					}else {
						
//						System.out.println("===========================");
//						for(int u=0; u<equal.size(); u++) {
//							System.out.println(equal.get(u).getR()+" / "+equal.get(u).getC()+" / "+equal.get(u).getNum()+" / "+equal.get(u).getDir());
//						}
						 mis.remove(x);
						x--;
						int max=0;
						int index=0;
						for(int t=0; t< equal.size(); t++) {
							if(max<equal.get(t).getNum()) {
								max=equal.get(t).getNum();
								index=t;
							}
						}
						int sum=0;
						for(int t=0; t< equal.size(); t++) {
							
							sum+=equal.get(t).getNum();
						}
						equal.get(index).setNum(sum);
						mis.add(equal.get(index));
						
					}
					equal.clear();
				}
//				System.out.println("---------------------------");
//				for(int u=0; u<mis.size(); u++) {
//					System.out.println(mis.get(u).getR()+" / "+mis.get(u).getC()+" / "+mis.get(u).getNum()+" / "+mis.get(u).getDir());
//				}
				
			}
			int result=0;
			for(int i=0; i<mis.size(); i++) {
				result+=mis.get(i).getNum();
			}
			System.out.println("#"+(test_case+1)+" "+result);
			
		}
	}
}
class Group{
	int R;
	int C;
	int num;
	int dir;
	public Group(int r, int c, int num, int dir) {
		super();
		R = r;
		C = c;
		this.num = num;
		this.dir = dir;
	}
	public int getR() {
		return R;
	}
	public void setR(int r) {
		R = r;
	}
	public int getC() {
		return C;
	}
	public void setC(int c) {
		C = c;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	
}


