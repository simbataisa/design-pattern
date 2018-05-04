package com.design.pattern.main.observer.impl;

import com.design.pattern.main.observer.Observable;
import com.design.pattern.main.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bekuku on 5/6/15.
 */
public class GreenDress extends Item implements Observable {

    public GreenDress() {
        this.users = new CopyOnWriteArrayList<>();
        this.observedItemName = "Green Dress";
    }

}
