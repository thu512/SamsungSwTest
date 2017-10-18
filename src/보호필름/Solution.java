package 보호필름;


import java.util.Scanner;

class Solution {
	static int[][] arr;
	static int[][] temp;
	static int D; //두께
	static int W; //가로
	static int K; //심사기준

  static int min=999999999;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 0; test_case < T; test_case++) {
			D=sc.nextInt();
			W=sc.nextInt();
			K=sc.nextInt();
			arr=new int[D][W];
			temp=new int[D][W];
			for(int i=0; i<D; i++){
				for(int j=0; j<W; j++){
				  arr[i][j]=sc.nextInt();
				}
			}

			int result=0;




			//0: x / 1: a / 2: b
      for(int i=0; i<3; i++){
        init();
        change(0,i);
        dfs(0,i!=0?1:0);
        recover(0);
      }


			System.out.println("#"+(test_case+1)+" "+min);
      min=999999999;
		}
	}

  public static void dfs(int r,int val){

	  if(val>=min){
	    return;
    }
    if(check()){
      //print(val);
      min=Math.min(min,val);
      return;
    }

    //0: x / 1: a / 2: b
    for(int i=0; i<3; i++){
      if(r+1<D){
        change(r+1,i);
        dfs(r+1,i!=0?val+1:val);
        recover(r+1);
      }

    }

    return;
  }
  public static void print(int val){
    System.out.println(" ");
    System.out.println(val+"=============================");

    for(int i=0; i<D; i++){
      for(int j=0; j<W; j++){
        System.out.print(temp[i][j]);
      }
      System.out.println(" ");
    }
    System.out.println("=============================");
    System.out.println(" ");
  }
  public static void init(){
    for(int i=0; i<D; i++){
      for(int j=0; j<W; j++){
        temp[i][j]=arr[i][j];
      }
    }
  }
  public static void recover(int r){

      for(int j=0; j<W; j++){
        temp[r][j]=arr[r][j];
      }

  }
	public static void change(int r,int val){
    if(val==0){
      return;
    }else if(val==1){
      for(int j=0; j<W; j++){
        temp[r][j]=0;
      }
    }else{
      for(int j=0; j<W; j++){
        temp[r][j]=1;
      }
    }
	}

	public static boolean check(){

		boolean result=true;

		for(int j=0; j<W; j++){
			int n=temp[0][j];
			int cnt=1;
			boolean flag=false;
			for(int i=1; i<D; i++){
				if(n==temp[i][j]){
					cnt++;
				}else{
					n=temp[i][j];
					cnt=1;
				}

				if(cnt==K){
					flag=true;
					break;
				}

			}

			if(!flag){
				result=false;
				return result;
			}
		}
		return result;
	}
}


