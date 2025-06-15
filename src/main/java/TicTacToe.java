import java.util.List;
import java.util.function.Supplier;

public class TicTacToe {
    public static final int DIMENSION = 3;
    public static final String EMPTY = "";

    private final String[][] board;


    public TicTacToe() {
        this.board = new String[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public void play(int x, int y, String player) {
        if(board[x][y].isEmpty()) {
            board[x][y] = player;
        }

    }

    public String checkWinner() {
        List<Supplier<String>> checks = List.of(
                this::checkHorizontalWin,
                this::checkVerticalWin,
                this::checkDiagonalWin,
                this::checkTie
        );

        for (Supplier<String> check : checks) {
            String winner = check.get();
            if (!winner.equals(EMPTY)) {
                return winner;
            }
        }

        return EMPTY;
    }

    private String checkHorizontalWin() {
        for (int x = 0; x < DIMENSION; x++) {
            if (!board[x][0].isEmpty() && board[x][0].equals(board[x][1]) && board[x][0].equals(board[x][2])) {
                return board[x][0];
            }
        }
        return EMPTY;
    }

    private String checkVerticalWin() {
        for (int y = 0; y < DIMENSION; y++) {
            if (!board[0][y].isEmpty() && board[0][y].equals(board[1][y]) && board[0][y].equals(board[2][y])) {
                return board[0][y];
            }
        }
        return EMPTY;
    }

    private String checkDiagonalWin() {
        if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            return board[0][0];
        }

        if (!board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            return board[0][2];
        }
        return EMPTY;
    }

    private String checkTie() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (board[i][j].isEmpty()) {
                    return EMPTY;
                }
            }
        }
        return "TIE";
    }

}
