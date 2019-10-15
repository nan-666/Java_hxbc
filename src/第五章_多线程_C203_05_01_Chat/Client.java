package 第五章_多线程_C203_05_01_Chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        //连接指定服务器，连接成功后即可获取相应socket，据此可与服务器通信
        Socket socket = new Socket("192.168.1.119",2000);
        OutputStream out = socket.getOutputStream();
        InputStream inputStream =  socket.getInputStream();
        System.out.println("客户端连接服务器成功");
        Scanner scan = new Scanner(System.in);


        //接收线程
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        //通过输入流，拿到服务器端返回的数据
                        byte[]  bytes = new byte[1024];

                        inputStream.read(bytes);
                        String msg2 = new String(bytes);
                        System.out.println("服务端返回："+new String(bytes));
                        if (msg2.equals("quit")){
                            break;
                        };

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
                        System.out.println("客户端：");
                        String msg = scan.next();
                        out.write(msg.getBytes());
                        if (msg.equals("quit")){
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

     //   socket.close();
    }
}
