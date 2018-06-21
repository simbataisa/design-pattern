package com.design.pattern.main.observer.impl;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bekuku on 5/6/15.
 */
public class GreenDress extends Item {

    public GreenDress() {
        this.users = new CopyOnWriteArrayList<>();
        this.observedItemName = "Green Dress";
    }

}
