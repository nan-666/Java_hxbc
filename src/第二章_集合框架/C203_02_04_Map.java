package 第二章_集合框架;

import java.util.HashMap;
import java.util.Map;

public class C203_02_04_Map {
    public static void main(String[] args) {
        Wine w1 = new Wine("茅台",2000,400);
        Wine w2 = new Wine("五粮液",1200,300);

        Map<String,Wine> bartender = new HashMap<>();
        bartender.put("张三",w1);
        bartender.put("李四",w2);

        Wine w = bartender.get("李四");
        System.out.println(w.toString());
    }

}
