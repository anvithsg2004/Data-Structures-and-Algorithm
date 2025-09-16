package Multithreading_Questions._12_Create_and_Run_Simple;

import java.util.concurrent.Callable;

public class SimpleTask implements Callable<String> {

    public String message;

    public SimpleTask(String message) {
        this.message = message;
    }

    @Override
    public String call() throws Exception {
        return message + " Completed";
    }
}
