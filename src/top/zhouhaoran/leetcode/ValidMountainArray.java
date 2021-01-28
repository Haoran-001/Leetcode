package top.zhouhaoran.leetcode;



public class ValidMountainArray {
    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        int[] arr = {1, 3, 0, 3};
        System.out.println(validMountainArray.validMountainArray(arr));
    }

    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        int midValueIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                midValueIndex = i;
                break;
            }
            if (arr[i] == arr[i+1]) {
                return false;
            }
        }

        if (midValueIndex == 0) {
            return false;
        }

        for (int i = midValueIndex; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i+1]) {
                return false;
            }
        }

        return true;
    }
}
