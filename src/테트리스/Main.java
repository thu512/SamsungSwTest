package 테트리스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int C;
    static int N;
    static int[][] map;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        C = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        map = new int[110][C];

        s = bf.readLine().split(" ");

        for (int c = 0; c < C; c++) {
            for (int i = 110 - 1; i >= 110 - Integer.parseInt(s[c]); i--) {
                map[i][c] = 1;
            }
        }
        res = 0;
        for (int c = 0; c < C; c++) {
            drop(110 - 1 - Integer.parseInt(s[c]), c);
        }

        System.out.println(res);
    }

    public static void drop(int r, int c) {
        switch (N) {
            case 1:
                res++; // 세로1자 무조건 통과

                boolean flag = true;
                for (int i = 0; i < 4; i++) {
                    if (c + i >= C) {
                        flag=false;
                        break;
                    }
                    if (map[r][c + i] != 0) {
                        flag=false;
                        break;
                    }
                    if (r + 1 <= 109 && map[r + 1][c + i] == 0) {
                        flag=false;
                        break;
                    }
                }
//                if(r==109){
//                    for (int i = 0; i < 4; i++) {
//                        if(map[r][c+i]!=0){
//                            break;
//                        }
//                    }
//                }else{
//                    for (int i = 0; i < 4; i++) {
//                        if(map[r][c+i]!=0){
//                            break;
//                        }
//                        if(map[r+1][c+i]==0){
//                            break;
//                        }
//                    }
//                }
                if(flag) res++;
                break;
            case 2:
                if (c + 1 >= C) {
                    break;
                }
                if (map[r][c + 1] != 0) {
                    break;
                }
                if (r + 1 <= 109 && map[r + 1][c + 1] == 0) {
                    break;
                }
                res++;
                break;
            case 3:
                int tr = r;
                int tc = c + 1;
                int tr1 = r - 1;
                int tc1 = c + 1;
                int tr2 = r - 1;
                int tc2 = c + 2;
                if (tc2 < C && map[tr][tc] == 0 && map[tr1][tc1] == 0 && map[tr2][tc2] == 0) {
                    if (r + 1 <= 109 && map[tr + 1][tc] != 0 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                    if (r == 109 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                }

                tr = r - 1;
                tc = c;
                tr1 = r - 1;
                tc1 = c - 1;
                tr2 = r - 2;
                tc2 = c - 1;
                if (tc1 >= 0 && map[tr][tc] == 0 && map[tr1][tc1] == 0 && map[tr2][tc2] == 0) {
                    if (map[tr1 + 1][tc1] != 0) {
                        res++;
                    }

                }
                break;
            case 4:
                tr = r;
                tc = c + 1;
                tr1 = r + 1;
                tc1 = c + 1;
                tr2 = r + 1;
                tc2 = c + 2;
                if (tr1 <= 109 && tc2 < C && map[tr][tc] == 0 && map[tr1][tc1] == 0 && map[tr2][tc2] == 0) {
                    if (tr1 + 1 <= 109 && map[tr1 + 1][tc1] != 0 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                    if (tr1 == 109) {
                        res++;
                    }
                }

                tr = r - 1;
                tc = c;
                tr1 = r - 1;
                tc1 = c + 1;
                tr2 = r - 2;
                tc2 = c + 1;
                if (tc1 < C && map[tr1][tc1] == 0 && map[tr1 + 1][tc1] != 0) {
                    res++;
                }

                break;
            case 5:
                tr = r;
                tc = c + 1;
                tr1 = r - 1;
                tc1 = c + 1;
                tr2 = r;
                tc2 = c + 2;
                if (tc2 < C && map[tr][tc] == 0 && map[tr1][tc1] == 0 && map[tr2][tc2] == 0) {
                    if (tr + 1 <= 109 && map[tr + 1][tc] != 0 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                    if (tr == 109) {
                        res++;
                    }
                }

                tr = r;
                tc = c + 1;
                tr1 = r + 1;
                tc1 = c + 1;
                tr2 = r;
                tc2 = c + 2;
                if (tr1 <= 109 && tc2 < C && map[tr1][tc1] == 0 && map[tr2][tc2] == 0) {
                    if (tr1 + 1 <= 109 && map[tr1 + 1][tc1] != 0 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                    if (tr1 == 109 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                }

                tr = r;
                tc = c + 1;
                tr1 = r + 1;
                tc1 = c + 1;
                tr2 = r - 1;
                tc2 = c + 1;
                if (tr1 <= 109 && tc2 < C && map[tr1][tc1] == 0) {
                    if (tr1 + 1 <= 109 && map[tr1 + 1][tc1] != 0) {
                        res++;
                    }
                    if (tr1 == 109) {
                        res++;
                    }
                }

                tr = r - 1;
                tc = c;
                tr1 = r - 2;
                tc1 = c;
                tr2 = r - 1;
                tc2 = c + 1;
                if (tc2 < C && map[tr2][tc2] == 0) {
                    if (map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                }
                break;
            case 6:
                tr = r;
                tc = c + 1;
                tr1 = r;
                tc1 = c + 2;
                tr2 = r - 1;
                tc2 = c + 2;
                if (tc1 < C && map[tr][tc] == 0 && map[tr1][tc1] == 0) {
                    if (tr == 109) {
                        res++;
                    }
                    if (tr + 1 <= 109 && map[tr + 1][tc] != 0 && map[tr1 + 1][tc1] != 0) {
                        res++;
                    }
                }

                tr = r - 1;
                tc = c;
                tr1 = r - 1;
                tc1 = c + 1;
                tr2 = r - 1;
                tc2 = c + 2;
                if (tc2 < C && map[tr1][tc1] == 0 && map[tr2][tc2] == 0) {

                    if (map[tr1 + 1][tc1] != 0 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                }

                tr = r - 1;
                tc = c;
                tr1 = r - 2;
                tc1 = c;
                tr2 = r;
                tc2 = c + 1;
                if (tc2 < C && map[tr2][tc2] == 0) {

                    if (tr2 == 109) {
                        res++;
                    }
                    if (tr2 + 1 <= 109 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                }

                tr = r;
                tc = c + 1;
                tr1 = r + 1;
                tc1 = c + 1;
                tr2 = r + 2;
                tc2 = c + 1;
                if (tc2 < C && tr2 <= 109 && map[tr2][tc2] == 0) {

                    if (tr2 == 109) {
                        res++;
                    }
                    if (tr2 + 1 <= 109 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                }
                break;
            case 7:
                tr = r - 1;
                tc = c;
                tr1 = r;
                tc1 = c + 1;
                tr2 = r;
                tc2 = c + 2;
                if (tc2 < C && map[tr1][tc1] == 0 && map[tr2][tc2] == 0) {

                    if (tr1 == 109) {
                        res++;
                    }
                    if (tr1 + 1 <= 109 && map[tr1 + 1][tc1] != 0 && map[tr2 + 1][tc2] != 0) {
                        res++;
                    }
                }

                tr = r - 1;
                tc = c;
                tr1 = r - 2;
                tc1 = c;
                tr2 = r - 2;
                tc2 = c + 1;
                if (tc2 < C && map[tr2][tc2] == 0 && map[tr2 + 1][tc2] != 0) {
                    res++;
                }

                tr = r;
                tc = c+1;
                tr1 = r;
                tc1 = c+2;
                tr2 = r + 1;
                tc2 = c + 2;
                if (tc2 < C && tr2<=109 && map[tr][tc] == 0 && map[tr1][tc1] == 0 && map[tr2][tc2] == 0) {
                    if(tr2==109 && map[tr+1][tc] != 0){
                        res++;
                    }
                    if(tr2+1<=109 && map[tr+1][tc] != 0 && map[tr2+1][tc2] != 0){
                        res++;
                    }

                }

                tr = r;
                tc = c+1;
                tr1 = r-1;
                tc1 = c+1;
                tr2 = r -2;
                tc2 = c + 1;
                if (tc1 < C && map[tr][tc] == 0) {
                    if(tr==109){
                        res++;
                    }
                    if(tr+1<=109 && map[tr+1][tc] != 0){
                        res++;
                    }

                }
                break;
        }
    }
}