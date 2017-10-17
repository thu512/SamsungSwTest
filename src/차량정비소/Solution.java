package 차량정비소;

import java.util.*;

class Solution {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int test_case = 0; test_case < T; test_case++) {
      int N = sc.nextInt(); //접수창구 개수
      int M = sc.nextInt(); //정비창구 개수
      int K = sc.nextInt(); //이용 고객 수
      int A = sc.nextInt(); //지갑을 잃어 버린 고객의 접수창구 이용 번호
      int B = sc.nextInt(); //지갑을 잃어 버린 고객의 정비창구 이용 번호

      int[] a = new int[N + 1];
      int[] visitA = new int[N + 1];

      //접수창구 업무 처리 시간
      for (int i = 1; i <= N; i++) {
        a[i] = sc.nextInt();
      }

      //정비창구 업무 처리 시간
      int[] b = new int[M + 1];
      int[] visitB = new int[M + 1];
      for (int i = 1; i <= M; i++) {
        b[i] = sc.nextInt();
      }

      //고객 도착 시간
      ArrayList<Customer> k = new ArrayList<>();
      for (int i = 0; i < K; i++) {
        k.add(new Customer(i, sc.nextInt()));
      }

      int time = 0;
      ArrayList<Customer> a1 = new ArrayList<>();
      while (true) {

        //접수가끝난 고객들 빼줌 -> 정비 창구 들어갈순서대로 새움
        for (int i = 0; i < k.size(); i++) {
          if (time == k.get(i).getA_end()) {
            a1.add(k.get(i));
            visitA[k.get(i).getA()] = 0;
            k.remove(i);
            i--;
          }
        }
        //접수 창구에 고객들 배치
        //비어있는 곳에 먼저 넣음 도착 시간순대로
        for (int i = 0; i < k.size(); i++) {
          int index = checkBlank(visitA);
          if (time == k.get(i).getAt()) {
            if (index != -1) {
              visitA[index] = 1;
              k.get(i).setA_start(time);
              k.get(i).setA_end(time + a[index]);
              k.get(i).setA(index);
            } else {
              k.get(i).setAt(k.get(i).getAt() + 1);
            }
          }
        }

        if (a1.size() == K) {
          break;
        }
        time++;
      }

      time = 0;
      ArrayList<Customer> b1 = new ArrayList<>();
      Collections.sort(a1, new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
          if (o1.getA_end() < o2.getA_end()) {
            return -1;
          } else if (o1.getA_end() > o2.getA_end()) {
            return 1;
          } else {
            if (o1.getA() < o2.getA()) {
              return -1;
            } else if (o1.getA() < o2.getA()) {
              return 1;
            } else {
              return 0;
            }
          }
        }
      });

      for (int i = 0; i < a1.size(); i++) {

        System.out.println(
            "n: " + (a1.get(i).getN() + 1) + " / 접수 " + a1.get(i).getA() + " 시작 " + a1.get(i)
                .getA_start() + " 끝: " + a1.get(i).getA_end());
      }

      for (int i = 0; i < a1.size(); i++) {

        a1.get(i).setAt(a1.get(i).getA_end());
      }
      while (true) {
        //접수가끝난 고객들 빼줌 -> 정비 창구 들어갈순서대로 새움
        for (int i = 0; i < a1.size(); i++) {
          if (time == a1.get(i).getB_end()) {
            b1.add(a1.get(i));
            visitB[a1.get(i).getB()] = 0;
            a1.remove(i);
            i--;
          }
        }
        //정비 창구에 고객들 배치
        //비어있는 곳에 먼저 넣음 도착 시간순대로
        for (int i = 0; i < a1.size(); i++) {
          int index = checkBlank(visitB);
          if (time == a1.get(i).getAt()) {
            if (index != -1) {
              visitB[index] = 1;
              a1.get(i).setB_start(time);
              a1.get(i).setB_end(time + b[index]);
              a1.get(i).setB(index);
            } else {
              a1.get(i).setAt(a1.get(i).getAt() + 1);
            }
          }
        }
        if (b1.size() == K) {
          break;
        }
        time++;
      }
      for (int i = 0; i < b1.size(); i++) {

        System.out.println("n: "
            + (b1.get(i).getN() + 1)
            + " at: "
            + b1.get(i).getAt()
            + " 정비 "
            + b1.get(i).getB()
            + " / stime "
            + b1.get(i).getB_start()
            + " / etime "
            + b1.get(i).getB_end());
      }
      int result = 0;
      for (int i = 0; i < b1.size(); i++) {
        System.out.println(
            "n: " + (b1.get(i).getN() + 1) + " / 접수 " + b1.get(i).getA() + " 정비 " + b1.get(i)
                .getB());
        if ((A == b1.get(i).getA()) && (B == b1.get(i).getB())) {
          result += (b1.get(i).getN() + 1);
        }
      }

      if (result == 0) {
        result = -1;
      }

      System.out.println("#" + (test_case + 1) + " " + result);
    }
  }

  public static int checkBlank(int[] arr) {
    int index = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == 0) {
        return i;
      }
    }
    return -1;
  }
}

class Customer {
  int n; //고객번호
  int at; //도착시간
  int a;  //이용한 접수창구 번호
  int b;  //이용한 정비창구 번호
  int a_start = -1;
  int a_end = -1;
  int b_start = -1;
  int b_end = -1;

  public int getB_start() {
    return b_start;
  }

  public void setB_start(int b_start) {
    this.b_start = b_start;
  }

  public int getB_end() {
    return b_end;
  }

  public void setB_end(int b_end) {
    this.b_end = b_end;
  }

  public int getN() {
    return n;
  }

  public void setN(int n) {
    this.n = n;
  }

  public int getA_start() {
    return a_start;
  }

  public void setA_start(int a_start) {
    this.a_start = a_start;
  }

  public int getA_end() {
    return a_end;
  }

  public void setA_end(int a_end) {
    this.a_end = a_end;
  }

  public Customer(int n, int at) {
    this.at = at;
    this.n = n;
  }

  public int getAt() {
    return at;
  }

  public void setAt(int at) {
    this.at = at;
  }

  public int getA() {
    return a;
  }

  public void setA(int a) {
    this.a = a;
  }

  public int getB() {
    return b;
  }

  public void setB(int b) {
    this.b = b;
  }
}

