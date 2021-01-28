package top.zhouhaoran.leetcode;

public class PrintArray {
    public static void main(String[] args) {
        int[]arr = {0, 1, 2, 3, 4, 5, 6, 7};
        PrintArray printArray = new PrintArray();
        printArray.printArray(arr, 2, 7);
        printArray.printReverseArray(arr, 2, 7);
    }

    public void printArray(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public void printReverseArray(int[] arr, int start, int end) {
        int len = arr.length - (end - start);
        int count = 1;
        for (int i = (start - 1 + arr.length) % arr.length; count <= 3; i = (i - 1 + arr.length) % arr.length) {
            System.out.print(arr[i] + "\t");
            count++;
        }
        System.out.println();
    }
}
