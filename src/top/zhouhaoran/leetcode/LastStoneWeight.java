package top.zhouhaoran.leetcode;

import java.util.*;

public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight.lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();

        for (int stone : stones) {
            list.add(stone);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        while (list.size() > 1) {
            int num1 = list.get(0);
            int num2 = list.get(1);
            list.remove(0);
            list.remove(0);

            if (num1 > num2) {
                list.add(num1 - num2);
            }

            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        if (list.size() == 1) {
            return list.get(0);
        } else {
            return 0;
        }
    }

    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            if (a > b) {
                pq.offer(a - b);
            }
        }

        if (pq.size() == 1) {
            return pq.poll();
        } else {
            return 0;
        }
    }
}
