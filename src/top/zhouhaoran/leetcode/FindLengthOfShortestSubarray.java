package top.zhouhaoran.leetcode;

public class FindLengthOfShortestSubarray {
    public static void main(String[] args) {
        FindLengthOfShortestSubarray findLengthOfShortestSubarray = new FindLengthOfShortestSubarray();
        int[] arr = {1,2,3,10,4,2,3,5};
        int ans = findLengthOfShortestSubarray.findLengthOfShortestSubarray(arr);
        System.out.println(ans);
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;

        // leftEnd作为左边区域 结束位置的指针,rightStart作为右边区域 起始位置的指针
        int leftEnd = 0, rightStart = len - 1;

        // 计算左边区域 能到的最右的位置
        for (; leftEnd < len - 1; leftEnd++){
            if (arr[leftEnd] > arr[leftEnd + 1]) break;
        }

        // 如果最右的位置超过了数组空间，说明整个数组都是递增的，不用删除子数组
        if (leftEnd == len - 1) return 0;

        // 计算右边区域 能到的最左边的位置
        for (; rightStart > 1; rightStart--){
            if (arr[rightStart] < arr[rightStart - 1]) break;
        }

        // 既然leftEnd和rightStart两处位置符合递增的大小关系，那也就是说 左边全部 + 右边全部 是递增的，
        // 那自然也是最长的，所以要删除的也是最短的。例子：{1，4，6，2，3，7，6，7，8，9}
        if (arr[leftEnd] <= arr[rightStart]) return rightStart - leftEnd - 1;

        // 执行到这一步，说明上面的情况都不符合，需要从三个区域中找删除最短的情况

        // 保留当前删除子数组最短的情况，和后面计算里，综合取最短！当前已知能删除的情况有：
        //    ① 保留左边区域， 删除之后的子数组
        //    ② 保留右边区域， 删除之前的子数组       二者取最短的
        int deleteMinLen = Math.min(len - leftEnd - 1, rightStart);

        // 然后计算 左边部分+右边部分 的情况。
        // 到这里因为已经排除了：左边全部 + 右边全部的情况，例子：{1,3,5,8,2,3,5,3,4,5,6,7,8,9}
        // 所以我们现在取最大化的结果，最少删除 左边和右边的长度
        // 最干脆的方式就是从左边区域的第一个起，找每一个元素（下标i）在 右边区域第一个大于等于他的元素（下标j）
        // 取 j - i - 1最小的情况！
        for (int i = 0; i <= leftEnd; i++){
            for (int j = rightStart; j < len; j++){
                if (arr[i] <= arr[j]){ // 第一个大于等于
                    deleteMinLen = Math.min(deleteMinLen, j - i - 1);
                    break;
                }
            }
        }

        return deleteMinLen;
    }
}
