package com.design.pattern.main.observer.impl;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bekuku on 5/6/15.
 */
public class RedDress extends Item {


    public RedDress() {
        this.users = new CopyOnWriteArrayList<>();
        this.observedItemName = "Red Dress";
    }
}
