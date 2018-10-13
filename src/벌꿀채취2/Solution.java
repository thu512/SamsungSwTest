package 벌꿀채취2;

import java.util.Scanner;
import java.util.Stack;

class Solution {
    static int[][] map;
    static int[][] visit;
    static int C;
    static int M;
    static int max = 0;
    static int max1 = 0;
    static int max2 = 0;

    static int[] tmp;
    static Stack<Integer> st;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            map = new int[N][N];
            visit = new int[N][N];
            st = new Stack<>();
            tmp = new int[M];


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i <= N - M; i++) {
                    int t = 0;
                    for (int j = i; j < i + M; j++) {

                        tmp[t] = map[k][j];
                        t++;
                    }

                    for (int x = 1; x <= M; x++) {


                        doCombination(M, x, 0);
                    }

                    if (max1 < max) {
                        max1 = max;
                        for (int R = 0; R < N; R++) {
                            for (int C = 0; C < N; C++) {
                                visit[R][C] = 0;
                            }
                        }
                        for (int w = i; w < i + M; w++) {
                            visit[k][w] = 1;

                        }

                    }
                }

            }
//            for(int i=0; i<N; i++) {
//                for(int j=0; j<N; j++) {
//                    System.out.print(visit[i][j]);
//                }
//                System.out.println("");
//            }
            max = 0;
            st.clear();

            for (int k = 0; k < N; k++) {
                for (int i = 0; i <= N - M; i++) {
                    int t = 0;
                    boolean flag = true;
                    for (int j = i; j < i + M; j++) {
                        if (visit[k][j] == 1) {
                            flag = false;
                            break;
                        }
                        tmp[t] = map[k][j];
                        t++;
                    }
                    if (!flag) continue;

                    for (int x = 1; x <= M; x++) {


                        doCombination(M, x, 0);
                    }

                    if (max2 < max) {
                        max2 = max;
                    }
                }

            }


            System.out.println("#" + (test_case + 1) + " " + (max1 + max2));
            max1 = 0;
            max2 = 0;
            max = 0;
        }
    }

    public static void doCombination(int n, int r, int index) {
        // n : 전체 개수
        // r : 뽑을 개수
        // index 배열이다보니 현재 배열의 어디를 가리키고 있는지 필요하므로.
        if (r == 0) {
            //0개를 뽑는다는건 더 이상 뽑을 것이 없다는 말과 같으므로  스택을 출력하고 함수를 종료한다.
            //printStack();

            int tmp = count();
            if (tmp != 0) {
                if (max < tmp) {
                    max = tmp;
                    //printStack();
                }

            }

            return;
        } else if (n == r) {
            //nCr 이라는 건 나머지를 전부 뽑겠다는 말과 같으므로 전부 스택에 넣은 후 출력하면 된다.
            for (int i = 0; i < n; i++) st.add(tmp[index + i]);//index부터 n개를 차례대로 스택에 넣고
            //printStack();


            int tmp = count();
            if (tmp != 0) {
                if (max < tmp) {
                    max = tmp;
                    //printStack();
                }
            } //스택을 보여준다.
            for (int i = 0; i < n; i++) st.pop(); //이후 전부 pop을 시켜 다음 과정을 진행한다.
        } else {
            //저 두가지 예외 사항을 빼면 점화식대로 진행하면 된다.

            //index를 포함하는 경우
            st.add(tmp[index]);
            doCombination(n - 1, r - 1, index + 1); //index를 스택에 넣은상태로 index를 1옮겨 그대로 진행.

            //index를 포함하지 않는 경우
            st.pop(); //index를 제거해주고
            doCombination(n - 1, r, index + 1); //index를 제외한 상태에서 n-1Cr 진행.


        }
    }

    public static int count() {
        int sum = 0;
        int sum1 = 0;

        for (int i = 0; i < st.size(); i++) {
            sum += st.get(i);
            sum1 += Math.pow(st.get(i), 2);
            if (C < sum) {
                return 0;
            }
        }
        return sum1;
    }


    public static void printStack() {
        for (int i = 0; i < st.size(); i++) {
            System.out.print(st.get(i) + " ");
        }
        System.out.println("");
    }
}


