package com.design.pattern.main.observer;

import com.design.pattern.main.observer.impl.GreenDress;
import com.design.pattern.main.observer.impl.RedDress;
import com.design.pattern.main.observer.impl.User;

import java.util.ArrayList;

/**
 * Created by bekuku on 5/6/15.
 */
public class ObserverPattern {

    private static ArrayList<Observable> observedItems = new ArrayList<>();

    public static void main(String[] args){
        //create subject
        RedDress redDress = new RedDress();
        GreenDress greenDress = new GreenDress();

        //create observers
        User obj1 = new User("User1");
        User obj2 = new User("User2");
        User obj3 = new User("User3");

        //register observers to the subject
        redDress.addObserver(obj1);
        redDress.addObserver(obj2);
        redDress.addObserver(obj3);

        //attach observer to subject
        obj1.setObservable(redDress);
        obj2.setObservable(redDress);
        obj3.setObservable(redDress);

        //check if any update is available
        obj1.update();

        //now send message to subject
        redDress.updateStock(true, 4);

        User obj4 = new User("User4");
        User obj5 = new User("User5");


        greenDress.addObserver(obj4);
        greenDress.addObserver(obj5);

        obj4.setObservable(greenDress);
        obj5.setObservable(greenDress);

        obj4.update();

        greenDress.updateStock(true, 2);


    }
}
