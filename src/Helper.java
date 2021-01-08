public class Helper {

    private boolean notFin = false;
    private boolean draw = false;
    private boolean xWins = false;
    private boolean oWins = false;

    public void checkCord(String[][] board, String symbol, int row, int col) {
        if (row > 3 || row < 1 || col > 3 || col < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else {
            if (!" ".equals(board[row - 1][col - 1])) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                board[row - 1][col - 1] = symbol;

//                System.out.println(ticTacToe.isPlaying());
            }
        }
    }

    public void checkWinner(String[][] board, String s) {
        int drawCounter = 0;
        // Horizontal Check
        for (int j = 0; j < board.length; j++) {
            if (board[j][0].equals(s) && board[j][1].equals(s) && board[j][2].equals(s)) {
                xWins = s.equals("X");
                oWins = s.equals("O");
                break;
            }
        }
        // Vertical Check
        for (int j = 0; j < board.length; j++) {
            if (board[0][j].equals(s) && board[1][j].equals(s) && board[2][j].equals(s)) {
                xWins = s.equals("X");
                oWins = s.equals("O");
                break;
            }
        }


        // Diagonal Check
        if (board[0][0].equals(s) && board[1][1].equals(s) && board[2][2].equals(s) ||
                board[0][2].equals(s) && board[1][1].equals(s) && board[2][0].equals(s)) {
            xWins = s.equals("X");
            oWins = s.equals("O");
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!board[i][j].equals(" ")) {
                    drawCounter++;
                    draw = drawCounter == 9;
                }
            }
        }
        System.out.println(xWins && oWins ? "Impossible" : xWins ? "X wins" : oWins ? "O wins" : draw ? "Draw" : "Game not finished");
    }

}
