package com.anlythree.wor;

/**
 * 2373. 矩阵中的局部最大值
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 * <p>
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 * <p>
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 * <p>
 * 返回生成的矩阵。
 * 输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * 输出：[[9,9],[8,6]]
 * 解释：原矩阵和生成的矩阵如上图所示。
 * 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
 *
 * @DATE: 2023/3/1
 * @USER: anlythree
 */
public class Plan2373 {
    public int[][] largestLocal(int[][] grid) {
        int size = grid.length;
        int[][] res = new int[size - 2][size - 2];
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 2; j++) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        res[i][j] = Math.max(res[i][j], grid[x][y]);
                    }
                }
            }
        }
        return res;
    }
}
