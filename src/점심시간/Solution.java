package 점심시간;

import java.util.*;

class Solution {

    static int[][] map;
    static ArrayList<Student> s;
    static ArrayList<Student> ts;
    static ArrayList<Stair> stairs;
    static ArrayList<Student> s0;
    static ArrayList<Student> s1;


    public static void main(String args[]) throws Exception {


        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            int N = sc.nextInt();
            stairs = new ArrayList<>();
            s = new ArrayList<>();
            ts = new ArrayList<>();
            s0=new ArrayList<>();
            s1=new ArrayList<>();


            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 1) {
                        s.add(new Student(i, j));
                    } else if (map[i][j] > 1) {
                        stairs.add(new Stair(i, j, map[i][j]));
                    }
                }
            }
            int min=999999999;

            for (int i = 0; i < (1 << s.size()); i++) {

                s0.clear();
                s1.clear();
                //계단 배치
                for (int j = 0; j < s.size(); j++) {
                    if ((i & (1 << j)) != 0) {
                        s.get(j).setsN(1);
                    } else {
                        s.get(j).setsN(0);
                    }
                }

                //계단 까지 거리 구성
                for (int j = 0; j < s.size(); j++) {
                    int pR = s.get(j).getR();
                    int pC = s.get(j).getC();

                    int sn = s.get(j).getsN();
                    int sR = stairs.get(sn).getR();
                    int sC = stairs.get(sn).getC();

                    s.get(j).setsD(cntDir(pR, pC, sR, sC));
                    s.get(j).setRemain(stairs.get(sn).getH());
                }
                int time=1;
                ts.addAll(s);

//                System.out.println(i+"");
//                for (int k = 0; k < ts.size(); k++) {
//                    System.out.println(ts.get(k).getsN()+" / "+ts.get(k).getsD()+" / "+ts.get(k).getRemain());
//                }
//                System.out.println("");

                while(true){
                    if(ts.size()==0){
                        min=Math.min(min,time-1);
                        break;
                    }
                    //0번 계단에 있는사람들 1칸씩 내려보냄 다내려가면 뺌
                    if(s0.size()>0){
                        for(int x=0; x<s0.size(); x++){
                            int remain=s0.get(x).getRemain();
                            if(remain-1==0){
                                ts.remove(s0.get(x));
                                s0.remove(x);
                                x--;
                            }else{
                                s0.get(x).setRemain(remain-1);
                            }
                        }
                    }

                    //1번 계단에 있는사람들 1칸씩 내려보냄 다내려가면 뺌
                    if(s1.size()>0){
                        for(int x=0; x<s1.size(); x++){
                            int remain=s1.get(x).getRemain();
                            if(remain-1==0){
                                ts.remove(s1.get(x));
                                s1.remove(x);
                                x--;
                            }else{
                                s1.get(x).setRemain(remain-1);
                            }
                        }
                    }

                    //각각 계단까지거리와 시간을 비교해서 계단에 도착한사람들을 계단에 넣음
                    //만약 계단에 3명이 꽉차있으면 계단까지 거리를 +1시켜서 다음턴에 또 체크 되게 함, 대기시키는것
                    for(int x=0; x<ts.size(); x++){

                        //거리와 시간이 같은경우는 입구 도착, 계단에 들어가는건 거리+1==시간
                        if(ts.get(x).getsD()+1==time){
                            int n= ts.get(x).getsN();
                            if(n==0){
                                if(s0.size()>=3){
                                    ts.get(x).setsD(ts.get(x).getsD()+1);
                                }else{
                                    s0.add(ts.get(x));
                                }

                            }else{
                                if(s1.size()>=3){
                                    ts.get(x).setsD(ts.get(x).getsD()+1);
                                }else{
                                    s1.add(ts.get(x));
                                }
                            }
                        }
                    }

//                    System.out.println(time+"분 후");
//                    for (int k = 0; k < s0.size(); k++) {
//                        System.out.print(k+" ");
//                    }
//                    System.out.println("");
//
//                    for (int k = 0; k < s1.size(); k++) {
//                        System.out.print(k+" ");
//                    }
//                    System.out.println("");


                    time++;
                //////////////////////////////////////////////////////////////while
                }

            }


            System.out.println("#" + (test_case + 1) + " "+min);

        }
    }

    public static void update() {

    }

    public static void dfs(int person_i) {

    }

    public static int cntDir(int pr, int pc, int sr, int sc) {
        return Math.abs(pr - sr) + Math.abs(pc - sc);
    }
}

//for(int k=0; k<s.size(); k++){
//        System.out.print(s.get(k).getsN());
//        }
//        System.out.println("");


class Stair {
    int r;
    int c;
    int h;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Stair(int r, int c, int h) {

        this.r = r;
        this.c = c;
        this.h = h;
    }
}

class Student {
    int r;
    int c;
    int sN; //계단 번호
    int sD; //계단까지 거리
    int remain; //내려가야될 남은 계단 수

    public Student(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getsN() {
        return sN;
    }

    public void setsN(int sN) {
        this.sN = sN;
    }

    public int getsD() {
        return sD;
    }

    public void setsD(int sD) {
        this.sD = sD;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }
}