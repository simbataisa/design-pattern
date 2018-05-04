package com.design.pattern.main.strategy;

import com.design.pattern.main.strategy.behaviour.FlyWithWings;
import com.design.pattern.main.strategy.behaviour.Quack;
import org.junit.Test;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 18/6/16.
 */
public class StrategyTest {

    @Test
    public void test() {
        Duck marlardDuck = new MarlardDuck();
        marlardDuck.setFlyBehaviour(new FlyWithWings());
        marlardDuck.setQuackBehaviour(new Quack());

        marlardDuck.display();
        marlardDuck.swim();
        marlardDuck.performFly();
        marlardDuck.performQuack();
    }
}
