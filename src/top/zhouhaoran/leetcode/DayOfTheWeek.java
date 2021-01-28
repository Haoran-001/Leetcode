package top.zhouhaoran.leetcode;

public class DayOfTheWeek {
    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        System.out.println(dayOfTheWeek.dayOfTheWeek(1, 1, 1971));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        // 1971年1月1日是星期五
        String[] dayOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int daysOfYear = CalculateDaysOfYear(year);
        int daysOfMonth = CalculateDaysOfMonth(month, year);
        int dayOfWeekIndex = (daysOfYear + daysOfMonth + day - 1) % 7;
        dayOfWeekIndex = (dayOfWeekIndex + 5) % 7;

        return dayOfWeek[dayOfWeekIndex];
    }

    private int CalculateDaysOfYear(int year) {
        int sumOfDays = 0;
        for (int i = 1971; i < year; i++) {
            sumOfDays += isLeapYear(i) ? 366 : 365;
        }

        return sumOfDays;
    }

    private int CalculateDaysOfMonth(int month, int year) {
        int sumOfDays = 0;
        for (int i = 1; i < month; i++) {
            sumOfDays +=  daysOfMonth(i, year);
        }

        return sumOfDays;
    }

    private int daysOfMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return isLeapYear(year) ? 29 : 28;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
