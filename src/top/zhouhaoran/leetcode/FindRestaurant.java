package top.zhouhaoran.leetcode;

import java.util.*;

public class FindRestaurant {
    public static void main(String[] args) {
        FindRestaurant findRestaurant = new FindRestaurant();
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] ans = findRestaurant.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(ans));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (String s : list1) {
            set.add(s);
        }

        for (String s : list2) {
            if (set.contains(s)) {
                ans.add(s);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}