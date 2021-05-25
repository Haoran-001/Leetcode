package top.zhouhaoran.leetcode;

import java.util.*;

public class MaxAliveYear {
    public static void main(String[] args) {
        MaxAliveYear maxAliveYear = new MaxAliveYear();
//        int[] birth = {1900, 1901, 1950};
//        int[] death = {1948, 1951, 2000};
        int[] birth = {1927,1954,1903,1928,1956,1929,1929,1928,1958,1902,1953,1912,1923,1937,1915,1942,1964,1954,1924,1936,1963,1950,1904,1931,1951,1953,1922,1970,1986,1947,1911,1965,1913,1920,1947,1962,1903,1905,1978,1974,1950,1921,1929,1901,1925,1929,1951,1944,1945};
        int[] death = {1987,1992,1967,1997,1963,1970,1944,1986,1997,1937,1971,1982,1980,1992,1995,1992,1991,1964,1985,1938,1975,1964,1975,1961,1995,1985,1946,1989,1999,1994,1956,1984,1999,1966,1950,1993,1960,1939,1990,1975,1982,1921,1964,1998,1969,1970,1965,1973,1958};
        System.out.println(maxAliveYear.maxAliveYear2(birth, death));
    }

    public int maxAliveYear(int[] birth, int[] death) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = birth.length;

        for (int i = 0; i < n; i++) {
            for (int start = birth[i]; start <= death[i]; start++) {
                map.put(start, map.getOrDefault(start, 0) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o1.getValue() - o2.getValue();
                } else {
                    return o1.getKey() - o2.getKey();
                }
            }
        });

        int maxValue = list.get(list.size() - 1).getValue();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue() == maxValue) {
                return list.get(i).getKey();
            }
        }

        return -1;
    }

    public int maxAliveYear2(int[] birth, int[] death) {
        int n = birth.length;
        int[] tempArray = new int[101];

        for (int i = 0; i < n; i++) {
            int start = birth[i];
            int end = death[i];

            tempArray[start - 1900] += 1;
            tempArray[end + 1 - 1900] -= 1;
        }

        int maxAliveYear = 1900, maxAliveYearNum = tempArray[0];
        int sum = 0;

        for (int i = 0; i < 101; i++) {
            sum += tempArray[i];
            if (maxAliveYearNum < sum) {
                maxAliveYearNum = sum;
                maxAliveYear = i + 1900;
            }
        }

        return maxAliveYear;
    }
}
