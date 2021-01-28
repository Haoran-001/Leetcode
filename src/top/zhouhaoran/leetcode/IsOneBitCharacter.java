package top.zhouhaoran.leetcode;

public class IsOneBitCharacter {
    public static void main(String[] args) {
        IsOneBitCharacter isOneBitCharacter = new IsOneBitCharacter();
        int[] bits = {1, 0, 0};
        boolean b = isOneBitCharacter.isOneBitCharacter(bits);
        System.out.println(b);
    }

    public boolean isOneBitCharacter(int[] bits) {
        int i;
        for (i = 0; i < bits.length - 1;) {
            if (bits[i] == 0) {
                i = i + 1;
            } else if (bits[i] == 1) {
                i = i + 2;
            }
        }

        return i == bits.length - 1;
    }

    /**  110
     * 贪心算法思想, 数组最后一个元素必为0, 则从倒数第二个元素开始向前遍历
     * 若数组中只有一个0, 即最后一个元素, 则返回数组第一个元素到倒数第二个元素的长度, 即所有1的个数,
     * 奇数则意味着最后一个元素和倒数第二个元素构成一个2比特字符, 偶数则意味着最后一个元素单独构成一个1比特字符
     * 若数组中不止有一个0, 则统计倒数第二个0和最后一个0之间1的个数,
     * 若为奇数, 则最后一个元素和倒数第二个元素构成一个2比特字符, 若为偶数, 则最后一个元素单独构成一个1比特字符
     * @param bits
     * @return boolean
     */
    public boolean isOneBitCharacter2(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] == 1) i--;
        int ans = (bits.length - 2 - i) % 2;

        return ans == 0;
    }
}
