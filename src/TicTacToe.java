
import java.util.InputMismatchException;
import java.util.Scanner;


public class TicTacToe {
    Scanner scanner = new Scanner(System.in);
    Helper helper = new Helper();
    private int size = 3;
    private String[][] board;
    private int xCounter = 0;
    private int oCounter = 0;
    private String symbol;
    private int row;
    private int column;
    private boolean playing;

    TicTacToe() {

    }

    public void play() {
        setUp();
        askCord();
    }

    private void setUp() {
        setPlaying(true);
        int counter = 0;
        setSize(3);
        board = new String[getSize()][getSize()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " ";
            }
        }
        try {
            System.out.print("Enter the cells: ");
            String[] cells = scanner.nextLine().toUpperCase().replaceAll("_", " ").split("");
            for (int i = 0; i < cells.length; i++) {
                if (cells[i].equals("X")) {
                    xCounter++;
                } else if (cells[i].equals("O")) {
                    oCounter++;
                }
            }
            symbol = xCounter > oCounter ? "O" : "X";
            while (cells.length != 9) {
                System.out.print("Cells need to be a length of nine! Enter the cells: ");
                cells = scanner.nextLine().toUpperCase().replaceAll("_", " ").split("");
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = cells[counter];
                    counter++;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error");
        }
        printBoard();

    }

    private void askCord() {
        while (isPlaying()) {
            System.out.print("Enter the coordinates: ");
            try {
                setRow(scanner.nextInt());
                setColumn(scanner.nextInt());
                helper.checkCord(board, symbol, getRow(), getColumn());
                System.out.println(isPlaying());
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
        printBoard();
        helper.checkWinner(board, symbol);
    }



    private void printBoard() {
        System.out.println("---------");
        for (String[] c : board) {
            System.out.print("| ");
            for (int i = 0; i < board.length; i++) {
                System.out.printf("%s ", c[i]);
            }
            System.out.print("|\n");
        }
        System.out.println("---------");

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
}
