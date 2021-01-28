package top.zhouhaoran.leetcode;

public class BusyStudent {
    public static void main(String[] args) {
        BusyStudent busyStudent = new BusyStudent();
        int[] startTime = {4}, endTime = {4};
        int queryTime = 4;
        int res = busyStudent.busyStudent(startTime, endTime, queryTime);
        System.out.println(res);
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }

        return count;
    }
}
