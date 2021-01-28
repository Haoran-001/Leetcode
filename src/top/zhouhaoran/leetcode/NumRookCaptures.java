package top.zhouhaoran.leetcode;

public class NumRookCaptures {
    public static void main(String[] args) {
        NumRookCaptures numRookCaptures = new NumRookCaptures();
        char[][] board = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        int ans = numRookCaptures.numRookCaptures(board);
        System.out.print(ans);
    }

    public int numRookCaptures(char[][] board) {
        int row = 0, col = 0;
        int cnt = 0;
        // 右 下 左 上
        int[] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int step = 0;; step++) {
                int tx = row + step * dx[i];
                int ty = col + step * dy[i];

                if (tx < 0 || tx >=8 || ty <0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }

                if (board[tx][ty] == 'p') {
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }
}
