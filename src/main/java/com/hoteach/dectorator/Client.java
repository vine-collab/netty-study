package com.hoteach.dectorator;

/**
 * @author tengyue(hk177955)
 * @date 2019-04-07 11:18
 */

public class Client {

    public static void main(String[] args) {
        ConcreteDecorator2 concreteDecorator2 = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        concreteDecorator2.doSomething();
    }

}
