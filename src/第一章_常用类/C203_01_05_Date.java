package 第一章_常用类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class C203_01_05_Date {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1.toLocaleString());
        System.out.println(d1.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf.format(d1));
        try {
            Date d2 = sdf.parse("2000年08月01日");
            System.out.println(d2.toLocaleString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        System.out.println(c.toString());
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
    }
}
