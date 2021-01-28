package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountStudents {
    public static void main(String[] args) {
        CountStudents countStudents = new CountStudents();
        int[] students = {1, 1, 1, 0, 0, 1}, sandwiches = {1, 0, 0, 0, 1, 1};
        System.out.println(countStudents.countStudents(students, sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        if (students == null || students.length == 0) {
            return 0;
        }

        if (sandwiches == null || sandwiches.length == 0) {
            return students.length;
        }

        Queue<Integer> stuQueue = new LinkedList<>();
        for (int student : students) {
            stuQueue.offer(student);
        }

        for (int i = 0; i < sandwiches.length; i++) {
            // 若队列为空, 则返回为空
            if (stuQueue.size() == 0) {
                return 0;
            }

            boolean failure = true;
            for (int j = 0; j < stuQueue.size(); j++) {
                int headElem = stuQueue.poll();
                if (headElem == sandwiches[i]) {
                    failure = false;
                    break;
                } else if (headElem != sandwiches[i]) {
                    stuQueue.offer(headElem);
                }
            }

            if (failure) {
                return stuQueue.size();
            }
        }

        return stuQueue.size();
    }
}
