package com.design.pattern.main.strategy;

import com.design.pattern.main.strategy.behaviour.FlyBehaviour;
import com.design.pattern.main.strategy.behaviour.QuackBehaviour;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 18/6/16.
 */
public abstract class Duck {

    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    protected void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    protected abstract void display();

    protected void performFly() {
        flyBehaviour.fly();
    }

    protected void performQuack() {
        quackBehaviour.quack();
    }

    public FlyBehaviour getFlyBehaviour() {
        return flyBehaviour;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public QuackBehaviour getQuackBehaviour() {
        return quackBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}
