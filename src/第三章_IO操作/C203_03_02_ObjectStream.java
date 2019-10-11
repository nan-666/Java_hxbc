package 第三章_IO操作;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class C203_03_02_ObjectStream {
    public static void main(String[] args) {
        try{
//        FileOutputStream fos = new FileOutputStream("d:\\object.dat");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        int x = 10000;
//        oos.writeInt(x);
//        oos.close();
            FileInputStream fis = new FileInputStream("d:\\object.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int x = ois.readInt();
            System.out.println(x);
            ois.close();
            fis.close();
        }
        catch (Exception e){

        }
    }
}
