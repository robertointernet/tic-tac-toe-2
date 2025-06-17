public class Main {
    public static void main(String[] args) throws Exception {
        TicTacToe game = new TicTacToe();
        while (game.checkWinner().isEmpty()) {
            System.out.println("Player " + game.getCurrentPlayer() + " your turn:");
            game.botPlay();
            game.printBoard();
            //Thread.sleep(2000);
            Thread.sleep(2000);
        }

        String winner = game.checkWinner();
        if (winner.equals(TicTacToe.TIE)) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Player " + winner + " wins!");
        }

    }
}
