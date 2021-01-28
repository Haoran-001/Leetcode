package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
        os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
        os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }

    String[] stream;
    int ptr = 0;
    public OrderedStream(int n) {
        stream = new String[n];

    }

    public List<String> insert(int id, String value) {
        stream[id - 1] = value;

        List<String> list = new ArrayList<>();

        for (int i = ptr; i < stream.length; i++) {
            if (stream[i] == null) {
                break;
            } else {
                ptr++;
                list.add(stream[i]);
            }
        }

        return list;
    }
}
