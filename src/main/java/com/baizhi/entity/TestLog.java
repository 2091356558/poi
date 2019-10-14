package com.baizhi.entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {
    static Logger logger = LoggerFactory.getLogger(TestLog.class);
    public static void main(String[] args) {
        try {
            User user = new User();
            user.setSalary(12312.33);
            user.setUsername("zhangsan");
            logger.info("正常执行");
            logger.debug("正常执行  一切正常");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("出现错误");
        }
    }
}
