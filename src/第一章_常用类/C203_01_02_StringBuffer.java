package 第一章_常用类;

public class C203_01_02_StringBuffer {
    public static void main(String[] args) {
        String s1 = "abc123";
        f1(s1);
        System.out.println(s1);

        StringBuffer s2 = new StringBuffer("abc123");
        f2(s2);
        System.out.println(s2);
    }

    private static void f2(StringBuffer s2) {
        s2.deleteCharAt(s2.length()-1);
    }

    private static void f1(String str) {
        str.replace("3","");
    }
}
