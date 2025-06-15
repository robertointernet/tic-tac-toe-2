import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeShould {

    @Test
    public void shouldStartWithEmptyBoard() {
        TicTacToe game = new TicTacToe();
        String[][] expectedBoard = {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    public void shouldAllowPlayerToMakeMove() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0, "X");

        String[][] expectedBoard = {
                {"X", "", ""},
                {"", "", ""},
                {"", "", ""}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    public void shouldNotAllowOverwriteMove() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0, "X");
        game.play(0, 0, "Y");
        String[][] expectedBoard = {
                {"X", "", ""},
                {"", "", ""},
                {"", "", ""}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    public void shouldCheckForHorizontalWin() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0, "X");
        game.play(0, 1, "X");
        game.play(0, 2, "X");

        String[][] expectedBoard = {
                {"X", "X", "X"},
                {"", "", ""},
                {"", "", ""}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
        assertEquals("X", game.checkWinner());
    }

    @Test
    public void shouldCheckForVerticalWin() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0, "X");
        game.play(1, 0, "X");
        game.play(2, 0, "X");

        String[][] expectedBoard = {
                {"X", "", ""},
                {"X", "", ""},
                {"X", "", ""}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
        assertEquals("X", game.checkWinner());
    }

    @Test
    public void shouldCheckForDiagonalWin() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0, "X");
        game.play(1, 1, "X");
        game.play(2, 2, "X");

        String[][] expectedBoard = {
                {"X", "", ""},
                {"", "X", ""},
                {"", "", "X"}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
        assertEquals("X", game.checkWinner());
    }
}
