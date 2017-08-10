package com.straw.nettycore.strategy;

/**
 * Created by fengzy on 7/28/2017.
 * 这是一个鸭子游戏的设计，我们需要很多鸭子，这些鸭子有些特性是共同的，比如会游泳，有些特性是不一样的，比如
 * 叫声和飞翔的动作，有的不叫，有的不会飞，那么我们应该怎么设计呢？
 * 1，分离出该抽象中动态和非动态的内容，游泳是所有的鸭子都要具备的特性，所以我们想到了使用继承的方式，
 * 让每个鸭子生下来就会游泳。
 * 2，   外表也是每个鸭子都有的，但是每个鸭子的外表又不一样，具体是什么样子的，我们只能在这只鸭子出生的时候看情况给，
 * 所以我们想到了， 使用一个不实现的方法。到这里我们的抽象类便可以实现，
 * 3，至于飞翔这个动作，是一种特俗的本能不是每个鸭子都有的，我想到了，接口， 去定义一些动作，赋予每个鸭子，然后让鸭子去
 * 实现自己的飞翔。
 * 4， 现在我们的鸭子已经有了共通的属性和一样的属性，不一样的实现，也有了特定的动作。
 * 那么如果我们现在有一只绿头鸭会螺旋飞翔，然后一个白头鸭也会螺旋飞翔，然后一只黑头鸭也会螺旋飞，
 * 是不是我们需要在这3只鸭子出生的时候去挨个实现一遍螺旋飞翔呢？
 * 5，一种假设是分大类，即：第二队列的子类中有实现螺旋的鸭子，如果后来的是螺旋飞的鸭子我们可以让他继承该鸭子，
 * 但是螺旋飞只是飞翔的一种，还有倒飞，还有安装上火箭飞，还有正常飞，除了飞翔鸭子的叫声也不同，平时都是嘎嘎叫
 * 但是木头的鸭子不会叫，塑料的鸭子吱吱叫。假如我们现在有一只倒飞的鸭子吱吱叫，是否需要继承2个第二梯队的子类呢，但是java的
 * 单继承模式不允许，这么多可能有无数的组合，并不是一种很好的实现方式。
 * 6，当正常的独特动作方法抽取遇到些麻烦后，这个问题变的严肃起来，现在唯一乱的事情是不能确定该鸭子的属性，并且还有很多
 * 可以组合的属性。属性还有不同的实现方式。
 * 7，结合以上的问题，我们发现我们再继续分析这个不同的属性，把属性和实现分离，因为属性不变，但是实现会变，并且
 * 单独实现以后可以重复利用。
 * 8，策略模式：定义了算法族，风别封装起来，让他们之间可以相互替换，此模式让算法的变化独立于使用算法的客户。
 */

public abstract class Duck {
    FlyBehavior fayBehavior;//飞行方式
    CryBehavior cryBehavior;//怎么叫

    //使用private
    public void swim() {
        System.out.println("i'm swiming.");
    }

    //什么样子
    public abstract void display();

    public void fly() {
        fayBehavior.fly();
    }

    public void cry() {
        cryBehavior.cry();
    }

    public FlyBehavior getFayBehavior() {
        return fayBehavior;
    }

    public void setFayBehavior(FlyBehavior fayBehavior) {
        this.fayBehavior = fayBehavior;
    }

    public CryBehavior getCryBehavior() {
        return cryBehavior;
    }

    public void setCryBehavior(CryBehavior cryBehavior) {
        this.cryBehavior = cryBehavior;
    }
}
