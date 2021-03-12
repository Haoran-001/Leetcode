package top.zhouhaoran.leetcode;

import java.util.*;

public class RobotSim {
    public static void main(String[] args) {
        RobotSim robotSim = new RobotSim();
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println(robotSim.robotSim(commands, obstacles));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int di = 0;
        int ans = 0;
        int x = 0, y = 0;
        int nx = 0, ny = 1;
        Set<Long> set = new HashSet<>();

        for (int[] obstacle : obstacles) {
            long ox = (long)(obstacle[0]) + 30000;
            long oy = (long)(obstacle[1]) + 30000;
            long code = (ox << 16) + oy;
            set.add(code);
        }

        for (int cmd : commands) {
            if (cmd == -1) {
                di = (di + 1) % 4;
            } else if (cmd == -2) {
                di = (di + 3) % 4;
            } else if (cmd >= 1 && cmd <= 9) {
                for (int k = 0; k < cmd; k++) {
                    int nextX = x + dx[di];
                    int nextY = y + dy[di];

                    long code = (((long)nextX + 30000) << 16) + ((long)nextY + 30000);
                    if (!set.contains(code)) {
                        x = nextX;
                        y = nextY;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }

        return ans;
    }
}
