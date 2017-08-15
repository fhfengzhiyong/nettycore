package com.straw.nettycore.oop;

/**
 * Created by fengzy on 8/11/2017.
 */
class Air {
    public Air() {
        System.out.println("Air constructor");
    }

    private void say() {
        System.out.println("bibi");
    }
}

class Air1 extends Air {
    public Air1() {
        System.out.println("Air1 constructor");
    }
}

public class Air2 extends Air1 {
    public Air2() {
        System.out.println("Air2 constructor");
    }

    public static void main(String[] args) {
        Air2 air2 = new Air2();
    }

}
