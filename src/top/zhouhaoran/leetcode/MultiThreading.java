package top.zhouhaoran.leetcode;

import java.util.*;
import java.util.concurrent.*;

public class MultiThreading {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    list.add(100);
                }
            });
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
