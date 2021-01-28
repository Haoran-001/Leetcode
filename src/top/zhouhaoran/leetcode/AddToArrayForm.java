package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm {
    public static void main(String[] args) {
        AddToArrayForm addToArrayForm = new AddToArrayForm();
        int[] A = {9, 7, 7, 1};
        int K = 13;
        System.out.println(addToArrayForm.addToArrayForm(A, K));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int ALen = A.length;
        int i = ALen - 1;
        int cur = K;
        List<Integer> ans = new ArrayList<>();

        while (i >= 0 || cur > 0) {
            if (i >= 0) {
                cur = cur + A[i];
            }
            ans.add(cur % 10);
            cur = cur / 10;
            i--;
        }

        Collections.reverse(ans);

        return ans;
    }
}
