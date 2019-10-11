package 第二章_集合框架;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C203_02_06_Collections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(88);
        list.add(22);
        list.add(77);
        list.add(55);
        list.add(33);

        System.out.println(Collections.max(list));
        Collections.reverse(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }
}
