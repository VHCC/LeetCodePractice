import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class _1351_Count_Negative_Numbers_in_a_Sorted_Matrix {

    public static void main(String[] args) {

        Random random = new Random();
        int total = 30;
        int input[] = new int[total];
        for(int i = 0; i < total; i++) {
            input[i] = (int)(Math.random() * total * (random .nextBoolean() ? -1 : 1));
        }

        int b[] = new int[total];
        for(int i = 0; i < total; i++) {
            b[i] = (int)(Math.random() * total * (random .nextBoolean() ? -1 : 1));
        }

        int c[] = new int[total];
        for(int i = 0; i < total; i++) {
            c[i] = (int)(Math.random() * total * (random .nextBoolean() ? -1 : 1));
        }

        System.out.println("Original:> " + Arrays.toString(input));
        System.out.println("Original:> " + Arrays.toString(b));
        System.out.println("Original:> " + Arrays.toString(c));


//        int[][] grid = new int[][]{
//                {4,3,2,-1},
//                {3,2,1,-1},
//                {1,1,-1,-2},
//                {-1,-1,-2,-3}
//        };

        int[][] grid = new int[][]{
                input,
                b,
                c,

        };

        Instant startTime = Instant.now();
        System.out.println(countNegativesStairCase(grid));
//        System.out.println(mySqrtBinary(2147395598));
//        System.out.println(mySqrtBinary(2147395599));
        Instant endTime = Instant.now();
        System.out.println("共耗時：" + Duration.between(startTime, endTime).toMillis() + " 毫秒");

    }


    static public int countNegativesStairCase(int[][] grid) {
        int count = 0;
        int row = 0, col = grid[0].length - 1;

        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {
                count += (grid.length - row);
                col--;
            }
            else row++;
        }

        return count;
    }

    static public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
