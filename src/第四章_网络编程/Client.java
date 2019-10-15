package 第四章_网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        //连接指定服务器，连接成功后即可获取相应socket，据此可与服务器通信
        Socket socket = new Socket("192.168.1.119",2000);
        OutputStream out = socket.getOutputStream();
        InputStream inputStream =  socket.getInputStream();
        System.out.println("客户端连接服务器成功");

        String str = "你好，服务器！";
        out.write(str.getBytes());
        System.out.println("客户端向服务器发送："+str);

        //通过输入流，拿到服务器端返回的数据
        byte[]  bytes = new byte[1024];
        inputStream.read(bytes);
        System.out.println("服务端返回："+new String(bytes));

        socket.close();
    }
}
