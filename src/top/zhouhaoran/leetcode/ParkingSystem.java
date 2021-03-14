package top.zhouhaoran.leetcode;

public class ParkingSystem {
    private int[] carContainer;

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(3, 1, 2);
        System.out.println(parkingSystem.addCar(1));
    }

    public ParkingSystem(int big, int medium, int small) {
        carContainer = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return carContainer[carType - 1]-- > 0;
    }
}
