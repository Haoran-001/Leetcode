package top.zhouhaoran.leetcode;

import java.util.*;

public class GetLeastNumbers {
    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] arr = {6, 5, 4, 3, 2, 1}; int k = 2;
        int[] ans = getLeastNumbers.getLeastNumbers3(arr, k);
        System.out.println(Arrays.toString(ans));
        System.out.println(new Date().toString());
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll();
        }

        return ans;
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k > num) {
            randomizedSelected(arr, pos + 1, r, k - num);
        } else {
            randomizedSelected(arr, l, pos - 1, k);
        }
    }

    private int randomizedPartition(int[] arr, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(arr, i, r);
        return partition(arr, l, r);
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= pivot) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);

        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
