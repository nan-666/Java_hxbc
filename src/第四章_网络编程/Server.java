package 第四章_网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //在指定端口创建服务端，等待客户端连接
        ServerSocket serverSocket = new ServerSocket(2000);
        System.out.println("服务端就绪，等待连接！");
        //当有客户端连接到服务器时，即可获取相应的socket，据此和客户端通信
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功！");
        InputStream input = socket.getInputStream(); //客户端的输入流
        OutputStream output = socket.getOutputStream();

        byte[] buff = new byte[1024];
        input.read(buff);
        System.out.println("客户端："+new String(buff));

        output.write("你好，客户端！".getBytes());
    }
}
