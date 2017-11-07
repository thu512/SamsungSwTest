package 순열2;

public class Test {
  static int[] arr;
  static int[] check;

  static int N;

  public static void main(String[] args) {
    N = 5;
    check = new int[N];
    arr = new int[N];


    for(int i=0; i<N; i++){
      check[i]=1;
      arr[0]=i;
      dfs(1);
      check[i]=0;
    }

  }

  public static void dfs(int depth) {
    if (depth == N) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.

      print(arr, N);
      return;
    }
    for (int i = 0; i < N; i++) {
      if(check[i]==0){
        check[i]=1;
        arr[depth]=i;
        dfs(depth+1);
        check[i]=0;
      }
    }

    return;

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
