import org.junit.*;

public class TicTacToeTest {

    @Test
    public void testXWinsHorizontally() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0);
        game.set(1, 0);
        game.set(0, 1);
        game.set(1, 1);
        game.set(0, 2);

        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("X wins", game.getResult());
    }

    @Test
    public void testOWinsVertically() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(0, 1); // O
        game.set(1, 0); // X
        game.set(1, 1); // O
        game.set(2, 2); // X
        game.set(2, 1); // O wins

        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("O wins", game.getResult());
    }

    @Test
    public void testXWinsDiagonally() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(0, 1); // O
        game.set(1, 1); // X
        game.set(0, 2); // O
        game.set(2, 2); // X wins

        Assert.assertTrue(game.isGameOver());
        Assert.assertEquals("X wins", game.getResult());
    }

    @Test
    public void testDraw() {
        TicT
