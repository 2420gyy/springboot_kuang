package com.chen.尚硅谷.反射;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import static com.google.common.io.Resources.getResource;

/**
 * @author chenchen
 * @date 2021-12-12 19:54
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        // 了解
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);

        URL url = getResource(System.getProperty("user.dir")+"/src/jdbc1.properties");
        System.out.println(url);


    }

    // 掌握 Properties：用来读取配置文件。
    @Test
    public void test2() throws Exception{

        System.out.println(System.getProperty("user.dir")+"/src/main/java/com/chen/尚硅谷/反射/jdbc.properties");

        //此时的文件默认在当前的module下。
        //读取配置文件的方式一：
        Properties properties = new Properties();
        // FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/chen/尚硅谷/反射/jdbc.properties");
        // properties.load(fileInputStream);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        // TODO 学完file来看 resources下的可以（被打包了，应该是设置问题）
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc2.properties");
        properties.load(resourceAsStream);


        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user+password);
    }
    @SneakyThrows
    @Test
    public void test22(){
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("../helloworld/s.txt"));
        byte[] bytes = new byte[1024];
        bufferedInputStream.read(bytes);
        System.out.println(new String(bytes));
    }
}
