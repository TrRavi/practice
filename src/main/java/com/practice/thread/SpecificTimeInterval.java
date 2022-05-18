package com.practice.thread;

import java.util.Timer;
import java.util.TimerTask;

public class SpecificTimeInterval {

    Timer timer;

    public SpecificTimeInterval(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), 0,seconds*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            //timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        new SpecificTimeInterval(1);
        System.out.println("Task scheduled.");
    }
}
