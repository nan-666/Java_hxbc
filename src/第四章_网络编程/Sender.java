package 第四章_网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) throws IOException {

        System.out.println("发送端");
        DatagramSocket sendSocket = new DatagramSocket();

        //要发送的信息
        byte[] buff = "下课啦".getBytes();
        //目标--收货地址
        InetAddress inetAddress = InetAddress.getByName("192.168.1.103");

        //数据报文
        DatagramPacket packet = new DatagramPacket(buff,buff.length,inetAddress,5200);
        //发送了
        sendSocket.send(packet);

        //关闭
        sendSocket.close();
    }
}
