package leetCode.easy.arrays;

public class MatrixDiagonalSum {

    // O(n2)
    public int diagonalSum(int[][] mat) {
        int primary = 0, secondary = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    primary += mat[i][j];
                if ((i + j) == (n - 1) && i != j) {
                    secondary += mat[i][j];
                }
            }
        }
        return primary + secondary;
    }

    //O(n)
    public int diagonalSum1(int[][] mat) {
        int primary = 0, secondary = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            primary += mat[i][i];
            if (i != (n - 1 - i))
                secondary += mat[i][n - 1 - i];
        }
        return primary + secondary;
    }

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        MatrixDiagonalSum mds = new MatrixDiagonalSum();
        System.out.println(mds.diagonalSum1(mat));
    }

    /***
     * Given a square matrix mat, return the sum of the matrix diagonals.
     *
     * Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: mat = [[1,2,3],
     *               [4,5,6],
     *               [7,8,9]]
     * Output: 25
     * Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
     * Notice that element mat[1][1] = 5 is counted only once.
     * Example 2:
     *
     * Input: mat = [[1,1,1,1],
     *               [1,1,1,1],
     *               [1,1,1,1],
     *               [1,1,1,1]]
     * Output: 8
     * Example 3:
     *
     * Input: mat = [[5]]
     * Output: 5
     *
     *
     * Constraints:
     *
     * n == mat.length == mat[i].length
     * 1 <= n <= 100
     * 1 <= mat[i][j] <= 100
     *https://leetcode.com/problems/matrix-diagonal-sum/
     */
}
