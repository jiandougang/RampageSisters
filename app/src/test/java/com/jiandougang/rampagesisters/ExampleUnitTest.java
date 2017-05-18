package com.jiandougang.rampagesisters;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 1);
    }

    @Test
    public void sum() {
        TimerTask task = new TimerTask() {
            public void run() {
//                assertEquals(4, 2 + 1);
                assertEquals("去你大爷","11","123");

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1 * 1000);
        timer.purge();
    }
}