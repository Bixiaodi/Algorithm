import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Rectangle{
    int x1, y1, x2, y2;
    boolean[] cover;
    public Rectangle()
    {
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
        cover = new boolean[4];
    }
    public Rectangle(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        cover = new boolean[4];
    }

    void setRecover(Rectangle r) {
        if (!cover[0]) {
            int xx = x1, yy = y1;
            cover[0] = xx > r.x1 && xx < r.x2 && yy > r.y1 && yy < r.y2;
        }
        if (!cover[1]) {
            int xx = x1, yy = y2;
            cover[1] = xx > r.x1 && xx < r.x2 && yy > r.y1 && yy < r.y2;
        }
        if (!cover[2]) {
            int xx = x2, yy = y1;
            cover[2] = xx > r.x1 && xx < r.x2 && yy > r.y1 && yy < r.y2;
        }
        if (!cover[3]) {
            int xx = x2, yy = y2;
            cover[3] = xx > r.x1 && xx < r.x2 && yy > r.y1 && yy < r.y2;
        }
    }

    boolean removable() {
        return !cover[0] || !cover[1] || !cover[2] || !cover[3];
    }

    boolean hasArea(Rectangle r) {
        int a = Math.max(r.x1, x1);
        int b = Math.max(r.y1, y1);
        int c = Math.min(r.x2, x2);
        int d = Math.min(r.y2, y2);
        return (a < c) && (b < d);
    }

}
public class Main {



    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("test.txt"));
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt(), h = scanner.nextInt(), n = scanner.nextInt();
        Main solution = new Main();
        int[][] poster = new int[n][4];
        ArrayList<Rectangle> rec = new ArrayList<>(n);
        int ret = 0, pos = 0;
        for (int i = 0; i < n; i++)
        {
            rec.add(new Rectangle());
            for(int j = 0; j < 4; j++)
                poster[i][j] = scanner.nextInt();
            rec.set(i,new Rectangle(poster[i][0], poster[i][1], poster[i][2],poster[i][3]));
            for (int j = 0; j < i; j++) {
                rec.get(j).setRecover(rec.get(i));
            }
        }
        for (int i = 0; i < n; i++) {
            if (rec.get(i).removable()) {

                int cur = 1;
                ArrayList<Rectangle> v = new ArrayList<>();
                v.add(rec.get(i));

                for (int j = i + 1; j < n; j++) {

                    for (int k = 0; k < v.size(); k++) {

                        if (v.get(k).hasArea(rec.get(j))) {
                            v.add(rec.get(j));
                            cur++;
                            break;
                        }

                    }

                }

                if (cur > ret) {
                    ret = cur;
                    pos = i + 1;
                }
            }
        }
        System.out.println(ret + " " + pos);
    }
}