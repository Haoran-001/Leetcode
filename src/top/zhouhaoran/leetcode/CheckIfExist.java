package top.zhouhaoran.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckIfExist {
    public static void main(String[] args) {
        int[] arr = {-10,12,0,-8,15};
        CheckIfExist checkIfExist = new CheckIfExist();
        System.out.println(checkIfExist.checkIfExist2(arr));
    }

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * 2 == arr[j] || arr[j] * 2 == arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfExist2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && map.get(arr[i]) >= 2) {
                return true;
            }
            if (arr[i] != 0 && map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) >= 1) {
                return true;
            }
        }

        return false;
    }
}
