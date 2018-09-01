package com.straw.shiro.t;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author straw(fengzy)
 * @description
 * @date 2018/8/25
 */
public class Test {
    private static final transient Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("straw", "123");
        subject.login(token);
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
        subject.logout();

    }
}
