package 무선충전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    /**
     * @param args
     */
    //x 상 우 하 좌
    static int[] dx = {0, 0,1,0,-1};
    static int[] dy = {0, -1,0,1,0};

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        //Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            String[] input = bf.readLine().split(" ");

            int m = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);

            int[] p1 = new int[m];
            int[] p2 = new int[m];

            input = bf.readLine().split(" ");

            for(int i=0; i<m; i++){
                p1[i] = Integer.parseInt(input[i]);
            }

            input = bf.readLine().split(" ");

            for(int i=0; i<m; i++){
                p2[i] = Integer.parseInt(input[i]);
            }

            int[][][] map = new int[a][11][11];

            for(int i=0; i<a; i++){
                input = bf.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);
                int p = Integer.parseInt(input[3]);
                map[i][y][x] = p;
                bcRange(i, x, y, c, p, map);
            }

            Point a1 = new Point(1,1);
            ArrayList<Integer> bcCheck1 = new ArrayList<>();
            int sum1 = 0;

            Point a2 = new Point(10,10);
            ArrayList<Integer> bcCheck2 = new ArrayList<>();
            int sum2 = 0;

            for (int i = 0; i <= m; i++) {

                //두사람이 어떤 bc에 속하는지
                for (int j = 0; j < a; j++) {
                    if(map[j][a1.getY()][a1.getX()]!=0){
                        bcCheck1.add(j);
                    }
                    if(map[j][a2.getY()][a2.getX()]!=0){
                        bcCheck2.add(j);
                    }
                }

                //System.out.println("a1: "+bcCheck1.toString());
                //System.out.println("a2: "+bcCheck2.toString());

                if(bcCheck1.size()==0 && bcCheck2.size()==0){

                } else if(bcCheck1.size()<=1 && bcCheck2.size()<=1){
                    if(bcCheck1.size() == 0){
                        sum2 += map[bcCheck2.get(0)][a2.getY()][a2.getX()];
                    }else if(bcCheck2.size() == 0){
                        sum1 += map[bcCheck1.get(0)][a1.getY()][a1.getX()];
                    }else{
                        if(bcCheck1.get(0).intValue() == bcCheck2.get(0).intValue()){
                            sum1 += map[bcCheck1.get(0)][a1.getY()][a1.getX()]/2;
                            sum2 += map[bcCheck1.get(0)][a1.getY()][a1.getX()]/2;
                        }else{
                            sum1 += map[bcCheck1.get(0)][a1.getY()][a1.getX()];
                            sum2 += map[bcCheck2.get(0)][a2.getY()][a2.getX()];
                        }
                    }

                }else if(bcCheck1.size() > 1 || bcCheck2.size() > 1 ){
                    int max = 0;
                    int ts = 0;
                    int ta1 = 0;
                    int ta2 = 0;
                    if(bcCheck1.size() == 0){

                        for (int j = 0; j < bcCheck2.size(); j++) {
                            ta2 = Math.max(ta2, map[bcCheck2.get(j)][a2.getY()][a2.getX()]);
                        }
                    }else if(bcCheck2.size() == 0){
                        for (int j = 0; j < bcCheck1.size(); j++) {
                            ta1 = Math.max(ta1, map[bcCheck1.get(j)][a1.getY()][a1.getX()]);
                        }
                    }else{
                        for (int j = 0; j < bcCheck1.size(); j++) {
                            for (int k = 0; k < bcCheck2.size(); k++) {
                                if(bcCheck1.get(j)==bcCheck2.get(k)){
                                    ts = map[bcCheck1.get(j)][a1.getY()][a1.getX()];
                                    if(max < ts){
                                        ta1 = map[bcCheck1.get(j)][a1.getY()][a1.getX()]/2;
                                        ta2 = map[bcCheck2.get(k)][a2.getY()][a2.getX()]/2;
                                        max = ts;
                                    }
                                }else{
                                    ts = map[bcCheck1.get(j)][a1.getY()][a1.getX()] + map[bcCheck2.get(k)][a2.getY()][a2.getX()];
                                    if(max < ts){
                                        ta1 = map[bcCheck1.get(j)][a1.getY()][a1.getX()];
                                        ta2 = map[bcCheck2.get(k)][a2.getY()][a2.getX()];
                                        max = ts;
                                    }
                                }

                            }
                        }
                    }


                    sum1 += ta1;
                    sum2 += ta2;

                }
                //System.out.println(i+": sum1: "+sum1+" / sum2: "+sum2);
                if(m==i){
                    break;
                }
                a1.setX(a1.getX()+dx[p1[i]]);
                a1.setY(a1.getY()+dy[p1[i]]);


                a2.setX(a2.getX()+dx[p2[i]]);
                a2.setY(a2.getY()+dy[p2[i]]);

                bcCheck1.clear();
                bcCheck2.clear();

            }

            //System.out.println("sum1: "+sum1+" / sum2: "+sum2);
            System.out.println("#"+test_case+" "+(sum1+sum2));


        }

    }
    public static void bcRange(int a, int x, int y, int c, int p, int[][][] map){

        //middle
        for(int i=1; i<=c; i++){
            if(x+i <= 10){
                map[a][y][x+i]=p;
            }
            if(x-i >= 1){
                map[a][y][x-i]=p;
            }
        }

        //top
        for(int i=1; i<=c; i++){
            if(y-i >= 1){
                map[a][y-i][x]=p;
                for(int j=1; j<=c-i; j++){
                    if(x+j <= 10){
                        map[a][y-i][x+j]=p;
                    }
                    if(x-j >= 1){
                        map[a][y-i][x-j]=p;
                    }
                }
            }
        }


        //bottom
        for(int i=1; i<=c; i++){
            if(y+i <= 10){
                map[a][y+i][x]=p;
                for(int j=1; j<=c-i; j++){
                    if(x+j <= 10){
                        map[a][y+i][x+j]=p;
                    }
                    if(x-j >= 1){
                        map[a][y+i][x-j]=p;
                    }
                }
            }
        }

    }

    public static void print(int[][][] map){
        for(int i=1; i<=10; i++){
            for(int j=1; j<=10; j++){
                System.out.print(" "+map[1][i][j]);
            }
            System.out.println();
        }
    }

}
class Point{
    int x;
    int y;

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}