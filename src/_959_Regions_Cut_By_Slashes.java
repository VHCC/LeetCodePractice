public class _959_Regions_Cut_By_Slashes {

    public static void main(String[] args) {
        String[] grid = new String[]{"/\\", "\\/"};

        System.out.println(regionsBySlashes(grid));
    }

    static public int regionsBySlashes(String[] grid) {
        int row = grid[0].length();
        int col = grid[0].length();
        int[][] regins = new int[row * 3][col * 3];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].toCharArray().length; j ++) {
                switch (grid[i].charAt(j)) {
                    case ' ':
                        System.out.println("char :> " + " " + ", i:> " + i + ", j:> " + j);
                        regins[i*3 + 0][j*3 + 0] = 1;
                        regins[i*3 + 0][j*3 + 1] = 1;
                        regins[i*3 + 0][j*3 + 2] = 1;

                        regins[i*3 + 1][j*3 + 0] = 1;
                        regins[i*3 + 1][j*3 + 1] = 1;
                        regins[i*3 + 1][j*3 + 2] = 1;

                        regins[i*3 + 2][j*3 + 0] = 1;
                        regins[i*3 + 2][j*3 + 1] = 1;
                        regins[i*3 + 2][j*3 + 2] = 1;
                        break;
                    case '\\':
                        regins[i*3 + 0][j*3 + 0] = 0;
                        regins[i*3 + 0][j*3 + 1] = 1;
                        regins[i*3 + 0][j*3 + 2] = 1;

                        regins[i*3 + 1][j*3 + 0] = 1;
                        regins[i*3 + 1][j*3 + 1] = 0;
                        regins[i*3 + 1][j*3 + 2] = 1;

                        regins[i*3 + 2][j*3 + 0] = 1;
                        regins[i*3 + 2][j*3 + 1] = 1;
                        regins[i*3 + 2][j*3 + 2] = 0;
                        break;
                    case '/':
                        regins[i*3 + 0][j*3 + 0] = 1;
                        regins[i*3 + 0][j*3 + 1] = 1;
                        regins[i*3 + 0][j*3 + 2] = 0;

                        regins[i*3 + 1][j*3 + 0] = 1;
                        regins[i*3 + 1][j*3 + 1] = 0;
                        regins[i*3 + 1][j*3 + 2] = 1;

                        regins[i*3 + 2][j*3 + 0] = 0;
                        regins[i*3 + 2][j*3 + 1] = 1;
                        regins[i*3 + 2][j*3 + 2] = 1;
                        break;

                }
            }
        }

        for (int[] rows : regins) {
            for (int cols : rows) {
                System.out.print(cols + ", ");
            }
            System.out.println("");
        }
        System.out.println("");

        return findIslands(regins);
    }

    public static int findIslands(int[][] grids) {
        boolean [][] visited = new boolean[grids.length][grids[0].length];
        int islandsCounts = 0;

        for (int i = 0;i < grids.length; i ++) {
            for (int j = 0; j < grids.length; j ++) {
                if (grids[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                checkIslands(grids, i, j, visited);
                islandsCounts ++;
            }
        }
        return islandsCounts;
    }

    public static void checkIslands(int[][] grids, int row, int col, boolean [][] visited) {
//        System.out.println("row:> " + row + ", col:> " + col);
        if (row > grids.length - 1 || col > grids.length - 1 || visited[row][col]) return;
        visited[row][col] = true;
         //top
        if (row != 0) {
            if (grids[row - 1][col] == 1) {
                checkIslands(grids, row - 1, col, visited);
            }
        }
        //left
        if (col != 0) {
            if (grids[row][col - 1] == 1) {
                checkIslands(grids, row, col - 1, visited);
            }
        }
        //down
        if (row != grids.length - 1) {
            if (grids[row + 1][col] == 1) {
                checkIslands(grids, row + 1, col, visited);
            }
        }
        //right
        if (col != grids[0].length - 1) {
            if (grids[row][col + 1] == 1) {
                checkIslands(grids, row, col + 1, visited);
            }
        }
    }
}
