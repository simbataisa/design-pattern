package com.design.pattern.main.observer.impl;

import com.design.pattern.main.observer.Observable;
import com.design.pattern.main.observer.Observer;

/**
 * Created by bekuku on 5/6/15.
 */
public class User implements Observer {

    private Observable observable = null;
    private String username = null;
    private int qty;

    public User(String username) {
        this.username = username;
    }
    public User(String username, int qty) {
        this.username = username;
        this.qty = qty;
    }

    @Override
    public synchronized void update() {
        if (observable.getUpdate(this) && observable.getQty() > 0) {
            buyDress(observable);
            unsubscribe();
        } else {
            System.out.println(username + " still waiting");
        }
    }

    @Override
    public int getReservedQty() {
        return this.qty;
    }

    private void unsubscribe() {
        getObservable().deleteObserver(this);
    }

    private void buyDress(Observable observable) {
        observable.subtractQty(qty);
        System.out.println(this.username + " buying " + observable.getInfo());
    }

    public Observable getObservable() {
        return observable;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
