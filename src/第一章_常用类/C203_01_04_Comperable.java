package 第一章_常用类;

import java.util.Arrays;

public class C203_01_04_Comperable {
    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point(5,2);
        Point p3 = new Point(2,2);

        Point []pp = {p1,p2,p3};

        Arrays.sort(pp);
        System.out.println(Arrays.toString(pp));
    }


}
