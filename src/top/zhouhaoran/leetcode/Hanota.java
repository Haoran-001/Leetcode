package top.zhouhaoran.leetcode;

import java.util.*;

public class Hanota {
    public static void main(String[] args) {
        Hanota hanota = new Hanota();
        List<Integer> A = new ArrayList(){{
           add(2); add(1); add(0);
        }};
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        hanota.hanota(A, B, C);
        System.out.println(C);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }

        move(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(n - 1, B, A, C);
    }
}
