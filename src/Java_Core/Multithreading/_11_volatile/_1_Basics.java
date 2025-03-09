//The volatile keyword in Java is used to ensure visibility and
//ordering of variables across multiple threads.
//It is primarily used in multi-threading to prevent caching issues.

//1️⃣ Why Use volatile?
//In a multithreaded environment, a variable may be stored in CPU cache instead of main memory.
//If one thread updates a variable, another thread may not see the updated value immediately.
//volatile ensures that all threads read/write the latest value from the main memory.

//2️⃣ How volatile Works?
//Ensures visibility: Changes made by one thread are immediately visible to other threads.
//Prevents instruction reordering: The compiler will not reorder read/write operations on a volatile variable.

//5️⃣ When to Use volatile?
//Use volatile when: ✔ You have one thread writing and multiple threads reading a variable.
//✔ You need to ensure visibility of changes across threads.
//✔ You don’t need atomicity (for atomic operations, use synchronized or Atomic variables).

//6️⃣ When NOT to Use volatile?
//🚫 If multiple threads both read and write, use synchronization instead.
//🚫 volatile does not guarantee atomicity (e.g., count++ is not thread-safe).
