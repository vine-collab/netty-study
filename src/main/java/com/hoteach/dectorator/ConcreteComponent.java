package com.hoteach.dectorator;

/**
 * 具体构建角色
 *
 * @author tengyue(hk177955)
 * @date 2019-04-07 10:27
 */

public class ConcreteComponent implements Component {

    @Override
    public void doSomething() {
        System.out.println("function A");
    }
}
