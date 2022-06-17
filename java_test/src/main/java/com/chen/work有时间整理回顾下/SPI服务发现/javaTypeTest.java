package com.chen.work有时间整理回顾下.SPI服务发现;

import java.util.ServiceLoader;

/**
 * @author chenchen
 * @date 2022-06-17 9:29
 */

/**
 * mysql-connector 的 jar 包中正是通过 SPI 的方式实现了 java 的 Driver 接口，
 * 所以我们的服务可以在运行时获取到 mysql 的驱动类，从而连接 mysql 。
 */
/**
 * java 默认方式：必须全部遍历加载
 * spring实现： 键值对和别名、文件分组的方式 （spring.factories文件）
 *
 * https://mp.weixin.qq.com/s?__biz=MzI1NDQ3MjQxNA==&mid=2247500745&idx=1&sn=a1f592c27bcdaeaf9666089d36e3d493&chksm=
 * e9c63a78deb1b36eddb48e8a6c3916871c62090056725fa3c752ca22e6b17e19a1295cc87881&scene=21#wechat_redirect
 */


public class javaTypeTest {
    public static void main(String[] args) {
        ServiceLoader<Superman> serviceLoader = ServiceLoader.load(Superman.class);
        System.out.println("Java SPI:");
        serviceLoader.forEach(Superman::introduce);
    }
}
