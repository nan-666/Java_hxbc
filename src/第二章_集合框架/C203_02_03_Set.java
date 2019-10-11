package 第二章_集合框架;

import java.util.HashSet;
import java.util.Set;

public class C203_02_03_Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>() ;
        Integer i1 = 11;
        Integer i2 = 22;
        set.add(i1);
        set.add(i2);
        set.add(i1);
        System.out.println(set.toString());

    }
}
