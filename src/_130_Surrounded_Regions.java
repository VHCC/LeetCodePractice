public class _130_Surrounded_Regions {

    public static void main(String[] args) {
//        char[][] input = new char[][]{
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'},
//                {'X', 'O', 'X', 'X'},
//        };

//        char[][] input = new char[][]{
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'},
//                {'X', 'O', 'X', 'X'},
//                {'X', 'O', 'X', 'X'},
//        };
//
//        char[][] input = new char[][]{
//                {'X', 'O', 'X', 'X'},
//                {'O', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X'},
//        };

//        char[][] input = new char[][]{
//                {'X','O','O','X','X','X','O','X','O','O'},
//                {'X','O','X','X','X','X','X','X','X','X'},
//                {'X','X','X','X','O','X','X','X','X','X'},
//                {'X','O','X','X','X','O','X','X','X','O'},
//                {'O','X','X','X','O','X','O','X','O','X'},
//                {'X','X','O','X','X','O','O','X','X','X'},
//                {'O','X','X','O','O','X','O','X','X','O'},
//                {'O','X','X','X','X','X','O','X','X','X'},
//                {'X','O','O','X','X','O','X','X','O','O'},
//                {'X','X','X','O','O','X','O','X','X','O'},
//        };

//        char[][] input = new char[][]{
//            {'O','X','O','O','O','O','O','O','O'},
//            {'O','O','O','X','O','O','O','O','X'},// 1
//            {'O','X','O','X','O','O','O','O','X'},// 2
//            {'O','O','O','O','X','O','O','O','O'},// 3
//            {'X','O','O','O','O','O','O','O','X'},// 4
//            {'X','X','O','O','X','O','X','O','X'},// 5
//            {'O','O','O','X','O','O','O','O','O'},// 6
//            {'O','O','O','X','O','O','O','O','O'},// 7
//            {'O','O','O','O','O','X','X','O','O'},// 8
//        };

//        char[][] input = new char[][]{
//                {'O','X','O','O','O','X'},
//                {'O','O','X','X','X','O'},
//                {'X','X','X','X','X','O'},
//                {'O','O','O','O','X','X'},
//                {'X','X','O','O','X','O'},
//                {'O','O','X','X','X','X'},
//        };


        char[][] input = new char[][]{
                {'X','X','X','X','O','O','X','X','O'},
                {'O','O','O','O','X','X','O','O','X'},
                {'X','O','X','O','O','X','X','O','X'}, // 2
                {'O','O','X','X','X','O','O','O','O'}, // 3
                {'X','O','O','X','X','X','X','X','O'}, // 4
                {'O','O','X','O','X','O','X','O','X'},//5
                {'O','O','O','X','X','O','X','O','X'},//6
                {'O','O','O','X','O','O','O','X','O'},
                {'O','X','O','O','O','X','O','X','O'},
        };
        


//        char[][] input = new char[][]{
//                {'X'}
//        };
        solveMy(input);
    }

    static int m;
    static int n;
    static boolean isContactBoarder = false;

    public static void solveMy(char[][] board) {
        m = board.length;
        n = board[0].length;

        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            System.out.println("========== i =========> " + i);
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                System.out.println("j =========> " + j);
                isContactBoarder = false;
                isContactOBoard(i, j, visited, board);
                if (!isContactBoarder) {
                    changeFlag(i, j, board);
                }

            }
            System.out.println("");
        }

        for (int i = 0; i < m; i++) {
            System.out.print(i + " :> ");
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }

    }

    public static void isContactOBoard(int row, int col, boolean[][] visited, char[][] board) {
        if (board[row][col] == 'X' || visited[row][col]) { // 拜訪過的不再訪
            visited[row][col] = true;
            return;
        }
        System.out.println("board[" + row + "][" + col + "]:> " + board[row][col]);
        if (board[row][col] == 'O') {
            visited[row][col] = true;
            if (row == 0 || col == 0 || row == m - 1 || col == n - 1) {
                isContactBoarder = true;
                System.out.println("board[" + row + "][" + col + "]:> " + board[row][col] + ", isContactBoarder:> " + isContactBoarder);
            }
            if (row != 0) { // top
                isContactOBoard(row - 1, col, visited, board);
            }
            if (col != 0) { // left
                isContactOBoard(row, col - 1, visited, board);
            }
            if (row != m - 1) { // down
                isContactOBoard(row + 1, col, visited, board);
            }
            if (col != n - 1) { // right
                isContactOBoard(row, col + 1, visited, board);
            }

        }
    }

    public static void changeFlag(int row, int col, char[][] board) {
        if (board[row][col] == 'O') {
            System.out.println("board[" + row + "][" + col + "]:> " + board[row][col] + ", :> X");
            board[row][col] = 'X';
            if (row != 0) { // top
                changeFlag(row - 1, col, board);
            }
            if (col != 0) { // left
                changeFlag(row, col - 1, board);
            }
            if (row != m - 1) { // down
                changeFlag(row + 1, col, board);
            }
            if (col != n - 1) { // right
                changeFlag(row, col + 1, board);
            }
        }
    }


//    static int m;
//    static int n;
//    static boolean isAlreadyContact = false;
//    public static void solve(char[][] board) {
//        m = board.length;
//        n = board[0].length;
//
//        boolean visited[][] = new boolean[m][n];
//
//        for (int i = 0; i < m; i++) {
//            System.out.println("========== i =========> " + i);
//            for (int j = 0; j < n; j++) {
//                isAlreadyContact= false;
//                System.out.println("j =========> " + j);
//                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
//                    isFindOBoard(i, j, visited, board, true);
//                } else {
//                    isFindOBoard(i, j, visited, board, false);
//                }
//
//            }
//            System.out.println("");
//        }
//
//        for (int i = 0; i < m; i++) {
//            System.out.println("i =========> " + i);
//            for (int j = 0; j < n; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println("");
//        }
//
//    }

//    public static void isFindOBoard(int row, int col, boolean[][] visited, char[][] board, boolean isFindByBoarder) {
//        if (board[row][col] == 'X' || visited[row][col]) { // 拜訪過的不再訪
//            visited[row][col] = true;
//            return;
//        }
//        if (isFindByBoarder) {
//            isAlreadyContact = true;
//        }
//        System.out.println("board[" + row + "][" + col + "]:> " + board[row][col]);
//        boolean isContactBoarder = false;
//        if (board[row][col] == 'O') {
//            visited[row][col] = true;
//
//            if (row != 0) { // top
//                System.out.println("top");
//                isFindOBoard(row - 1, col, visited, board, row == m - 1 ? true : false);
//            }
//            if (col != 0) { // left
//                System.out.println("left");
//                isFindOBoard(row, col - 1, visited, board, col == n - 1 ? true : false);
//            }
//            if (row != m - 1) { // down
//                System.out.println("down");
//                isFindOBoard(row + 1, col, visited, board, row == 0 ? true : false);
//            }
//            if (col != n - 1) { // right
//                System.out.println("right");
//                isFindOBoard(row, col + 1, visited, board, col == 0 ? true : false);
//            }
//            System.out.println("isAlreadyContact:> " + isAlreadyContact);
//            if (!isAlreadyContact) {
//                System.out.println("board[" + row + "][" + col + "]:> " + board[row][col] + " :> X");
//                board[row][col] = 'X';
//            } else {
//                System.out.println("board[" + row + "][" + col + "]:> " + board[row][col] + " :> O");
//                board[row][col] = 'O';
//                isAlreadyContact = true;
//            }
//            System.out.println("isFindByBoarder:> " + isFindByBoarder);
//            if (isFindByBoarder) {
//                System.out.println("board[" + row + "][" + col + "]:> " + board[row][col] + " :> O");
//                board[row][col] = 'O';
//                isAlreadyContact = true;
//            }
//            if (row == 0 || col == 0 || row == m - 1 || col == n - 1) {
//                System.out.println("board[" + row + "][" + col + "]:> " + board[row][col] + " :> O");
//                board[row][col] = 'O';
//                isAlreadyContact = true;
//                return;
//            }
//        }
//        return;
//    }
}
