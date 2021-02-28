package top.zhouhaoran.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        System.out.println(Arrays.deepToString(floodFill.floodFill2(image, sr, sc, newColor)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor) {
            return image;
        }

        floodFillDFS(image, sr, sc, color, newColor);

        return image;
    }

    private void floodFillDFS(int[][] image, int i, int j, int color, int newColor) {
        if (image[i][j] == color) {
            image[i][j] = newColor;

            if (i >= 1) floodFillDFS(image, i - 1, j ,color, newColor);
            if (i <= image.length - 2) floodFillDFS(image, i + 1, j, color, newColor);
            if (j >= 1) floodFillDFS(image, i, j - 1, color, newColor);
            if (j <= image[0].length - 2) floodFillDFS(image, i, j + 1, color, newColor);
        }
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];

        if (curColor == newColor) {
            return image;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int rows = image.length, cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i], nextY = y + dy[i];
                if (nextX >= 0 && nextX <= rows - 1 && nextY >= 0 && nextY <= cols - 1 && image[nextX][nextY] == curColor) {
                    queue.offer(new int[]{nextX, nextY});
                    image[nextX][nextY] = newColor;
                }
            }
        }

        return image;
    }
}
