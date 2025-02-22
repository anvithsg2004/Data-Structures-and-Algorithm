package Java_Core.Multithreading._7_Exceuters_Framework._4_Scheduled_Executor_Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _1_Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> System.out.println("Task scheduled after 5 seconds delay"), 5, TimeUnit.SECONDS);
        scheduler.shutdown();
    }
}
