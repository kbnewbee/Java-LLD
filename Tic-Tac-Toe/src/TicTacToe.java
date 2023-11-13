import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private int curPlayer;

    public TicTacToe() {
        board = new char[3][3];

        for (char[] r : board) {
            Arrays.fill(r, ' ');
        }

        curPlayer = 1;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------------");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }

        return true;
    }

    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' '
                    && board[i][0] == board[i][1]
                    && board[i][0] == board[i][2])
                return true; //row win

            if (board[0][1] != ' '
                    && board[0][i] == board[1][i]
                    && board[0][i] == board[2][i])
                return true; //col win
        }

        if (board[0][0] != ' '
                && board[1][1] == board[0][0]
                && board[2][2] == board[0][0])
            return true; //diag win


        if (board[0][2] != ' '
                && board[1][1] == board[0][2]
                && board[2][0] == board[0][2])
            return true; //diag win

        return false;
    }

    public boolean makeMove(int r, int c) {
        if (r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c] == ' ') {
            board[r][c] = (curPlayer == 1) ? 'X' : 'O';
            curPlayer = 3 - curPlayer;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        int r, c;

        while (!game.isBoardFull() && !game.checkWinner()) {
            game.printBoard();

            r = sc.nextInt();
            c = sc.nextInt();

            if (game.makeMove(r,c))
                System.out.println("valid move");
            else
                System.out.println("invalid move, try again");
        }

        game.printBoard();

        if(game.checkWinner())
            System.out.println(game.curPlayer + " wins !!");
        else
            System.out.println("draw !!");

        sc.close();
    }


}
