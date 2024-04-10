package com.atguigu.bean;

import com.atguigu.annotation.Bean;
import com.atguigu.annotation.Di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext{

    // 创建 map 结合，存放 bean 对象
    private Map<Class, Object> beanFactory = new HashMap<>();

    // 基本路径, 即 包名之前的路径
    private static String rootPath;

    // 返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 有参构造, 设置包扫描规则
    public AnnotationApplicationContext(String basePackage) {

        try {
            // 1. 把包路径中的 '.' 替换成 '\'
            String packagePath = basePackage.replaceAll("\\.", "\\\\");

            // 2. 获取包的绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
                                                          .getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                // 获取包前面的路径部分，截取字符串
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                // 3. 包扫描
                this.loadBean(new File(filePath));
            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        this.loadDi();
    }

    /**
     * 注入
     */
    private void loadDi() {
        // 实例化对象在 beanFactory 的 map 集合里面
        // 1. 遍历 beanFactory 的 map 集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();

        for (Map.Entry<Class, Object> entry : entries) {
            // 2. 获取 map 集合的每个对象，包括属性
            Object obj = entry.getValue();

            // 获取对象 class
            Class<?> clazz = obj.getClass();

            // 3. 遍历得到每个对象的属性
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                // 4. 判断属性上面是否有 Di 注解
                Di annotation = field.getAnnotation(Di.class);

                if (annotation != null) {
                    field.setAccessible(true);
                    // 5. 如果有 Di 注解，把对象进行注入
                    try {
                        field.set(obj, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }

    /**
     * 包扫描过程，实例化
     * @param file
     */
    private void loadBean(File file) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 判断当前是否是文件夹
        if (file.isDirectory()) {
            // 2. 获取文件夹里面的所有内容
            File[] childFiles = file.listFiles();

            // 3. 判断文件夹里面为空，直接返回
            if (childFiles == null || childFiles.length == 0) {
                return;
            }

            // 4. 若文件夹里面不为空，遍历文件夹的所有内容
            for (File childFile : childFiles) {
                // 4.1 得到每个 file 对象，继续判断
                // 4.2 file对象是文件夹，递归
                if (childFile.isDirectory()) {
                    this.loadBean(childFile);
                } else {
                    // 4.2 file 对象是文件，得到 包路径+类名称部分(字符串截取)
                    String pathWithClass = childFile.getAbsolutePath().substring(rootPath.length() - 1);

                    // 4.3 判断当前文件类型是否是 .class
                    if (pathWithClass.endsWith(".class")) {
                        // 4.4 如果是 .class, 把路径中的 '\' 替换成 '.', 去掉最后的 .class
                        String fullName = pathWithClass.replaceAll("\\\\", "\\.")
                                                      .replace(".class", "");

                        // 4.5 判断类上面是否有注解, 如果有，则通过反射进行实例化
                        // 4.5.1 获取类的 class
                        Class<?> clazz = Class.forName(fullName);
                        // 4.5.2 判断不是接口
                        if (!clazz.isInterface()) {
                            // 4.5.2 判断类上面是否有注解
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                // 4.5.3 实例化
                                Object instance = clazz.getConstructor().newInstance();
                                // 4.6 对象实例化之后, 放到 map 集合 beanFactory
                                // 4.6.1 当前类如果有接口，让接口class 作为 map 的key
                                if (clazz.getInterfaces().length > 0) {
                                    beanFactory.put(clazz.getInterfaces()[0], instance);
                                } else {
                                    beanFactory.put(clazz, instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
