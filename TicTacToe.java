public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private String result;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        result = "Game not finished";

        // 初始化棋盤
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public boolean set(int row, int col) {
        if (gameOver || row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ')
            return false;

        board[row][col] = currentPlayer;
        evaluate();

        // 若遊戲尚未結束則切換玩家
        if (!gameOver) currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return true;
    }

    public void evaluate() {
        // 判斷行列
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                endGame(board[i][0] + " wins");
                return;
            }
            if (board[0][i] != ' ' &&
                board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                endGame(board[0][i] + " wins");
                return;
            }
        }

        // 判斷對角線
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            endGame(board[0][0] + " wins");
            return;
        }

        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            endGame(board[0][2] + " wins");
            return;
        }

        // 判斷平手
        boolean draw = true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    draw = false;

        if (draw) endGame("Draw");
    }

    private void endGame(String r) {
        gameOver = true;
        result = r;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getResult() {
        return result;
    }

    public char[][] getBoard() {
        return board;
    }
}


