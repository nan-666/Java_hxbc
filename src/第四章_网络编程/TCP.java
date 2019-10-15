package 第四章_网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP {
    private InputStream input;//输入流
    private OutputStream output;//输出流

    /**
     * 创建服务端
     * @param port 端口号
     */
    public TCP(int port){
//在指定端口创建服务端，等待客户端连接
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端就绪，等待连接！");
            //当有客户端连接到服务器时，即可获取相应的socket，据此和客户端通信
            Socket socket = serverSocket.accept();
            System.out.println("客户端连接成功！");
            InputStream input = socket.getInputStream(); //客户端的输入流
            OutputStream output = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建客户端
     * @param ip 服务端IP地址
     * @param port 服务端端口号
     */
    public TCP(String ip,int port){
        try {
            //连接指定服务器，连接成功后即可获取相应socket，据此可与服务器通信
            Socket socket = new Socket(ip,port);
            output = socket.getOutputStream();
            input =  socket.getInputStream();
            System.out.println("客户端连接服务器成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送数据
     * @param bytes 待发送的数据
     */
    public void send(byte []bytes){
        try {
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收数据
     * @param buff 存放接收数据的缓冲区
     */
    public void receive(byte []buff){
        try {
            input.read(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
