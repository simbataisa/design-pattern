package com.design.pattern.main.observer.impl;

import com.design.pattern.main.observer.WeatherDataObservable;
import com.design.pattern.main.observer.WeatherDataObserver;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 18/6/16.
 */
public class WeatherData implements WeatherDataObservable {

    private final CopyOnWriteArrayList<WeatherDataObserver> observers;
    private float temp, humidity, pressure;

    public WeatherData() {
        this.observers = new CopyOnWriteArrayList<>();
    }

    public float getTemperature() {
        return 0;
    }

    public float getHimidity() {
        return 0;
    }

    public float getPressure() {
        return 0;
    }

    @Override
    public void addObserver(WeatherDataObserver observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(WeatherDataObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

    }

    /**
     * This method gets called
     * whenever the weather measurements
     * have been updated
     */
    @Override
    public boolean getUpdate(WeatherDataObserver observer) {
        return false;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
