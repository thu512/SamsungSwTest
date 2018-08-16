package 최적경로2;


import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	static int[] arr;
	static int[] check;

	static ArrayList<Point> c;
    static int n;
    static int min = 999999999;
    public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {
			n = sc.nextInt()+2;
			arr=new int[n];
			check=new int[n];
			check[n-1]=n-1;
			for (int i = 0; i <n ; i++) {
				arr[i]=i;
			}
			int x;
			int y;
			c = new ArrayList<>();

			for (int i = 0; i <n ; i++) {
				x=sc.nextInt();
				y=sc.nextInt();
				c.add(new Point(x,y));
			}

			Point tmp = c.get(1);
			c.set(1,c.get(n-1));
			c.set(n-1,tmp);

			for(int i=1; i<n-1; i++){
				check[i]=1;
				arr[1]=i;
				dfs(2);
				check[i]=0;
			}

			System.out.println("#"+(test_case+1)+" "+min);
			min = 999999999;
		}
	}
	public static void dfs(int depth){

		if(depth == n-1){
			//여기서 길이 계산
            min = Math.min(min, count());
            print(arr,n);
			return;
		}
		for (int i = 1; i < n-1 ; i++) {
            //print(arr,n);
			if(check[i]==0){
				check[i]=1;
				arr[depth]=i;
				dfs(depth+1);
				check[i]=0;
                //print(check,n);
			}
		}
		return;
	}


	public static int count(){
	    int sum=0;
        for (int i = 0; i <n-1 ; i++) {
            Point a = c.get(arr[i]);
            Point b = c.get(arr[i+1]);
            sum+= Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
        }
        return sum;
    }
	public static void print(int[] arr, int k) {
		for (int i = 0; i < k; i++) {
			if (i == k - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + ",");
			}
		}
	}

}

class Point{
	int x;
	int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}