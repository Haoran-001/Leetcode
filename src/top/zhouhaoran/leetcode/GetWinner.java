package top.zhouhaoran.leetcode;

public class GetWinner {
    public static void main(String[] args) {
        GetWinner getWinner = new GetWinner();
        int[] arr = {1,25,35,42,68,70};
        int k = 1;
        System.out.println(getWinner.getWinner(arr, k));
    }

    /**
     *
     * @param arr
     * @param k
     * @return int
     * 定义两个变量prev和cur分别指向每次要比较的两个元素, prev初始化指向前两个元素中较大的那个
     * 显然, cur再指向第3、4、...、n个元素
     * 每次比较prev和cur哪个更大, 若prev指向的元素更大, 则prev指向不变, 否则让prev指向cur
     * 然后定义一个count变量保证每次将prev所指向的元素+1, 若prev所指向的变量count值为k, 则直接返回prev的值
     * 否则直接把prev指向cur, 然后让count继续置为1
     * 如果一次遍历, 没有找到任何数的count为k, 则将返回最大值
     * 因为最大值转到数组第一个位置时, 其一定永远停留在第一个位置不会改变，其count值最终会等于k
     */
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int prev = 0;
        int count = 1;

        if (arr[0] > arr[1]) {
            prev = arr[0];
        } else {
            prev = arr[1];
        }

        int maxNum = prev;

        for (int i = 2; i < n; i++) {
            if (count == k) {
                return prev;
            }

            int cur = arr[i];
            if (prev > cur) {
                count++;
            } else {
                prev = cur;
                count = 1;
            }

            maxNum = Math.max(maxNum, cur);
        }

        return maxNum;
    }
}
