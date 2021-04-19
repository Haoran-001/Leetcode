package top.zhouhaoran.leetcode;

public class MatrixScore {
    public static void main(String[] args) {
        MatrixScore matrixScore = new MatrixScore();
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrixScore.matrixScore2(A));
    }

    /**
     * 我们要保证最后矩阵每一行二进制数累加的和最大, 每一行的第一个元素一定要置为1,
     * 对于从第二列开始的每一列, 要尽可能让1的个数比0多, 具体来说分别统计0和1的个数, 让0和1的个数多的作为新的1的个数
     * @param A
     * @return int
     */
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int ans = 0;
        ans = m * (1 << (n - 1));
        int numOnes = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    numOnes += A[i][j];
                } else if (A[i][0] == 0) {
                    numOnes += (1 - A[i][j]);
                }
            }

            int numZeroes = m - numOnes;

            numOnes = Math.max(numOnes, numZeroes);

            ans += numOnes * (1 << (n - 1 - j));
            numOnes = 0;
        }

        return ans;
    }

    public int matrixScore2(int[][] A) {
        int ans = 0;
        int m = A.length, n = A[0].length;
        int numOnes = 0, numZeroes = 0;
        ans += m * (1 << (n - 1));

        // 按照第一列满足全是1, 对不符合条件的行进行翻转
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                A[i][0] = 1;
                for (int j = 1; j < n; j++) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1;
                    } else if (A[i][j] == 1) {
                        A[i][j] = 0;
                    }
                }
            }
        }

        // 对第二列开始每一行, 统计0和1的个数, 让1的个数为0和1中交大的个数
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 1) {
                    numOnes++;
                } else {
                    numZeroes++;
                }
            }
            numOnes = Math.max(numOnes, numZeroes);
            ans += numOnes * (1 << (n - 1 - j));
            numOnes = 0;
            numZeroes = 0;
        }

        return ans;
    }
}
