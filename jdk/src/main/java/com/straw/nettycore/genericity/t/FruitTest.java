package com.straw.nettycore.genericity.t;

/**
 * @Author Lanxiaowei
 * @Date 2018-04-13 16:54
 * @Description 这里是类的描述信息
 */
public class FruitTest {
    public static void main(String[] args) {
        Fruit apple = new Apple("苹果");
        Fruit peach = new Peach("桃子");

        FruitBasket basket = new FruitBasket();
        basket.addFruit(apple);
        basket.addFruit(peach);

        basket.print();
    }
}
