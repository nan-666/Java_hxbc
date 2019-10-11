package 第三章_IO操作;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C203_03_01_FileStream {
    public static void main(String[] args) throws IOException {
        try{
            FileOutputStream fos = new FileOutputStream("d:\\text.txt");
            byte []bytes = "hello,file".getBytes();
            fos.write(bytes);
            fos.close();

            FileInputStream fis = new FileInputStream("d:\\text.txt");
            byte []buff = new byte[20];
            int n = fis.read(buff,0,8);
            String str = new String(buff,0,n);
            System.out.println(str);

        }
        catch (IOException e){
            System.out.println("文件异常");
        }
    }
}
