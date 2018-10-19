package 틱택토;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {1,-1,1,-1};
    static int[] dc = {1,-1,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String s = bf.readLine();
            if(s.equals("end")){
                break;
            }

            String[][] map = new String[3][3];
            int xCnt=0;
            int oCnt=0;
            int bCnt=0;

            int len=0;
            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {
                    map[i][j] = s.split("")[len];
                    len++;
                    if(map[i][j].equals("X")){
                        xCnt++;
                    }else if(map[i][j].equals("O")){
                        oCnt++;
                    }else{
                        bCnt++;
                    }
                }
            }
            System.out.println();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(" "+map[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println(oCnt+" / "+xCnt);
            if(oCnt>xCnt){
                System.out.println("invalid");
                continue;
            }

            if((xCnt-oCnt) > 1){
                System.out.println("invalid");
                continue;
            }

            if(bCnt==0){
                System.out.println("valid");
                continue;
            }

            boolean flag = false;

            boolean xFlag = false;
            boolean oFlag = false;


            for (int i = 0; i < 3; i++) {
                if(!map[i][1].equals(".") && map[i][1].equals(map[i][0]) && map[i][1].equals(map[i][2])){

                    if(map[i][1].equals("X")){
                        xFlag=true;
                    }

                    if(map[i][1].equals("O")){
                        oFlag=true;
                    }
                }
            }


            for (int i = 0; i < 3; i++) {
                if(!map[1][i].equals(".") && map[1][i].equals(map[0][i]) && map[1][i].equals(map[2][i])){
                    if(map[1][i].equals("X")){
                        xFlag=true;
                    }

                    if(map[1][i].equals("O")){
                        oFlag=true;
                    }
                }
            }


            if(!map[1][1].equals(".") && map[1][1].equals(map[0][0]) && map[1][1].equals(map[2][2])){
                if(map[1][1].equals("X")){
                    xFlag=true;
                }

                if(map[1][1].equals("O")){
                    oFlag=true;
                }
            }
            if(!map[1][1].equals(".") && map[1][1].equals(map[0][2]) && map[1][1].equals(map[2][0])){
                if(map[1][1].equals("X")){
                    xFlag=true;
                }

                if(map[1][1].equals("O")){
                    oFlag=true;
                }
            }

            if(xFlag && !oFlag){
                if(xCnt>oCnt){
                    System.out.println("valid");
                }else{
                    System.out.println("invalid");
                }

            }else if(!xFlag && oFlag){
                if(xCnt==oCnt){
                    System.out.println("valid");
                }else{
                    System.out.println("invalid");
                }
            }else if(xFlag && oFlag){

                //이부분 수정 필요
                if(xCnt==oCnt){
                    System.out.println("invalid");
                }else{
                    System.out.println("valid");
                }
            }else{
                System.out.println("invalid");
            }

        }

    }
}
//OOOXXXX..