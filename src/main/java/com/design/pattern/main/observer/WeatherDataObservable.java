package com.design.pattern.main.observer;

/**
 * Created by bekuku on 6/6/15.
 */
public interface WeatherDataObservable {

    void addObserver(WeatherDataObserver observer);

    void deleteObserver(WeatherDataObserver observer);

    void notifyObservers();

    boolean getUpdate(WeatherDataObserver observer);

    String getInfo();
}
