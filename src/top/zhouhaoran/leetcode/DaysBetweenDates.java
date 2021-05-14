package top.zhouhaoran.leetcode;

import java.util.*;

public class DaysBetweenDates {
    public static void main(String[] args) {
        DaysBetweenDates daysBetweenDates = new DaysBetweenDates();
        // "2020-01-15"
        //"2019-12-31"
        System.out.println(daysBetweenDates.daysBetweenDates("2020-01-15", "2019-12-31"));
    }

    /**
     * 计算两个日期距离1971-01-01的天数, 然后再将两个天数相减取绝对值
     * @param date1
     * @param date2
     * @return int
     */
    public int daysBetweenDates(String date1, String date2) {
        int days1 = getDaysFrom1971(date1);
        int days2 = getDaysFrom1971(date2);

        return Math.abs(days1 - days2);
    }

    private int getDaysFrom1971(String date) {
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);

        int daysOfYear = getDaysOfYear(year - 1);
        int daysOfMonth = getDaysOfMonth(month - 1, year);
        int remainingDays = day - 1;

        int allDays = daysOfYear + daysOfMonth + remainingDays;

        return allDays;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private int getDaysOfYear(int year) {
        int daysOfYear = 0;
        for (int i = year; i >= 1971; i--) {
            if (isLeapYear(i)) {
                daysOfYear += 366;
            } else {
                daysOfYear += 365;
            }
        }

        return daysOfYear;
    }

    private int getDaysOfMonth(int month, int year) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 31); map.put(3, 31); map.put(5, 31); map.put(7, 31); map.put(8, 31); map.put(10, 31); map.put(12, 31);
        map.put(4, 30); map.put(6, 30); map.put(9, 30); map.put(11, 30);

        int daysOfMonth = 0;

        if (isLeapYear(year)) {
            map.put(2, 29);
        } else {
            map.put(2, 28);
        }

        for (int i = month; i >= 1; i--) {
            daysOfMonth += map.get(i);
        }

        return daysOfMonth;
    }
}
