package top.zhouhaoran.leetcode;

import java.util.*;

public class ReformatDate {
    public static void main(String[] args) {
        ReformatDate reformatDate = new ReformatDate();
        String date = "20th Oct 2052";
        System.out.println(reformatDate.reformatDate(date));
    }

    public String reformatDate(String date) {
        String[] dateArray = date.split(" ");
        String year = dateArray[2];
        String month = getMonth(dateArray[1]);
        String day = getDay(dateArray[0]);

        return year + "-" + month + "-" + day;
    }

    private String getMonth(String month) {
        Map<String, String> monthMap = new HashMap() {{
            put("Jan", "01");put("Feb", "02");put("Mar", "03");put("Apr", "04");put("May", "05");put("Jun", "06");
            put("Jul", "07");put("Aug", "08");put("Sep", "09");put("Oct", "10");put("Nov", "11");put("Dec", "12");
        }};

        return monthMap.get(month);
    }

    private String getDay(String day) {
        Map<String, String> dayMap = new HashMap() {{
            put("1st", "01");put("2nd", "02");put("3rd", "03");put("4th", "04");put("5th", "05");put("6th", "06");
            put("7th", "07");put("8th", "08");put("9th", "09");put("10th", "10");put("11th", "11");put("12th", "12");
            put("13th", "13");put("14th", "14");put("15th", "15");put("16th", "16");put("17th", "17");put("18th", "18");
            put("19th", "19");put("20th", "20");put("21st", "21");put("22nd", "22");put("23rd", "23");put("24th", "24");
            put("25th", "25");put("26th", "26");put("27th", "27");put("28th", "28");put("29th", "29");put("30th", "30");
            put("31st", "31");
        }};

        return dayMap.get(day);
    }
}
