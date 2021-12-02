import java.util.Arrays;

public class _853_Car_Fleet {

    // 釐清問題就很困難了
    //
    public static void main(String[] args) {
        int destinatino = 12;
        int[] position = new int[]{10, 8, 0, 5, 3};
        int[] speed___ = new int[]{2, 4, 1, 1, 3};


        System.out.println(carFleet(destinatino, position, speed___));
    }

    static public int carFleet(int target, int[] position, int[] speed) {

        if (position.length == 0) return 0;
        int fleet = 0;
        int[][] ps = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            ps[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(ps, (a, b) -> a[0] - b[0]);    //sort by pos

        for (int[] p : ps) {
            System.out.println("p:> " + p[0] + ", speed:> " + p[1]);
        }

        float pt = 0;    //time taken by previous car
        for (int i = ps.length - 1; i >= 0; i--) {
            float ti = 1.0f * (target - ps[i][0]) / ps[i][1];   //time taken
            System.out.println("ps:> " + ps[i][0] + ", ti:> " + ti);
            if (ti > pt) {
                fleet++;
                pt = ti;
            }
        }
        return fleet;
    }
}
