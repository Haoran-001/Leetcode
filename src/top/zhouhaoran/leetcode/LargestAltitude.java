package top.zhouhaoran.leetcode;

public class LargestAltitude {
    public static void main(String[] args) {
        LargestAltitude largestAltitude = new LargestAltitude();
        int[] gain = {-4,-3,-2,-1,4,3,2};
        int ans = largestAltitude.largestAltitude(gain);
        System.out.println(ans);
    }
    // 0, -5, -4, 1, 1, 6
    public int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length + 1];
        altitude[0] = 0;

        for (int i = 0; i < gain.length; i++) {
            altitude[i + 1] = altitude[i] + gain[i];
        }

        int maxAltitude = Integer.MIN_VALUE;
        for (int i = 0; i < altitude.length; i++) {
            if (maxAltitude < altitude[i]) {
                maxAltitude = altitude[i];
            }
        }

        return maxAltitude;
    }
}
