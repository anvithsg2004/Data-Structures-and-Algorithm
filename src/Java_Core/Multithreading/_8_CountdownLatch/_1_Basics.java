//CountDownLatch is a synchronization helper in Java that allows one or more threads
//to wait until a set number of operations (performed by other threads) are completed.

//Key Methods in CountDownLatch:
//1) CountDownLatch(int count)
//Description: Constructor that creates a CountDownLatch initialized with the specified count.
//Parameters:
//count – the number of times countDown() must be invoked before threads can pass through await().
//CountDownLatch latch = new CountDownLatch(3);

//2) void countDown()
//Description: Decreases the count of the latch by one. If the count reaches zero,
//any threads that were waiting on await() will be released.
//latch.countDown();  // Decreases the count by 1

//3) long getCount()
//Description: Returns the current count of the latch. This is the number of times countDown()
//still needs to be called before threads waiting on await() are released.
//Returns: The current count (a long value).
//System.out.println(latch.getCount());  // Prints current count value

//4) void await()
//Description: Causes the current thread to wait until the latch's count reaches zero.
//If the count is already zero when await() is called, the thread continues without blocking.
//latch.await();  // The calling thread waits until the count reaches zero

//5) boolean await(long timeout, TimeUnit unit)
//Description: Causes the current thread to wait until the latch's count reaches zero or
//the specified waiting time has elapsed, whichever occurs first. If the latch count reaches zero,
//await() returns true; otherwise, it returns false after the timeout expires.
//Parameters:
//timeout – the maximum time to wait
//unit – the time unit for the timeout (e.g., TimeUnit.SECONDS, TimeUnit.MILLISECONDS, etc.)
//Returns: true if the count reached zero, false if the timeout expired.
//boolean completed = latch.await(5, TimeUnit.SECONDS);  // Wait for up to 5 seconds
//if (completed) {
//    System.out.println("Latch count reached zero!");
//} else {
//    System.out.println("Timeout occurred before latch count reached zero.");
//}
