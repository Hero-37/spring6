package com.atguigu.spring6.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

// 访问系统中的资源
public class FileSystemResourceDemo {

    public static void main(String[] args) {
        // 绝对路径
        loadFileResource("D:\\Code\\IdeaProjects\\Spring6\\atguigu.txt");
        // 相对路径
        loadFileResource("atguigu.txt");
    }

    public static void loadFileResource(String path) {
        FileSystemResource fileSystemResource = new FileSystemResource(path);

        System.out.println(fileSystemResource.getFilename());
        System.out.println(fileSystemResource.getDescription());
        try {
            InputStream inputStream = fileSystemResource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1) {
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
