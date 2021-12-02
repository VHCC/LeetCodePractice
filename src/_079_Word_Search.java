public class _079_Word_Search {

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {"A", "B", "C", "E"},
//                {"S", "F", "C", "S"},
//                {"A", "D", "E", "E"},
//        };
//        char[][] board = new char[][]{
//                {'C','A','A'},
//                {'A','A','A'},
//                {'B','C','D'},
//        };
//        String word = "AAB";
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String word = "ABCESEEEFSAD";

        System.out.println(exist(board, word));
    }

    static public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean isPossible = false;
        boolean[][] visited;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    visited = new boolean[rows][cols];
                    System.out.println("start:> " + word.charAt(0));
                    visited[row][col] = true;
                    if (word.length() == 1) return true;
                    isPossible = findTargetWord(board, 1, word, row, col, visited);
                    System.out.println("===");
                }
                if (isPossible) return true;

            }
        }
        // traverse all nodes, if there are not exist, return false.
        return isPossible;
    }

    static public boolean findTargetWord(char[][] board, int index, String word, int row, int col, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;
        boolean isPossible = false;
        visited[row][col] = true;
        System.out.println("char:> " + word.charAt(index) + ", index:> " + index + ", row:> " + row + ", col:> " + col);
        // top
        if (row != 0) {
            if (!visited[row - 1][col]) {
                if (board[row - 1][col] == word.charAt(index)) { // 如果找到
                    if (index == (word.length() - 1)) { // 且最後一個
                        return true;
                    } else {
                        isPossible = findTargetWord(board, index + 1, word, row - 1, col, visited);
                    }
                    if (isPossible) {
                        return true;
                    } else {
                        visited[row - 1][col] = false;
                    }
                }
            }
        }
        // left
        if (col != 0) {
            if (!visited[row][col - 1]) {
                if (board[row][col - 1] == word.charAt(index)) { // 如果找到
                    if (index == (word.length() - 1)) { // 且最後一個
                        return true;
                    } else {
                        isPossible = findTargetWord(board, index + 1, word, row, col - 1, visited);
                    }
                    if (isPossible) {
                        return true;
                    } else {
                        visited[row][col - 1] = false;
                    }
                }
            }
        }
        // down
        if (row != (rows - 1)) {
            if (!visited[row + 1][col]) {
                if (board[row + 1][col] == word.charAt(index)) { // 如果找到
                    if (index == (word.length() - 1)) { // 且最後一個
                        return true;
                    } else {
                        isPossible = findTargetWord(board, index + 1, word, row + 1, col, visited);
                    }
                    if (isPossible) {
                        return true;
                    } else {
                        visited[row + 1][col] = false;
                    }
                }
            }
        }
        // right
        if (col != (cols - 1)) {
            if (!visited[row][col + 1]) {
                if (board[row][col + 1] == word.charAt(index)) { // 如果找到
                    if (index == (word.length() - 1)) { // 且最後一個
                        return true;
                    } else {
                        isPossible = findTargetWord(board, index + 1, word, row, col + 1, visited);
                    }
                    if (isPossible) {
                        return true;
                    } else {
                        visited[row][col + 1] = false;
                    }
                }
            }
        }
        return isPossible;
    }

}
