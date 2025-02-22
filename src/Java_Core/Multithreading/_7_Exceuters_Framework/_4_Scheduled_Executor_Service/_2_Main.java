package Java_Core.Multithreading._7_Exceuters_Framework._4_Scheduled_Executor_Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _2_Main {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

        //Here there is a concept, when we do the normal schedule, it will go smoothly,
        //but in the "scheduleAtFixedRate" as soon as we write shut down this may not get time to
        //execute itself, so it doesn't any output.

        //To overcome this add a simple schedule after that.

        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Task every 5 sec delay"),
                5,
                5,
                TimeUnit.SECONDS
        );

        scheduler.schedule(() ->
                {
                    System.out.println("Task scheduled after 5 seconds delay");
                    scheduler.shutdown();
                },
                15,
                TimeUnit.SECONDS);

    }

}
