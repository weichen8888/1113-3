public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private String result;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        result = "Game in progress";

        // 初始化空白棋盤
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // 設定棋子位置（row, col 從 0 開始）
    public boolean set(int row, int col) {
        if (gameOver) return false; // 遊戲結束不能再下
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (board[row][col] != ' ') return false; // 該格已有棋子

        board[row][col] = currentPlayer;
        evaluate(); // 每次下完檢查是否結束

        if (!gameOver) { // 輪流換玩家
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        return true;
    }

    // 檢查遊戲是否結束
    private void evaluate() {
        // 檢查行
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                gameOver = true;
                result = board[i][0] + " wins";
                return;
            }
        }

        // 檢查列
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' &&
                board[0][j] == board[1][j] &&
                board[1][j] == board[2][j]) {
                gameOver = true;
                result = board[0][j] + " wins";
                return;
            }
        }

        // 檢查對角線
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            gameOver = true;
            result = board[0][0] + " wins";
            return;
        }

        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            gameOver = true;
            result = board[0][2] + " wins";
            return;
        }

        // 檢查平手
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

    public boolean isGameOver() {
        return gameOver;
    }

    public String getResult() {
        return result;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void printBoard() {
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + "|" + board[i][1] + "|" + board[i][2]);
        }
        System.out.println("-------");
    }
}
