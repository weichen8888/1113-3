public class TicTacToe {
    private char[][] board; // 3x3 井字盤
    private char currentPlayer; // 'X' 或 'O'
    private boolean gameOver;
    private String result; // "X wins", "O wins", "Draw", "In Progress"

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        result = "In Progress";

        // 初始化空白棋盤
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * 玩家在指定位置下棋
     * @param row 列 (0~2)
     * @param col 行 (0~2)
     */
    public void set(int row, int col) {
        if (gameOver) {
            throw new IllegalStateException("Game is already over!");
        }
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (board[row][col] != ' ') {
            throw new IllegalArgumentException("Position already taken");
        }

        board[row][col] = currentPlayer;
        evaluate(); // 下完後檢查勝負

        if (!gameOver) {
            // 換下一位玩家
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    /**
     * 檢查勝負或平手狀況
     */
    public void evaluate() {
        // 檢查每一行與每一列
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                endGame(board[i][0]);
                return;
            }

            if (board[0][i] != ' ' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                endGame(board[0][i]);
                return;
            }
        }

        // 檢查對角線
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            endGame(board[0][0]);
            return;
        }

        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            endGame(board[0][2]);
            return;
        }

        // 檢查是否平手
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    full = false;
                    break;
                }
            }
        }

        if (full) {
            gameOver = true;
            result = "Draw";
        }
    }

    private void endGame(char winner) {
        gameOver = true;
        result = winner + " wins";
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getResult() {
        return result;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }
}