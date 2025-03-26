//CyclicBarrier is a synchronization aid in the java.util.concurrent package.
//It allows a set of threads to all wait for each other to reach a common barrier point.
//Once all threads reach this point, they are released to continue their execution.
//The term "cyclic" comes from the fact that after all threads are released,
//the barrier can be reused for another round of synchronization.

//1) CyclicBarrier(int parties)
//Description: Creates a CyclicBarrier with the specified number of parties (threads)
//that must call await() before the barrier is tripped.
//Parameters:
//parties – the number of threads that must call await() before the barrier is tripped.
//CyclicBarrier barrier = new CyclicBarrier(3);  // 3 threads must reach the barrier

//2) CyclicBarrier(int parties, Runnable barrierAction)
//Description: Creates a CyclicBarrier with the specified number of parties,
//and an optional Runnable action that is executed when the barrier is tripped.
//Parameters:
//parties – the number of threads that must call await() before the barrier is tripped.
//barrierAction – a Runnable that will execute after all threads have reached the barrier.
//CyclicBarrier barrier = new CyclicBarrier(3, () -> {
//    System.out.println("All threads have reached the barrier.");
//});

//3) int await()
//Description: Causes the calling thread to wait until the required number of
//threads have called await(). When all threads have reached the barrier,
//they are released to continue execution.
//Returns: The index of the thread (its position in the sequence of threads).
//barrier.await();  // The calling thread waits for others to reach the barrier

//4) int await(long timeout, TimeUnit unit)
//Description: Causes the calling thread to wait until the barrier is tripped,
//or the specified time has passed, whichever occurs first. If the timeout expires,
//the thread is released and the method returns CyclicBarrier.BROKEN.
//Parameters:
//timeout – the maximum time to wait.
//unit – the time unit for the timeout.
//Returns: The index of the thread or CyclicBarrier.BROKEN if the barrier is broken
//(i.e., some thread timed out or was interrupted).
//int result = barrier.await(10, TimeUnit.SECONDS);  // Wait for 10 seconds or until barrier is tripped

//5) int getNumberWaiting()
//Description: Returns the number of threads currently waiting at the barrier.
//Returns: The number of threads waiting at the barrier.
//System.out.println("Threads waiting: " + barrier.getNumberWaiting());

//6) int getParties()
//Description: Returns the number of parties (threads) that must arrive at the barrier
//to trigger the action.
//Returns: The number of parties.
//System.out.println("Parties: " + barrier.getParties());

