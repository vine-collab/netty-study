package com.hoteach.dectorator;

/**
 * 装饰角色
 *
 * @author tengyue(hk177955)
 * @date 2019-04-07 10:55
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
