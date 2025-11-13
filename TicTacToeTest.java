import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {

    @Test
    public void testXWinsRow() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0);
        game.set(1, 0);
        game.set(0, 1);
        game.set(1, 1);
        game.set(0, 2);

        assertTrue(game.isGameOver());
        assertEquals("X wins", game.getResult());
    }

    @Test
    public void testOWinsColumn() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(0, 1); // O
        game.set(1, 0); // X
        game.set(1, 1); // O
        game.set(2, 2); // X
        game.set(2, 1); // O wins

        assertTrue(game.isGameOver());
        assertEquals("O wins", game.getResult());
    }

    @Test
    public void testXWinsDiagonal() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(0, 1); // O
        game.set(1, 1); // X
        game.set(0, 2); // O
        game.set(2, 2); // X wins

        assertTrue(game.isGameOver());
        assertEquals("X wins", game.getResult());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(0, 1); // O
        game.set(0, 2); // X
        game.set(1, 1); // O
        game.set(1, 0); // X
        game.set(1, 2); // O
        game.set(2, 1); // X
        game.set(2, 0); // O
        game.set(2, 2); // X

        assertTrue(game.isGameOver());
        assertEquals("Draw", game.getResult());
    }
}
