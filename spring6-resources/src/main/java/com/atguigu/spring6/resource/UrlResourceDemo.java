package com.atguigu.spring6.resource;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

// 演示 urlResource 访问网络资源
public class UrlResourceDemo {

    public static void main(String[] args) {
        // http 前缀
        // loadUrlResource("http://www.baidu.com");
        loadUrlResource("file:atguigu.txt");
    }

    /**
     * 访问前缀 http、file
     * @param path
     */
    public static void loadUrlResource(String path) {
        try {
            // 创建 Resource 实现类的对象 UrlResource
            UrlResource urlResource = new UrlResource(path);

            // 获取资源信息
            System.out.println(urlResource.getFilename());
            System.out.println(urlResource.getURI());
            System.out.println(urlResource.getDescription());
            System.out.println(urlResource.getInputStream().read());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
