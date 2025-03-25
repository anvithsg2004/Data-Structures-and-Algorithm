//What is CompletableFuture?
//CompletableFuture is a class that helps in handling asynchronous tasks in Java.
//In simpler terms, it allows us to start tasks that run in the background and get
//the results later without blocking the rest of the program. This is really useful
//when you have tasks that can be done in parallel and don't need to be completed
//before moving on with other work.

//Main Concepts
//Asynchronous Task: A task that runs in the background, without blocking your main program.
//Future: Represents the result of an asynchronous computation, which might not be available immediately.
//Completion: You can "complete" or "finish" a CompletableFuture once the task is done.

//1. supplyAsync(Supplier<U> supplier):
//Purpose: This method is used to execute a task asynchronously, where the task returns a
//result (a value of type U).
//Usage: You provide a Supplier<U> (a functional interface that returns a value), and the
//CompletableFuture will run the task in a separate thread. It doesn't block the calling thread.
//CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//    return 10; // This value is computed asynchronously
//});

//2. thenApplyAsync(Function<T, U> fn):
//Purpose: This method allows you to apply a function asynchronously to the result of the CompletableFuture when it's
//available. It takes the result of the previous stage (T) and transforms it to a new value (U).
//Usage: You provide a Function<T, U> (a functional interface that takes an input T and returns a value U),
//and this function is applied to the result of the current CompletableFuture.
//CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10);
//CompletableFuture<Integer> doubled = future.thenApplyAsync(value -> value * 2);

//3. thenAccept(Consumer<T> action):
//Purpose: This method is used to consume the result of a CompletableFuture asynchronously, without returning any result.
//It's similar to thenApplyAsync, but it doesn't return a new CompletableFuture. Instead, it only performs an
// action (like logging, printing, or modifying an external state) on the result.
//Usage: You provide a Consumer<T> (a functional interface that accepts an input T but doesn't return anything),
//which performs some action with the result.
//CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10);
//future.thenAccept(value -> System.out.println("The value is: " + value));

//4. allOf(CompletableFuture<?>... cfs):
//Purpose: This method is used to combine multiple CompletableFuture objects and create a new one. The new
//CompletableFuture will complete when all of the provided futures are completed.
//Usage: You pass in multiple CompletableFuture instances, and allOf returns a new CompletableFuture that is
//completed when every one of the provided CompletableFuture objects finishes.
//CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
//CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
//CompletableFuture<Void> combined = CompletableFuture.allOf(future1, future2);
//combined.thenRun(() -> System.out.println("Both futures are completed!"));

//5. anyOf(CompletableFuture<?>... cfs):
//Purpose: This method is used to combine multiple CompletableFuture objects and create a new one. The new
//CompletableFuture will complete as soon as any one of the provided futures completes.
//Usage: You pass in multiple CompletableFuture instances, and anyOf returns a new CompletableFuture that is completed
//as soon as any one of the futures finishes.
//CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
//CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
//CompletableFuture<Object> firstCompleted = CompletableFuture.anyOf(future1, future2);
//firstCompleted.thenAccept(result -> System.out.println("First completed result: " + result));

