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

}
