package com.design.pattern.main.strategy.behaviour;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 18/6/16.
 */
public class FlyWithWings implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("I'm flying with wings");
    }
}
