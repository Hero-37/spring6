package com.atguigu.spring6.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

// 访问类路径下的资源
public class ClassPathResourceDemo {
    public static void main(String[] args) throws Exception {
        loadAndReadUrlResource("atguigu.txt");
    }

    public static void loadClassPathResource(String path) {
        ClassPathResource classPathResource = new ClassPathResource(path);

        System.out.println(classPathResource.getFilename());
        System.out.println(classPathResource.getDescription());
        try {
            InputStream inputStream = classPathResource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1) {
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadAndReadUrlResource(String path) throws Exception{
        // 创建一个 Resource 对象
        ClassPathResource resource = new ClassPathResource(path);
        // 获取文件名
        System.out.println("resource.getFileName = " + resource.getFilename());
        // 获取文件描述
        System.out.println("resource.getDescription = "+ resource.getDescription());
        //获取文件内容
        InputStream in = resource.getInputStream();
        byte[] b = new byte[1024];
        while(in.read(b)!=-1) {
            System.out.println(new String(b));
        }
    }
}
