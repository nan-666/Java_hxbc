package 第五章_多线程_C203_05_01_Chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        //接收线程
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        input.read(buff);
                        String msg1 = new String(buff);
                        if (msg1.equals("quit")){
                            break;
                        }
                        System.out.println("客户端："+new String(buff));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        //发送线程
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("服务器:");
                        String msg2 = scan.next();
                        output.write(msg2.getBytes());
                        if (msg2.equals("quit")){
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
