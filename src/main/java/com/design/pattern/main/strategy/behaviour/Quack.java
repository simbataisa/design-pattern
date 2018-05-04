package com.design.pattern.main.strategy.behaviour;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 18/6/16.
 */
public class Quack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Quack quack quack");
    }
}
