import java.util.*;

public class MPA extends Thread{
    public static int TNUM = 10;
    public static boolean[][] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        x= 10;
        long time = System.currentTimeMillis();
        if(x< TNUM){
            TNUM = x;
        }
        arr = new boolean[x][x];
        int seedIndex = x / 2;
        arr[0][seedIndex] = true;
            int integersPerThread = x / TNUM;
        for(int k = 1; k < x; k++){
            mpaThread[] worker = new mpaThread[TNUM];
            int start = 0;
            int end = start + integersPerThread - 1;

            for (int i = 0; i < TNUM; i++) {
                if (i == TNUM - 1) {
                    end = x - 1;
                }
                worker[i].line = k;
                worker[i] = new mpaThread(start, end, x);
                start = end + 1;
                end = start + integersPerThread - 1;
            }
            for (int i = 0; i < TNUM; i++) {
                worker[i].run(arr);
            }
            for (int i = 0; i < TNUM; i++) {
                while (worker[i].isAlive()) {
                    try {
                        worker[i].join();
                    }catch (InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
            }
        }
        print(arr);
        long time2 = System.currentTimeMillis();
        System.out.println("time is: "+(time2-time)+"ms");

    }

    public static void print(boolean[][] arr) {
        for (boolean[] boolArr : arr) {
            for (boolean bool : boolArr) {
                if (bool) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println("");
        }
    }
}
