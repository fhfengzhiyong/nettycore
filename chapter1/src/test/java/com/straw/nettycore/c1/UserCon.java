package com.straw.nettycore.c1;

/**
 * Created by fengzy on 7/26/2017.
 */
public class UserCon {
    public static void main(String[] args) {
        User user = new User("straw", 28);
        System.out.println("1：" + user.toString());
        conversion(user);
        System.out.println("3:" + user.toString());

    }

    private static void conversion(User user) {
        user.setName("splid");
        user = new User("spcil", 52);
        System.out.println("2:" + user.toString());
    }
}
