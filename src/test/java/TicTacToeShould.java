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
    public void shouldAllowPlayerToMakeAMove() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0, "X");

        String[][] expectedBoard = {
                {"X", "", ""},
                {"", "", ""},
                {"", "", ""}
        };

        assertArrayEquals(expectedBoard, game.getBoard());
    }

}
