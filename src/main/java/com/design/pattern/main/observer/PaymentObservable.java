package com.design.pattern.main.observer;

/**
 * Created by bekuku on 12/6/15.
 */
public interface PaymentObservable {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObservers();

    boolean getUpdate(Observer observer);
}
