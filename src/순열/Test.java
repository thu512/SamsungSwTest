package 순열;

public class Test {
  static int[] selected;
  static int R;
  static int N;

  public static void main(String[] args) {
    N = 12;
    selected = new int[N];
    for(int i=0; i<12; i++){
      selected[i]=i+1;
    }
    perm(selected,0,12,12);
  }

  public static void perm(int[] arr, int depth, int n, int k) {
    if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.

      print(selected, selected.length);
      return;
    }
    for (int i = depth; i < n; i++) {
      swap(arr, i, depth);
      perm(arr, depth + 1, n, k);
      swap(arr, i, depth);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
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
