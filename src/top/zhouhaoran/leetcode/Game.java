package top.zhouhaoran.leetcode;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        int[] guess = new int[]{1, 2, 3};
        int[] answer = new int[]{1, 2, 3};
        System.out.println(game.game(guess, answer));
    }

    public int game(int[] guess, int[] answer) {
        int count = 0;

        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }

        return count;
    }
}
