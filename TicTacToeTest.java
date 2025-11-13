import org.junit.*;

public class TicTacToeTest {

    @Test
    public void testXWinsRow() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0);
        game.set(1, 0);
        game.set(0, 1);
        game.set(1, 1);
        game.set(0, 2); // X 橫排勝
        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("X wins", game.getResult());
    }

    @Test
    public void testOWinsColumn() {
        TicTacToe game = new TicTacToe();
        game.set(0, 1);
        game.set(0, 0);
        game.set(1, 1);
        game.set(1, 0);
        game.set(2, 2);
        game.set(2, 0); // O 直排勝
        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("O wins", game.getResult());
    }

    @Test
    public void testDiagonalWin() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0);
        game.set(0, 1);
        game.set(1, 1);
        game.set(0, 2);
        game.set(2, 2); // X 對角勝
        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("X wins", game.getResult());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        // 模擬平手盤
        game.set(0,0); game.set(0,1);
        game.set(0,2); game.set(1,1);
        game.set(1,0); game.set(1,2);
        game.set(2,1); game.set(2,0);
        game.set(2,2);
        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("Draw", game.getResult());
    }
}