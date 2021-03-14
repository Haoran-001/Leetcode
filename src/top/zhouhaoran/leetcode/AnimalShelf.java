package top.zhouhaoran.leetcode;

import java.util.*;

public class AnimalShelf {
    public static void main(String[] args) {
        AnimalShelf animalShelf = new AnimalShelf();

        animalShelf.enqueue(new int[]{0, 0});
        animalShelf.enqueue(new int[]{1, 0});

        System.out.println(Arrays.toString(animalShelf.dequeueAny()));
        System.out.println(Arrays.toString(animalShelf.dequeueDog()));

    }

    private LinkedList<int[]> queueOfCat, queueOfDog;
    public AnimalShelf() {
        queueOfCat = new LinkedList<>();
        queueOfDog = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            queueOfCat.addLast(animal);
        } else if (animal[1] == 1) {
            queueOfDog.addLast(animal);
        }
    }

    public int[] dequeueAny() {
        if (queueOfCat.isEmpty() && queueOfDog.isEmpty()) {
            return new int[]{-1, -1};
        }

        int[] headCat, headDog;

        if (!queueOfCat.isEmpty()) {
            headCat = queueOfCat.getFirst();
        } else {
            return queueOfDog.removeFirst();
        }

        if (!queueOfDog.isEmpty()) {
            headDog = queueOfDog.getFirst();
        } else {
            return queueOfCat.removeFirst();
        }

        if (headCat[0] <= headDog[0]) {
            return queueOfCat.removeFirst();
        } else {
            return queueOfDog.removeFirst();
        }
    }

    public int[] dequeueDog() {
        if (!queueOfDog.isEmpty()) {
            return queueOfDog.removeFirst();
        } else {
            return new int[]{-1, -1};
        }
    }

    public int[] dequeueCat() {
        if (!queueOfCat.isEmpty()) {
            return queueOfCat.removeFirst();
        } else {
            return new int[]{-1, -1};
        }
    }
}