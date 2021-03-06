package top.zhouhaoran.leetcode;

import java.util.*;

public class Permute {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Permute permute = new Permute();
        permute.permute(array, 0);

        for (int[] intArray : permute.permuteAllAns) {
            System.out.println(Arrays.toString(intArray));
        }
    }

    public List<int[]> permuteAllAns = new LinkedList<>();
    public void permute(int[] array, int left) {
        if (left == array.length - 1) {
            permuteAllAns.add(array.clone());
            return;
        }

        for (int i = left; i < array.length; i++) {
            swap(array, i, left);
            permute(array, left + 1);
            swap(array, i, left);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
