package Labs.Lab6;

public class towerOfHanoi {
    public static void solveHanoi(int n, int source, int dest, int  temp) {
        if (n == 0) {
            //System.out.printf(" Move top ring from %d to %d.\n", source, dest);
            return;
        }
        else {
            solveHanoi(n - 1, source, temp, dest);
            System.out.printf("Move disk rings from peg %d to peg %d\n", source, dest);
            solveHanoi(n -1, temp, dest, source);
        }
    }
    public static  void main(String[] args){
        solveHanoi(4, 1, 3, 2);
    }
}
