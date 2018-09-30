package 원자소멸시뮬레이션;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

class Solution
{
    static double[] dx = {0, 0, -0.5, 0.5};
    static double[] dy = {0.5, -0.5, 0, 0};

    public static void main(String args[]) throws Exception
    {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T=Integer.parseInt(bf.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            LinkedList<Atom> atoms = new LinkedList<>();

            int n = Integer.parseInt(bf.readLine());

            String[] input;
            for (int i = 0; i < n; i++) {
                input = bf.readLine().split(" ");
                atoms.add(new Atom(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));
            }

            ArrayList<Atom> boom = new ArrayList<>();

            Atom a1;
            Atom a2;
            for (int i = 0; i < n; i++) {

                for (int j = i+1; j < n; j++) {

                    if(atoms.get(i).getDir() > atoms.get(j).getDir()){
                        Atom ta1 = atoms.get(i);
                        Atom ta2 = atoms.get(j);

                        atoms.remove(i);
                        atoms.add(i,ta2);
                        atoms.remove(j);
                        atoms.add(j,ta1);
                    }

                    a1 = atoms.get(i);
                    a2 = atoms.get(j);
                    //System.out.println(atoms.toString());
                    if(a1.getDir() == 0){
                        if(a2.getDir() == 1){
                            if(a2.getY() > a1.getY() && a1.getX()==a2.getX()){
                                if(!boom.contains(a1)){
                                    boom.add(a1);
                                }
                                if(!boom.contains(a2)){
                                    boom.add(a2);
                                }
                            }
                        }else if(a2.getDir() == 2){
                            if(a2.getY() > a1.getY() && a2.getX() > a1.getX() && (a2.getX()-a1.getX())==(a2.getY()-a1.getY())){
                                if(!boom.contains(a1)){
                                    boom.add(a1);
                                }
                                if(!boom.contains(a2)){
                                    boom.add(a2);
                                }
                            }
                        }else if(a2.getDir() == 3){
                            if(a2.getY() > a1.getY() && a2.getX() < a1.getX() && (a1.getX()-a2.getX())==(a2.getY()-a1.getY())){
                                if(!boom.contains(a1)){
                                    boom.add(a1);
                                }
                                if(!boom.contains(a2)){
                                    boom.add(a2);
                                }
                            }
                        }
                    }else if(a1.getDir() == 1){
                        if(a2.getDir() == 2){
                            if(a2.getY()<a1.getY() && a2.getX() > a1.getX() && (a1.getY()-a2.getY())==(a2.getX()-a1.getX())){
                                if(!boom.contains(a1)){
                                    boom.add(a1);
                                }
                                if(!boom.contains(a2)){
                                    boom.add(a2);
                                }
                            }
                        }else if(a2.getDir() == 3){
                            if(a1.getY()>a2.getY() && a2.getX() < a1.getX() && (a1.getY()-a2.getY())==(a1.getX()-a2.getX())){
                                if(!boom.contains(a1)){
                                    boom.add(a1);
                                }
                                if(!boom.contains(a2)){
                                    boom.add(a2);
                                }
                            }
                        }
                    }else if(a1.getDir() == 2){
                        if(a2.getDir() == 3){
                            if(a1.getY() == a2.getY() && a1.getX() > a2.getX()){
                                if(!boom.contains(a1)){
                                    boom.add(a1);
                                }
                                if(!boom.contains(a2)){
                                    boom.add(a2);
                                }
                            }
                        }
                    }
                }
            }



            //System.out.println(boom.toString());

            int result = 0;

            for (int i = 0; i < boom.size(); i++) {
                result += boom.get(i).getEnergy();
            }
            System.out.println("#"+test_case+" "+result);
        }
    }

    public static boolean checkLimit(Atom a){
        //true 면 아직
        //false 면 넘어감
        int dir = a.getDir();
        boolean flag = true;

        switch (dir){
            case 0:
                if(a.getY() > 1000){
                    flag = false;
                }
                break;
            case 1:
                if(a.getY() < -1000){
                    flag = false;
                }
                break;
            case 2:
                if(a.getX() < -1000){
                    flag = false;
                }
                break;
            case 3:
                if(a.getX() > 1000){
                    flag = false;
                }
                break;

        }

        return flag;

    }
}
class Atom{
    int x;
    int y;
    int dir;
    int energy;

    @Override
    public String toString() {
        return "Atom{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                ", energy=" + energy +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Atom(int x, int y, int dir, int energy) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.energy = energy;
    }
}
