package top.zhouhaoran.leetcode;

public class ModifyString {
    public static void main(String[] args) {
        ModifyString modifyString = new ModifyString();
        System.out.println(modifyString.modifyString("??yw?ipkj?"));
    }

    public String modifyString(String s) {
        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '?') {
                char before = i == 0 ? ' ':charArr[i - 1];
                char after = i == charArr.length - 1 ? ' ' : charArr[i + 1];

                char temp = 'a';
                while (temp == before || temp == after) {
                    temp++;
                }
                charArr[i] = temp;
            }
        }

        return new String(charArr);
    }
}
