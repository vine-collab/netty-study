package com.hoteach.dectorator;

/**
 * 具体装饰者
 *
 * @author tengyue(hk177955)
 * @date 2019-04-07 10:58
 */

public class ConcreteDecorator2 extends Decorator{


    public ConcreteDecorator2(Component component){
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("function C");
    }
}
