package 第二章_集合框架;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C203_02_05_遍历 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%4d",list.get(i));
        }
        for(int x:list){
            System.out.printf("%4d",x);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int x = iterator.next();
            System.out.printf("%4d",x);
        }

    }
}
