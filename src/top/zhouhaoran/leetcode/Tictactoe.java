package top.zhouhaoran.leetcode;

public class Tictactoe {
    public static void main(String[] args) {
        Tictactoe tictactoe = new Tictactoe();
        String[] board = {"OOX","XXO","OX "};
        String ans = tictactoe.tictactoe(board);
        System.out.println(ans);
    }

    public String tictactoe(String[] board) {
        int n = board.length;
        int oneRowCountO = 0, oneColCountO = 0, leftDiagonalO = 0, rightDiagonalO = 0;
        int oneRowCountX = 0, oneColCountX = 0, leftDiagonalX = 0, rightDiagonalX = 0;
        boolean empty = false;

        // 判断每一行和每一列
        for (int i = 0; i < n; i++) {

            oneRowCountO = 0;
            oneRowCountX = 0;
            oneColCountO = 0;
            oneColCountX = 0;

            for (int j = 0; j < n; j++) {

                if (board[i].charAt(j) == 'O') {
                    oneRowCountO++;
                } else if (board[i].charAt(j) == 'X'){
                    oneRowCountX++;
                } else {
                    empty = true;
                }

                if (board[j].charAt(i) == 'O') {
                    oneColCountO++;
                } else if (board[j].charAt(i) == 'X'){
                    oneColCountX++;
                } else {
                    empty = true;
                }
            }

            if (oneRowCountO == n) {
                return "O";
            } else if (oneRowCountX == n){
                return "X";
            }

            if (oneColCountO == n) {
                return "O";
            } else if (oneColCountX == n){
                return "X";
            }
        }

        // 判断左右斜对角线
        for (int i = 0; i < n; i++) {
            if (board[i].charAt(i) == 'O') {
                leftDiagonalO++;
            } else if (board[i].charAt(i) == 'X') {
                leftDiagonalX++;
            }
        }

        if (leftDiagonalO == n) {
            return "O";
        } else if (leftDiagonalX == n) {
            return "X";
        }

        for (int i = n - 1; i >= 0; i--) {
            if (board[i].charAt(n - 1 - i) == 'O') {
                rightDiagonalO++;
            } else if (board[i].charAt(n - 1 - i) == 'X') {
                rightDiagonalX++;
            }
        }

        if (rightDiagonalO == n) {
            return "O";
        } else if (rightDiagonalX == n) {
            return "X";
        }

        if (empty) {
            return "Pending";
        } else {
            return "Draw";
        }
    }
}
