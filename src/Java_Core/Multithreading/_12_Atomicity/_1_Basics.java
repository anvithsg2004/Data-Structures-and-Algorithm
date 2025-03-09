//Atomicity in Java
//Atomicity means an operation is indivisible—it either completes
//fully or does not happen at all, preventing race conditions in multi-threading.

//2️⃣ How to Ensure Atomicity?
//✅ Use synchronized

//✅ Use AtomicInteger (Recommended)
//Java provides AtomicInteger, which ensures atomic operations without locks.

//🔹 Why use AtomicInteger?
//AtomicInteger uses low-level CPU instructions (CAS - Compare-And-Swap)
//to ensure atomic updates.
//Faster than synchronized because it avoids context switching and locking.
