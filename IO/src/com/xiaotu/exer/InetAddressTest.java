package com.xiaotu.exer;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一，网络编程中有两个主要的问题：
 * 1.如何准确的定位网络上的一台或多台主机：定位主机上特定的应用
 * 2.找到主机后如何可靠高效的进行数据传输
 *
 * 二，网络编程中的两个要素：
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层，传输层，网络层，物理+数据链路层）
 *
 * 三，通信要素一：IP和端口号
 * 1.IP：唯一标识Internet 上的计算机（通信实体）
 * 2.在java中使用InetAddress类代表IP
 * 3.IP分类：IPv4 和 Ipv6; 万维网  和 局域网
 * 4.域名：www.baidu.com
 * 5.本地回路地址：127.0.0.1 对应着: localhost
 * 6.如何实例化InetAddress:两个方法：getByName(String host) ,getLocalHost()
 *      两个常用方法：getHostName()  getHostAddress()
 * 7.端口号：正在计算机上运行的进程
 *  要求：不同的进程有不同的端口号
 *  范围：被规定为一个16位的整数 0-65535
 *
 * 8.端口号和IP地址的组合得出一个网络套接字：Socket
 *
 *
 * 网络通信协议
 *
 * TCP 协议 ：
 *  1.使用TCP协议前，须先建立TCP链接 ，形成传输数据通道
 *  2.传输前，采用“三次握手” 方式，点对点通信，是可靠的。
 *  3.TCP协议进行通信的两个应用进程：客户端，服务端。
 *  4.在连接中可进行大数据量的传输
 *  5.传输完毕，需释放已建立的链接 （四次挥手），效率低
 *
 *  UDP 协议：
 *  1.将数据，源，目的封装成数据包，不需要建立链接
 *  2.每个数据报的大小限制在64k以内
 *  3.发送不管对方是否准备好，接收方收到也不确认，故是不可靠的。
 *  4.可以广播发送
 *  5.发送数据结束时，无需释放资源，开销小，速度快。
 *
 *
 *
 * @author 张晓
 * @create 2020-04-27 14:07
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.13");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
            //获取本机的ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName()
            System.out.println(inet2.getHostName());

            //getHostAddress()
            System.out.println(inet2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
