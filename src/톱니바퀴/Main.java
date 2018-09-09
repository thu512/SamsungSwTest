package 톱니바퀴;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] topni;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        topni = new int[4][8];

        String[] input;
        for (int i = 0; i < 4; i++) {
            input = bf.readLine().split("");
            for (int j = 0; j < 8; j++) {
                topni[i][j] = Integer.parseInt(input[j]);
            }
        }
         int n = Integer.parseInt(bf.readLine());
        int[] dir = new int[4];

        for (int i = 0; i < n; i++) {
            input = bf.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);

            makeDir(num, d, dir);

//            for (int j = 0; j < 4; j++) {
//                System.out.print(dir[j]);
//            }
//            System.out.println("");
//
            for (int j = 0; j < 4; j++) {
                circleArr(dir[j], topni[j]);
            }
//            System.out.println("");
//            for (int k = 0; k < 4; k++) {
//                for (int l = 0; l < 8; l++) {
//                    System.out.print(topni[k][l]);
//                }
//                System.out.println("");
//            }
//            System.out.println("");
        }
        int result = topni[0][0] == 0? 0:1;
        result += topni[1][0] == 0? 0:2;
        result += topni[2][0] == 0? 0:4;
        result += topni[3][0] == 0? 0:8;


        System.out.println(result);
    }

    public static void makeDir(int num, int d, int[] dir){
        if(num == 1){
            if(d == 1){
                dir[0] = 1;
                if(topni[0][2] == topni[1][6]){
                    dir[1] = 0;
                    dir[2] = 0;
                    dir[3] = 0;

                }else{
                    dir[1] = -1;

                    if(topni[1][2] == topni[2][6]){
                        dir[2] = 0;
                        dir[3] = 0;
                    }else{
                        dir[2] = 1;

                        if(topni[2][2] == topni[3][6]){
                            dir[3] = 0;
                        }else{
                            dir[3] = -1;
                        }
                    }
                }
            }else{
                dir[0] = -1;
                if(topni[0][2] == topni[1][6]){
                    dir[1] = 0;
                    dir[2] = 0;
                    dir[3] = 0;
                }else{
                    dir[1] = 1;
                    if(topni[1][2] == topni[2][6]){
                        dir[2] = 0;
                        dir[3] = 0;
                    }else{
                        dir[2] = -1;
                        if(topni[2][2] == topni[3][6]){
                            dir[3] = 0;
                        }else{
                            dir[3] = 1;

                        }
                    }
                }
            }
        }else if(num == 2){
            if(d == 1){
                dir[1]=1;
                if(topni[1][6]==topni[0][2]){
                    dir[0]=0;
                }else{
                    dir[0]=-1;
                }

                if(topni[1][2]==topni[2][6]){
                    dir[2]=0;
                    dir[3]=0;

                }else{
                    dir[2]=-1;

                    if(topni[2][2]==topni[3][6]){
                        dir[3]=0;
                    }else{
                        dir[3]=1;
                    }
                }

            }else{
                dir[1]=-1;
                if(topni[1][6]==topni[0][2]){
                    dir[0]=0;
                }else{
                    dir[0]=1;
                }

                if(topni[1][2]==topni[2][6]){
                    dir[2]=0;
                    dir[3]=0;

                }else{
                    dir[2]=1;

                    if(topni[2][2]==topni[3][6]){
                        dir[3]=0;
                    }else{
                        dir[3]=-1;
                    }
                }
            }
        }else if(num == 3){
            if(d == 1){
                dir[2]=1;
                if(topni[2][2] == topni[3][6]){
                    dir[3]=0;
                }else{
                    dir[3]=-1;
                }

                if(topni[1][2] == topni[2][6]){
                    dir[1]=0;
                    dir[0]=0;

                }else{
                    dir[1]=-1;

                    if(topni[0][2] == topni[1][6]){
                        dir[0]=0;
                    }else{
                        dir[0]=1;
                    }
                }
            }else {
                dir[2]=-1;
                if(topni[2][2] == topni[3][6]){
                    dir[3]=0;
                }else{
                    dir[3]=1;
                }

                if(topni[1][2] == topni[2][6]){
                    dir[1]=0;
                    dir[0]=0;

                }else{
                    dir[1]=1;

                    if(topni[0][2] == topni[1][6]){
                        dir[0]=0;
                    }else{
                        dir[0]=-1;
                    }
                }
            }
        }else{
            if(d == 1){
                dir[3] = 1;

                if(topni[2][2] == topni[3][6]){
                    dir[2] = 0;
                    dir[1]=0;
                    dir[0]=0;

                }else{
                    dir[2] = -1;

                    if(topni[1][2] == topni[2][6]){
                        dir[1] = 0;
                        dir[0]=0;

                    }else{
                        dir[1] = 1;

                        if(topni[0][2] == topni[1][6]){
                            dir[0] = 0;
                        }else{
                            dir[0] = -1;
                        }
                    }
                }
            }else{
                dir[3] = -1;
                if(topni[2][2] == topni[3][6]){
                    dir[2] = 0;
                    dir[1]=0;
                    dir[0]=0;


                }else{
                    dir[2] = 1;
                    if(topni[1][2] == topni[2][6]){
                        dir[1] = 0;
                        dir[0]=0;

                    }else{
                        dir[1] = -1;
                        if(topni[0][2] == topni[1][6]){
                            dir[0] = 0;
                        }else{
                            dir[0] = 1;

                        }
                    }
                }
            }
        }
    }

    public static void circleArr(int dir, int[] arr){
        if(dir == 1){
            //시계방향
            int tmp = arr[arr.length-1];
            for (int i = arr.length-2; i >=0 ; i--) {
                arr[i+1]=arr[i];
            }
            arr[0] = tmp;
        }else if(dir == -1){
            //반시계
            int tmp = arr[0];
            for (int i = 1; i <arr.length ; i++) {
                arr[i-1]=arr[i];
            }
            arr[arr.length-1] = tmp;
        }
    }
}
