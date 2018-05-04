package com.design.pattern.main.observer;

import com.design.pattern.main.observer.impl.GreenDress;
import com.design.pattern.main.observer.impl.RedDress;
import com.design.pattern.main.observer.impl.User;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bekuku on 11/6/15.
 */
public class RedDressTest {

    private static final Logger log = Logger.getLogger(RedDressTest.class);

    @Test
    public void dummyTest(){
        assertTrue(true);
    }

    @Test
    public void testObserver(){
        //create subject
        RedDress redDress = new RedDress();
        GreenDress greenDress = new GreenDress();

        //create observers
        User user1 = new User("User1", 1);
        User user2 = new User("User2", 2);
        User user3 = new User("User3", 3);

        //register observers to the subject
        redDress.addObserver(user1);
        redDress.addObserver(user2);
        redDress.addObserver(user3);

        //attach observer to subject
        user1.setObservable(redDress);
        user2.setObservable(redDress);
        user3.setObservable(redDress);

        //check if any update is available
        user1.update();

        //now send message to subject
        redDress.updateStock(true, 4);

        User user4 = new User("User4", 1);
        User user5 = new User("User5", 5);


        greenDress.addObserver(user4);
        greenDress.addObserver(user5);

        user4.setObservable(greenDress);
        user5.setObservable(greenDress);

        user4.update();

        greenDress.updateStock(true, 1);

        try {
            Thread.sleep(1000);
            greenDress.updateStock(true, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}