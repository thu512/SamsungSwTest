package 차량정비소2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Solution {

  static final int MAXS=9;
  static final int MAXK=1000;

  static int[] a = new int[MAXS+1];
  static int[] b = new int[MAXS+1];

  //접수창구 이용고객
  static cus[] rec = new cus[MAXS+1];
  //정비창구 이용고객
  static cus[] rep = new cus[MAXS+1];

  //접수창구 대기
  static cus[] recq = new cus[MAXK];
  //정비창구 대기
  static prc[] repq = new prc[MAXK];

  static int crp;
  static int prp, pwp;


  static int N; //접수창구 개수
  static int M; //정비창구 개수
  static int K; //이용 고객 수
  static int A; //지갑을 잃어 버린 고객의 접수창구 이용 번호
  static int B; //지갑을 잃어 버린 고객의 정비창구 이용 번호


  public static void _sort(cus[] arr, int from, int to){
    for(int i=from; i<to; ++i){
      for(int j=i+1; j<=to; ++j){
        if(arr[i].t > arr[j].t || (arr[i].t == arr[j].t && arr[i].k > arr[j].k)){
          cus temp = arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
        }
      }
    }
  }

  public static int solv(){
    int ans = 0;
    crp=0;

    pwp=0;
    prp=0;


    _sort(recq,0,K-1);


    for(int cnt=1, time=recq[0].t; cnt<=K; ++time){
      for(int i=0; i<N; ++i){ //접수창구번호 순대로
        if(rec[i].t > 0){
          if(--rec[i].t == 0){
            repq[pwp++].set(i,rec[i].k,time);
          }
        }

        if(rec[i].t == 0){
          if(crp<K && recq[crp].t <=time){
            cus customer = recq[crp++];
            rec[i].set(customer.k,a[i]);
          }
        }
      }

      for(int i=1; i<=M; ++i){
        if(rep[i].t > 0){
          if(--rep[i].t == 0){
            ++cnt;
          }
        }

        if(rep[i].t == 0){
          if(prp<pwp){
            prc prc = repq[prp++];
            rep[i].set(prc.k , b[i]);
            if(prc.idx == A && i==B){
              ans += prc.k;
            }
          }
        }
      }

    }

    if(ans==0){
      return -1;
    }else{
      return ans;
    }
  }

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int i=0; i<=MAXS; ++i){
      rec[i]=new cus();
      rep[i]=new cus();

    }
    for(int i=0; i<MAXK; ++i){
      recq[i]=new cus();
      repq[i]=new prc();

    }

    for (int test_case = 0; test_case < T; test_case++) {
      N = sc.nextInt(); //접수창구 개수
      M = sc.nextInt(); //정비창구 개수
      K = sc.nextInt(); //이용 고객 수
      A = sc.nextInt(); //지갑을 잃어 버린 고객의 접수창구 이용 번호
      B = sc.nextInt(); //지갑을 잃어 버린 고객의 정비창구 이용 번호

      for(int i=1; i<=N; ++i){
        a[i]=sc.nextInt();
      }
      for(int i=1; i<=M; ++i){
        b[i]=sc.nextInt();
      }

      for(int i=0; i<K; ++i){
        recq[i].k=i+1;
        recq[i].t=sc.nextInt();
      }



      System.out.println("#" + (test_case + 1) + " "+solv());
    }
  }



}

class cus{
  void set(int _k, int _t){
        k=_k;
        t=_t;
  }

  //도착 시간
  int k;

  //처리시간
  int t;

}

class prc{
  int idx; //접수 창구 번호 이용한
  int k;  //고객번호
  int t;  //큐에 삽입된 시간
  void set(int _idx, int _k, int _t){
    idx=_idx;
    k=_k;
    t=_t;
  }
}