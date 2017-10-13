package 장훈이의높은선반;


import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class Solution {

	static int[] arr;
	static int[] check;
	static int B;
	static int N;
	static int min=200000;
	static Stack<Integer> st;
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++) {
			N =sc.nextInt();
			B =sc.nextInt();
			arr = new int[N];
			check = new int[N];
			st=new Stack<>();

			for (int i=0; i<N; i++){
				arr[i]=sc.nextInt();
			}

			for (int i=1; i<=N; i++){

				doCombination(N,i,0);
			}

			int result=min-B;
			System.out.println("#"+(test_case+1)+" "+result);
			min=200000;
		}
	}

	public static int count(){
		int sum=0;
		for(int i=0; i<st.size(); i++){
			sum+=st.get(i);
			if(min<=sum){
				return 0;
			}
		}
		return sum;
	}
	public static void printStack(){
		for(int i=0; i<st.size(); i++){
			System.out.print(st.get(i)+" ");
		}
		System.out.println("");
	}
	public static void doCombination(int n, int r, int index){
		// n : 전체 개수
		// r : 뽑을 개수
		// index 배열이다보니 현재 배열의 어디를 가리키고 있는지 필요하므로.
		if(r==0){
			//0개를 뽑는다는건 더 이상 뽑을 것이 없다는 말과 같으므로  스택을 출력하고 함수를 종료한다.
			//printStack();
			int tmp=count();
			if(tmp!=0){
				if(tmp>=B && min>tmp){
					min=tmp;
				}

			}

			return;
		}
		else if(n==r){
			//nCr 이라는 건 나머지를 전부 뽑겠다는 말과 같으므로 전부 스택에 넣은 후 출력하면 된다.
			for(int i=0;i<n;i++)st.add(arr[index+i]);//index부터 n개를 차례대로 스택에 넣고
			//printStack();
			int tmp=count();
			if(tmp!=0){
				if(tmp>=B && min>tmp){
					min=tmp;
				}
			} //스택을 보여준다.
			for(int i=0;i<n;i++)st.pop(); //이후 전부 pop을 시켜 다음 과정을 진행한다.
		}
		else{
			//저 두가지 예외 사항을 빼면 점화식대로 진행하면 된다.

			//index를 포함하는 경우
			st.add(arr[index]);
			doCombination(n-1,r-1,index+1); //index를 스택에 넣은상태로 index를 1옮겨 그대로 진행.

			//index를 포함하지 않는 경우
			st.pop(); //index를 제거해주고
			doCombination(n-1, r, index+1); //index를 제외한 상태에서 n-1Cr 진행.


		}
	}


	public static void dfs(int val){
		if(val>=min){
			return;
		}
		if(val>=B && val<=min){
			min=val;
			return;
		}

		for(int i=0; i<N; i++){
			if(check[i]!=1){
				check[i]=1;
				dfs(val+arr[i]);
				check[i]=0;
			}
		}
		return;

	}


	
}


