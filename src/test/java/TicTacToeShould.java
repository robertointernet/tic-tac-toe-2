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
        game.play(0, 0);

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
        game.play(0, 0);
        game.play(0, 0);
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
        game.play(0, 0);
        game.play(1, 0);
        game.play(0, 1);
        game.play(1, 1);
        game.play(0, 2);

        String[][] expectedBoard = {
                {"X", "X", "X"},
                {"O", "O", ""},
                {"", "", ""}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
        assertEquals("X", game.checkWinner());
    }

    @Test
    public void shouldCheckForVerticalWin() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0);
        game.play(0, 1);
        game.play(1, 0);
        game.play(0, 2);
        game.play(2, 0);

        String[][] expectedBoard = {
                {"X", "O", "O"},
                {"X", "", ""},
                {"X", "", ""}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
        assertEquals("X", game.checkWinner());
    }

    @Test
    public void shouldCheckForDiagonalWin() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0);
        game.play(0, 1);
        game.play(1, 1);
        game.play(0, 2);
        game.play(2, 2);

        String[][] expectedBoard = {
                {"X", "O", "O"},
                {"", "X", ""},
                {"", "", "X"}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
        assertEquals("X", game.checkWinner());
    }

    @Test
    public void shouldCheckForTie() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0);
        game.play(0, 1);
        game.play(0, 2);
        game.play(1, 1);
        game.play(1, 0);
        game.play(1, 2);

        game.play(2, 1);
        game.play(2, 0);
        game.play(2, 2);

        String[][] expectedBoard = {
                {"X", "O", "X"},
                {"X", "O", "O"},
                {"O", "X", "X"}
        };

        game.printBoard();
        assertArrayEquals(expectedBoard, game.getBoard());
        assertEquals("TIE", game.checkWinner()); // No winner
    }

    @Test
    public void shouldAllowBotPlayerToMakeMove() {
        TicTacToe game = new TicTacToe();
        game.botPlay();
        assertEquals("O", game.getCurrentPlayer());
    }

    @Test
    public void shouldAllowBotPlayAWholeGame() {
        TicTacToe game = new TicTacToe();
        while (game.checkWinner().isEmpty()) {
            game.botPlay();
        }

        assertNotEquals("", game.getCurrentPlayer());
    }

}
