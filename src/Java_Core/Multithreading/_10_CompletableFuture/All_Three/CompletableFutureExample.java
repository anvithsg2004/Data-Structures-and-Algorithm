package Java_Core.Multithreading._10_CompletableFuture.All_Three;

import java.util.concurrent.*;

//1️⃣ CompletableFuture Example → "I'll call you when I’m done." 📞
//Asynchronous (Non-blocking) execution
//Performs tasks in parallel and notifies when finished

//Scenario:
//You need to download a file while processing another task.

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Asynchronous task to download a file
        CompletableFuture<Void> downloadFile = CompletableFuture.runAsync(() -> {
            System.out.println("Downloading file...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            System.out.println("Download complete!");
        });

        // Main thread can do other work while downloading
        System.out.println("Doing other tasks while file downloads...");

        // Wait for file to finish downloading
        downloadFile.join();
        System.out.println("Now we can use the file!");
    }
}
