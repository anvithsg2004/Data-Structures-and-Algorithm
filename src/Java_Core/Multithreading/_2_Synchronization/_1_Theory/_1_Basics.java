package Java_Core.Multithreading._2_Synchronization._1_Theory;

//Thread synchronization is the process of controlling multiple threads
//so that they do not interfere with each other when accessing shared resources
//(such as variables, files, or databases).

//Why is Synchronization Needed?
//When multiple threads access a shared resource at the same time, problems like:
//
//Race Condition: Two threads modifying a value at the same time.
//Data Inconsistency: The final value of a shared variable is unpredictable.
//Unexpected Results: The program behaves randomly because the execution order is not controlled.

//Types of Synchronization in Java.
//Java provides multiple ways to synchronize threads:
//
//Synchronization Type	        Description
//Synchronized Method	        Locks an entire method so that only one thread can access it at a time.
//Synchronized Block	        Locks only a specific block of code instead of the entire method.
//Static Synchronization	    Synchronizes static methods for class-level locking.
//Lock Interface(ReentrantLock) A more flexible way to lock resources manually.
//Volatile Keyword	            Ensures visibility of variables between threads.
