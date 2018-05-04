package com.design.pattern.main.observer;

/**
 * Created by bekuku on 6/6/15.
 */
public interface Observable {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObservers();

    boolean getUpdate(Observer observer);

    int getQty();

    void restock(int qty);

    void subtractQty(int num);

    String getInfo();
}
