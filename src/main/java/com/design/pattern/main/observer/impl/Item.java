package com.design.pattern.main.observer.impl;

import com.design.pattern.main.observer.Observable;
import com.design.pattern.main.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 18/6/16.
 */
public abstract class Item implements Observable {

    protected String observedItemName;
    protected volatile boolean inStock = false;
    protected CopyOnWriteArrayList<Observer> users;
    protected final AtomicInteger qty = new AtomicInteger(0);

    //method to post message to the topic
    public void updateStock(boolean inStock, int qty) {
        if (inStock) {
            this.setInStock(inStock);
            this.restock(qty);
            notifyObservers();
        } else {
            System.out.println("No new stock yet");
        }
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public synchronized void addObserver(Observer observer) {
        if (users == null)
            throw new NullPointerException();
        if (!users.contains(observer)) {
            users.add(observer);
        }
    }

    @Override
    public synchronized void deleteObserver(Observer observer) {
        users.remove(observer);
    }

    /**
     *  synchronization is used to make sure any observer registered after message is received is not notified
     */
    @Override
    public synchronized void notifyObservers() {
        List<Observer> observersLocal = null;


        if (!inStock || qty.get() <= 0) {
            return;
        }

        synchronized (users) { // Only users added before this will be notified.
            observersLocal = new ArrayList<>(this.users);
        }

        //Java 8 Stream
        observersLocal.stream().forEach(o -> {
            if (qty.get() >= o.getReservedQty()) {
                o.update();
            }
        });

        if (qty.get() <= 0) this.inStock = false;
    }

    @Override
    public void subtractQty(int num) {
        if (num <= 0) {
            System.out.println("Invalid quatity");
        }
        synchronized (qty) {
            if (qty.get() > 0 && qty.get() >= num) {
                qty.addAndGet(-num);
            } else {
                System.out.println(String.format("Out of stock! Current stock [%s]", qty.get()));
            }

        }
    }

    @Override
    public int getQty() {
        return this.qty.get();
    }

    @Override
    public void restock(int qty) {
        this.qty.addAndGet(qty);
    }

    @Override
    public boolean getUpdate(Observer observer) {
        return isInStock();
    }

    @Override
    public String getInfo() {
        return this.observedItemName;
    }
}
