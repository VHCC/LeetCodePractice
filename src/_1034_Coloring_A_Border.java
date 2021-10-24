public class _1034_Coloring_A_Border {

    // DFS = deepest-first search
    public static void main(String[] arg0) {
        int[][] grid = new int[][]{{1, 1, 1,}, {1, 1, 1,}, {1, 1, 1,}};
        int row = 1;
        int col = 1;
        int color = 3;
        System.out.println("=======");
        for (int[] a : grid) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println("");
        }
        System.out.println("=======");

        for (int[] a : colorBorderMy(grid, row, col, color)) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println("");
        }
    }

    static int target;
    static int borderColor;
    static boolean[][] vistiedMy;

    public static int[][] colorBorderMy(int[][] grid, int row, int col, int color) {
        vistiedMy = new boolean[grid.length][grid[0].length];
        target = grid[row][col];
        borderColor = color;
        dfsMy(row, col, grid);
        return grid;
    }


    public static void dfsMy(int i, int j, int[][] grid) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
//            return;
//        }
        grid[i][j] = borderColor;
        vistiedMy[i][j] = true;
        int count = 0;
        System.out.println("--- DFS MY ---, i:> " + i + ", j:> " + j);
        for (int[] a : grid) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println("");
        }
        System.out.println("---");

        if (i - 1 >= 0 && (grid[i - 1][j] == target || vistiedMy[i - 1][j])) { //case up
            System.out.println("up i:> " + (i - 1) + ", j:> " + j + ", visited:> " + vistiedMy[i - 1][j]);
            count++;
            if (!vistiedMy[i - 1][j])
                dfsMy(i - 1, j, grid);
        }
        if (i + 1 < grid.length && (grid[i + 1][j] == target || vistiedMy[i + 1][j])) { //case down
            System.out.println("down i:> " + (i + 1) + ", j:> " + j + ", visited:> " + vistiedMy[i + 1][j]);
            count++;
            if (!vistiedMy[i + 1][j])
                dfsMy(i + 1, j, grid);
        }
        if (j - 1 >= 0 && (grid[i][j - 1] == target || vistiedMy[i][j - 1])) { //case left
            System.out.println("left i:> " + i + ", j:> " + (j - 1) + ", visited:> " + vistiedMy[i][j - 1]);
            count++;
            if (!vistiedMy[i][j - 1])
                dfsMy(i, j - 1, grid);
        }
        if (j + 1 < grid[0].length && (grid[i][j + 1] == target || vistiedMy[i][j + 1])) { //case right
            System.out.println("right i:> " + i + ", j:> " + (j + 1) + ", visited:> " + vistiedMy[i][j + 1]);
            count++;
            if (!vistiedMy[i][j + 1])
                dfsMy(i, j + 1, grid);
        }

        if (count == 4) {
            grid[i][j] = target;
        }
    }


    static boolean visited[][];
    static int col;
    static int colorr;

    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        //basically we will to the given node and appy dfs
        //while applying dfs we will count the number of calls
        //jis bhi node se 4 calls lagi hongi usse change nhi krna hai
        //baki sab ko color se paint krdo
        col = grid[r0][c0];
        colorr = color;
        visited = new boolean[grid.length][grid[0].length];
//        System.out.println(visited[0][0]);
        dfs(r0, c0, grid);
        return grid;
    }

    public static void dfs(int i, int j, int[][] grid) {
        System.out.println("dfs:> i:> " + i + ", j:> " + j);
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        int count = 0;
        visited[i][j] = true;
        grid[i][j] = colorr;
        System.out.println("-DNF-");
        for (int[] a : grid) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println("");
        }
        System.out.println("---");

        if (i + 1 < grid.length && (grid[i + 1][j] == col || visited[i + 1][j])) {
            System.out.println("down, i:> " + (i + 1) + ", j:> " + j + ", visited:> " + visited[i + 1][j]);
            count++;
            if (!visited[i + 1][j])
                dfs(i + 1, j, grid);
        }
        if (i - 1 >= 0 && (grid[i - 1][j] == col || visited[i - 1][j])) {
            System.out.println("up, i:> " + (i - 1) + ", j:> " + j + ", visited:> " + visited[i - 1][j]);
            count++;
            if (!visited[i - 1][j])
                dfs(i - 1, j, grid);
        }
        if (j + 1 < grid[0].length && (grid[i][j + 1] == col || visited[i][j + 1])) {
            System.out.println("right, i:> " + i + ", j:> " + (j + 1) + ", visited:> " + visited[i][j + 1]);
            count++;
            if (!visited[i][j + 1])
                dfs(i, j + 1, grid);
        }
        if (j - 1 >= 0 && (grid[i][j - 1] == col || visited[i][j - 1])) {
            System.out.println("lfet, i:> " + i + ", j:> " + (j - 1) + ", visited:> " + visited[i][j - 1]);
            count++;
            if (!visited[i][j - 1])
                dfs(i, j - 1, grid);
        }
        if (count == 4) {
            System.out.println("D, i:> " + i + ", j:> " + (j));
            grid[i][j] = col;
        }

    }
}
