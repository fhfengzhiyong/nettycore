package com.straw.nettycore.loader;

/**
 * @author fengzy
 * @date 3/5/2018
 */
public class Loader {

    public static void main(String[] args) {
        ClassLoader classLoader = Loader.class.getClassLoader();
        //sun.misc.Launcher$AppClassLoader
        System.out.println(classLoader.getClass().getName());
        String name = new Loader().getClass().getClassLoader().getClass().getName();
        System.out.println(new Loader().getClass().getClassLoader().getParent());

        System.out.println(name);
        System.out.println("Hi, i am here");
        try {
            Object loader = (Loader)Class.forName("Loader", false, Loader.class.getClassLoader()).newInstance();
            System.out.println(loader.getClass().getClassLoader());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
