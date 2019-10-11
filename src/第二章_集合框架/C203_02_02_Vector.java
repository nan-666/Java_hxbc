package 第二章_集合框架;

import java.util.Vector;

public class C203_02_02_Vector {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>(5,3);
        v.add(11);
        v.add(22);
        v.add(33);
        v.add(44);
        v.add(55);
        System.out.println(v.capacity());
        v.add(66);
        System.out.println(v.capacity());
        v.add(77);
        System.out.println(v.capacity());
    }
}
