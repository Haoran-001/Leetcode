package top.zhouhaoran.leetcode;

public class Interpret {
    public static void main(String[] args) {
        Interpret interpret = new Interpret();
        String ans = "G()()()()(al)";
        System.out.println(interpret.interpret(ans));
    }

    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        char[] commandArray = command.toCharArray();

        for (int i = 0; i < commandArray.length;) {
            if (commandArray[i] == 'G') {
                ans.append("G");
                i++;
            } else if (commandArray[i] == '(' && commandArray[i+1] == ')') {
                ans.append('o');
                i = i+2;
            } else if (commandArray[i] == '(' && commandArray[i+1] == 'a') {
                ans.append("al");
                i = i+4;
            }
        }

        return ans.toString();
    }
}
