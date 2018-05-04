package com.design.pattern.main.observer.impl;

import com.design.pattern.main.observer.Display;
import com.design.pattern.main.observer.WeatherDataObserver;

/**
 * @author DAO TUAN ANH (DENNIS).
 * @created on 18/6/16.
 */
public class CurrentConditionDisplay implements WeatherDataObserver, Display {

    @Override
    public void display() {

    }

    @Override
    public void update(float temp, float humidity, float pressure) {

    }
}
