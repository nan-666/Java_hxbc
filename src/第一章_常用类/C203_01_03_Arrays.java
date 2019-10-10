package 第一章_常用类;

import java.util.Arrays;

public class C203_01_03_Arrays {
    public static void main(String[] args) {
        int []a = {65,32,89,45,33};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
