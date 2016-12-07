/**
 * Created by User on 11/30/2016.
 */
public class mpaThread extends Thread {
    public int min = -1;
    public int max = -1;
    public static int line;
    public mpaThread(int min, int max,int x) {
        if (min > max || min < 0 || max < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        this.min = min;
        this.max = max;
    }

    public void run(boolean[][] arr) {
        for(int j = min; j <= max; j++) {
            boolean m = j - 1 >= 0 ? arr[line - 1][j - 1] : false;
            boolean n = arr[line - 1][j];
            boolean o = j + 1 < arr.length ? arr[line- 1][j + 1] : false;
            if ((m && n) || (m && o) || (!m && !n && !o)) {
                arr[line][j] = false;
            } else {
                arr[line][j] = true;
            }
        }
    }
}
