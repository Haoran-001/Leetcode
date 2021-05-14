package top.zhouhaoran.leetcode;

import java.util.*;

public class FindRestaurant {
    public static void main(String[] args) {
        FindRestaurant findRestaurant = new FindRestaurant();
        // ["Shogun","Tapioca Express","Burger King","KFC"]
        //["KFC","Shogun","Burger King"]
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Shogun","Burger King"};
        String[] ans = findRestaurant.findRestaurant2(list1, list2);
        System.out.println(Arrays.toString(ans));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        int minIndex = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j < minIndex) {
                        minIndex = i + j;
                        ans.clear();
                        ans.add(list1[i]);
                    } else if (i + j == minIndex) {
                        ans.add(list1[i]);
                    }
                }
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    public String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minIndex = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (i + map.get(list2[i]) < minIndex) {
                    minIndex = i + map.get(list2[i]);
                    ans.clear();
                    ans.add(list2[i]);
                } else if (i + map.get(list2[i]) == minIndex) {
                    ans.add(list2[i]);
                }
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}