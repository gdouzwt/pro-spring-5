package com.apress.prospring5.ch5;

public class WorkerBean {
    public void doSomeWork(int noOfTimes) {
        for (int x = 0; x < noOfTimes; x++) {
            work();
        }
    }

    private void work() {
        // This prevents the compiler from optimizing the work() method and thus the call to work().
        System.out.print("");
    }
}
