package com.design.pattern.main.observer;

/**
 * Created by bekuku on 6/6/15.
 */
public interface WeatherDataObserver {
    void update(float temp, float humidity, float pressure);
}
