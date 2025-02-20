package Java_Core.Multithreading._3_Locking_and_Unlocking.Locks;

//Lock → The resourese are locked by the OS so that
//only one user/thread/preprocess can access it or to modify it.

//Types of Locks
//1) Intrinsic
//      These are built into every object in Java. You don't see them, but they're there.
//      When you use a synchronized keyword, you're using these automatic locks.
//2) Explicit
//        These are more advanced locks you can control yourself using the Lock class
//        from java.util.concurrent.locks. You explicitly say when to lock and unlock,
//        giving you more control over how and when people can write in the notebook


//Difference between the Lock interface and using synchronized keyword in the method.
//1. Synchronized Keyword
//      A built-in mechanism in Java for thread synchronization.
//      Can be applied to methods or code blocks (synchronized methods or synchronized blocks).
//      Implicitly acquires and releases the lock.
//      Once a thread enters a synchronized block or method, other threads are blocked until the first thread completes.
//      Cannot try to acquire the lock with a timeout.
//      Cannot check if the lock is available before acquiring it.
//      No need to manually release the lock (automatically handled by JVM).
//      Only one thread at a time can execute the increment() method.
//      JVM automatically manages lock acquisition and release.

//2. Lock Interface (ReentrantLock)
//      A more flexible alternative to synchronized.
//      Provides explicit lock() and unlock() methods.
//      Supports tryLock() (attempt to acquire a lock with timeout).
//      Allows checking if the lock is available before acquiring it.
//      Can be fair or unfair (choose whether the longest-waiting thread gets priority).
//      Must manually release the lock, otherwise, it can cause deadlocks if not handled properly.
//      More control over locking (e.g., can be used in complex scenarios).
//      Requires manually releasing the lock inside a finally block to prevent deadlocks.

