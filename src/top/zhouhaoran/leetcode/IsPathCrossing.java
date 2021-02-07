package top.zhouhaoran.leetcode;

import java.util.*;

public class IsPathCrossing {
    public static void main(String[] args) {
        IsPathCrossing isPathCrossing = new IsPathCrossing();
        String path = "NS";
        System.out.println(isPathCrossing.isPathCrossing2(path));
        Set<Point> set = new HashSet<>();
        System.out.println(set.add(new Point(1, 1)));
        System.out.println(set.add(new Point(1, 1)));
    }

    public boolean isPathCrossing(String path) {
        Set<Point> set = new HashSet<>();
        char[] pathArray = path.toCharArray();
        Map<Character, int[]> directions = new HashMap<>() {{
            put('N', new int[]{-1, 0}); put('S', new int[]{1, 0});
            put('E', new int[]{0, 1}); put('W', new int[]{0, -1});
        }};

        int curX = 0, curY = 0;
        set.add(new Point(curX, curY));

        for (char c : pathArray) {
            int[] direction = directions.get(c);
            curX += direction[0];
            curY += direction[1];
            Point point = new Point(curX, curY);
            if (!set.add(point)) {
                return true;
            }
        }

        return false;
    }

    public boolean isPathCrossing2(String path) {
        Set<List<Integer>> set = new HashSet<>();
        char[] pathArray = path.toCharArray();
        Map<Character, int[]> directions = new HashMap<>() {{
            put('N', new int[]{-1, 0}); put('S', new int[]{1, 0});
            put('E', new int[]{0, 1}); put('W', new int[]{0, -1});
        }};

        int curX = 0, curY = 0;
        set.add(Arrays.asList(curX, curY));

        for (char c : pathArray) {
            int[] direction = directions.get(c);
            curX += direction[0];
            curY += direction[1];
            if (!set.add(Arrays.asList(curX, curY))) {
                return true;
            }
        }

        return false;
    }
}

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  Point)) {
            return false;
        }

        Point other = (Point)obj;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return Arrays.asList(x, y).hashCode();
    }
}
