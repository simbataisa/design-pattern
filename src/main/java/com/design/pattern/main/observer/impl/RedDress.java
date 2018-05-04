package com.design.pattern.main.observer.impl;

import com.design.pattern.main.observer.Observable;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bekuku on 5/6/15.
 */
public class RedDress extends Item implements Observable {


    public RedDress() {
        this.users = new CopyOnWriteArrayList<>();
        this.observedItemName = "Red Dress";
    }
}
