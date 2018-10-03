package 원자소멸시뮬레이션;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{

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
                atoms.add(new Atom(i,Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));
            }


            ArrayList<Queue<Atom>> q = new ArrayList<>();
            for (int i = 0; i <= 4040; i++) {
                q.add(new LinkedList<>());
            }

            atoms.sort(new Comparator<Atom>() {

                @Override
                public int compare(Atom o1, Atom o2) {
                    // TODO Auto-generated method stub
                    if(o1.getDir()<o2.getDir()) {
                        return -1;
                    }else if(o1.getDir()>o2.getDir()) {
                        return 1;
                    }else {
                        return 0;
                    }

                }

            });
            //System.out.println(atoms.toString());
            Atom a1;
            Atom a2;
            for (int i = 0; i < n-1; i++) {
                double min = 99999.0;
                Atom minA = null;

                for (int j = i+1; j < n; j++) {

                    a1 = atoms.get(i);
                    a2 = atoms.get(j);

                    if(a1.getDir() == 0){
                        if(a2.getDir() == 1){
                            if(a2.getY() > a1.getY() && a1.getX()==a2.getX()){
                                q.get(a2.getY() - a1.getY()).offer(a1);
                                q.get(a2.getY() - a1.getY()).offer(a2);
                            }
                        }else if(a2.getDir() == 2){
                            if(a2.getY() > a1.getY() && a2.getX() > a1.getX() && (a2.getX()-a1.getX())==(a2.getY()-a1.getY())){

                                q.get((a2.getX()-a1.getX())+(a2.getY()-a1.getY())).offer(a1);
                                q.get((a2.getX()-a1.getX())+(a2.getY()-a1.getY())).offer(a2);

                            }
                        }else if(a2.getDir() == 3){
                            if(a2.getY() > a1.getY() && a2.getX() < a1.getX() && (a1.getX()-a2.getX())==(a2.getY()-a1.getY())){
                                q.get((a1.getX()-a2.getX())+(a2.getY()-a1.getY())).offer(a1);
                                q.get((a1.getX()-a2.getX())+(a2.getY()-a1.getY())).offer(a2);
                            }
                        }
                    }else if(a1.getDir() == 1){
                        if(a2.getDir() == 2){
                            if(a2.getY()<a1.getY() && a2.getX() > a1.getX() && (a1.getY()-a2.getY())==(a2.getX()-a1.getX())){
                                q.get((a1.getY()-a2.getY())+(a2.getX()-a1.getX())).offer(a1);
                                q.get((a1.getY()-a2.getY())+(a2.getX()-a1.getX())).offer(a2);
                            }
                        }else if(a2.getDir() == 3){
                            if(a1.getY()>a2.getY() && a2.getX() < a1.getX() && (a1.getY()-a2.getY())==(a1.getX()-a2.getX())){

                                q.get((a1.getY()-a2.getY())+(a1.getX()-a2.getX())).offer(a1);
                                q.get((a1.getY()-a2.getY())+(a1.getX()-a2.getX())).offer(a2);

                            }
                        }
                    }else if(a1.getDir() == 2){
                        if(a2.getDir() == 3){
                            if(a1.getY() == a2.getY() && a1.getX() > a2.getX()){
                                q.get(a1.getX() - a2.getX()).offer(a1);
                                q.get(a1.getX() - a2.getX()).offer(a2);
                            }
                        }
                    }

                }
            }

            int[] check = new int[atoms.size()];
            for (int i = 0; i < check.length; i++) {
                check[i]=-1;
            }

            int result = 0;
            for (int i = 0; i < q.size(); i++) {
                while (!q.get(i).isEmpty()){
                    Atom atom1 = q.get(i).poll();
                    Atom atom2 = q.get(i).poll();

                    if(check[atom1.getN()]!=-1 && check[atom2.getN()]!=-1){
                        continue;
                    }
                    if(check[atom1.getN()]==i && check[atom2.getN()]==-1){
                        check[atom2.getN()]=i;
                        result += atom2.getEnergy();
                    }else if(check[atom1.getN()]==-1 && check[atom2.getN()]==i){
                        check[atom1.getN()]=i;
                        result += atom1.getEnergy();
                    }else if(check[atom1.getN()]==-1 && check[atom2.getN()]==-1){
                        check[atom1.getN()] = i;
                        check[atom2.getN()] = i;
                        result += (atom1.getEnergy()+atom2.getEnergy());
                    }


                }
            }


            //System.out.println(boom.toString());


            System.out.println("#"+test_case+" "+result);
        }
    }

}
class Atom{
    int n;
    int x;
    int y;
    int dir;
    int energy;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
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

    public Atom(int n, int x, int y, int dir, int energy) {
        this.n = n;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.energy = energy;
    }
}
