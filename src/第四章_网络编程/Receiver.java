package 第四章_网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端");
        DatagramSocket receiveSocket = new DatagramSocket(5200);


        byte[] buff = new byte[1024];
        //创建一个报文 用来接收传过来的报文
        DatagramPacket packet = new DatagramPacket(buff,buff.length);

        //接收
        receiveSocket.receive(packet);
        String ip = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        String str = new String(packet.getData(),0,packet.getLength());
        System.out.println(String.format("%s:%d %s",ip,port,str));

        receiveSocket.close();

    }
}
