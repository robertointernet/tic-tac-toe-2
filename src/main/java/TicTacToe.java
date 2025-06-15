public class TicTacToe {
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
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].isEmpty() && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                return board[i][0];
            }
        }

        return ""; // No winner
    }
}
