public class TicTacToe {
    public static final int BOARD_LENGTH = 3;

    private String[][] board;

    public TicTacToe() {
        this.board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
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
        // Check rows
        for (int x = 0; x < 3; x++) {
            if (!board[x][0].isEmpty() && board[x][0].equals(board[x][1]) && board[x][0].equals(board[x][2])) {
                return board[x][0];
            }
        }

        // Check columns
        for (int y   = 0; y < 3; y++) {
            if (!board[0][y].isEmpty() && board[0][y].equals(board[1][y]) && board[0][y].equals(board[2][y])) {
                return board[0][y];
            }
        }

        // Check diagonals
        if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            return board[0][0];
        }
        if (!board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            return board[0][2];
        }
        return ""; // No winner
    }
}
