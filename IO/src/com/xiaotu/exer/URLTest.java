package com.xiaotu.exer;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL 网络编程
 * 1.URL:统一资源定位符，对应着互联网的某一资源位置
 * 2.格式：
 *   http://localhost:8080/examples/%E7%BE%8E%E5%A5%B3.jpg?username=zx&password=123
 *  协议   主机名      端口  资源地址                       参数列表
 *
 * @author 张晓
 * @create 2020-04-27 17:22
 */
public class URLTest {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/%E7%BE%8E%E5%A5%B3.jpg?username=zx&password=123");
        //public String getProtocol()   获取该URL的协议名
        System.out.println(url.getProtocol());
        //public String getHost()       获取该URL的主机名
        System.out.println(url.getHost());
        //public String getPort()       获取该URL的端口号
        System.out.println(url.getPort());
        //public String getPath()       获取该URL的文件路径
        System.out.println(url.getPath());
        //public String getFile()       获取该URL的文件名
        System.out.println(url.getFile());
        //public String getQuery()      获取该URL的查询名
        System.out.println(url.getQuery());

    }

}
