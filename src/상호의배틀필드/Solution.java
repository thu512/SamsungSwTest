package 상호의배틀필드;


import java.util.Scanner;

class Solution {

    //위오아왼
    static int[] dir_r={-1,0,1,0};
    static int[] dir_c={0,1,0,-1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();

            char[][] map = new char[r][c];

            for (int i = 0; i < r; i++) {
                String line = sc.nextLine();
                map[i] = line.toCharArray();
            }

            int num = sc.nextInt();
            sc.nextLine();

            char[] control = sc.nextLine().toCharArray();
            int loc_r = 0;
            int loc_c = 0;
            int dir=0; //0위 1오 2아 3왼
            for (int i = 0; i <r ; i++) {
                for (int j = 0; j <c ; j++) {
                    if(map[i][j] == '>'){
                        loc_r=i;
                        loc_c=j;
                        dir = 1;
                        break;
                    }else if(map[i][j] == '<'){
                        loc_r=i;
                        loc_c=j;
                        dir = 3;
                        break;
                    }else if(map[i][j] == 'v'){
                        loc_r=i;
                        loc_c=j;
                        dir = 2;
                        break;
                    }else if(map[i][j] == '^'){
                        loc_r=i;
                        loc_c=j;
                        dir = 0;
                        break;
                    }
                }
            }

            for (int i = 0; i < num; i++) {
                switch (control[i]) {
                    case 'U':
                        int tmp_r = loc_r+dir_r[0];
                        int tmp_c = loc_c+dir_c[0];

                        if(tmp_r >= 0 && map[tmp_r][tmp_c] == '.'){
                            map[tmp_r][tmp_c]='^';
                            map[loc_r][loc_c]='.';
                            loc_r=tmp_r;
                            loc_c=tmp_c;
                            dir=0;
                        }else{
                            map[loc_r][loc_c]='^';
                            dir=0;
                        }

                        break;
                    case 'D':
                        tmp_r = loc_r+dir_r[2];
                        tmp_c = loc_c+dir_c[2];

                        if(tmp_r < r && map[tmp_r][tmp_c] == '.'){
                            map[tmp_r][tmp_c]='v';
                            map[loc_r][loc_c]='.';
                            loc_r=tmp_r;
                            loc_c=tmp_c;
                            dir=2;
                        }else{
                            map[loc_r][loc_c]='v';
                            dir=2;
                        }

                        break;
                    case 'L':
                        tmp_r = loc_r+dir_r[3];
                        tmp_c = loc_c+dir_c[3];

                        if(tmp_c >= 0 && map[tmp_r][tmp_c] == '.'){
                            map[tmp_r][tmp_c]='<';
                            map[loc_r][loc_c]='.';
                            loc_r=tmp_r;
                            loc_c=tmp_c;
                            dir=3;
                        }else{
                            map[loc_r][loc_c]='<';
                            dir=3;
                        }
                        break;
                    case 'R':
                        tmp_r = loc_r+dir_r[1];
                        tmp_c = loc_c+dir_c[1];

                        if(tmp_c < c && map[tmp_r][tmp_c] == '.'){
                            map[tmp_r][tmp_c]='>';
                            map[loc_r][loc_c]='.';
                            loc_r=tmp_r;
                            loc_c=tmp_c;
                            dir=1;
                        }else{
                            map[loc_r][loc_c]='>';
                            dir=1;
                        }
                        break;
                    case 'S':
                        switch (dir){
                            case 0:
                                tmp_r=loc_r;
                                tmp_c=loc_c;
                                while(true){
                                    if(tmp_r < 0){
                                        break;
                                    }
                                    if(map[tmp_r][tmp_c] == '#'){
                                        break;
                                    }
                                    if(map[tmp_r][tmp_c] == '*'){
                                        map[tmp_r][tmp_c]='.';
                                        break;
                                    }
                                    tmp_r=tmp_r+dir_r[0];
                                }
                                break;
                            case 1:

                                tmp_r=loc_r;
                                tmp_c=loc_c;
                                while(true){
                                    if(tmp_c >= c){
                                        break;
                                    }
                                    if(map[tmp_r][tmp_c] == '#'){
                                        break;
                                    }
                                    if(map[tmp_r][tmp_c] == '*'){
                                        map[tmp_r][tmp_c]='.';
                                        break;
                                    }
                                    tmp_c=tmp_c+dir_c[1];
                                }
                                break;
                            case 2:

                                tmp_r=loc_r;
                                tmp_c=loc_c;
                                while(true){
                                    if(tmp_r >= r){
                                        break;
                                    }
                                    if(map[tmp_r][tmp_c] == '#'){
                                        break;
                                    }
                                    if(map[tmp_r][tmp_c] == '*'){
                                        map[tmp_r][tmp_c]='.';
                                        break;
                                    }
                                    tmp_r=tmp_r+dir_r[2];
                                }
                                break;
                            case 3:

                                tmp_r=loc_r;
                                tmp_c=loc_c;
                                while(true){
                                    if(tmp_c < 0){
                                        break;
                                    }
                                    if(map[tmp_r][tmp_c] == '#'){
                                        break;
                                    }
                                    if(map[tmp_r][tmp_c] == '*'){
                                        map[tmp_r][tmp_c]='.';
                                        break;
                                    }
                                    tmp_c=tmp_c+dir_c[3];
                                }
                                break;
                        }

                        break;

                }

            }

            System.out.print("#" + (test_case + 1) + " ");
            for (int i = 0; i <r ; i++) {
                for (int j = 0; j <c ; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println("");
            }
        }
    }

}


