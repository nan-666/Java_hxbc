package 第二章_集合框架;

import java.util.ArrayList;
import java.util.List;

public class C203_02_01_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList();
        list1.add(11);
        list1.add(22);
        System.out.println(list1.toString());
        list1.ensureCapacity(6);
        System.out.println(list1.toString());
    }
}
