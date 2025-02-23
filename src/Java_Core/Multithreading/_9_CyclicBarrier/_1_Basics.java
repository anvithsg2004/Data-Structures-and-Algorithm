//CyclicBarrier is a synchronization tool in Java that makes multiple threads wait at a
// common point until all of them reach the barrier.
//Unlike CountDownLatch, a CyclicBarrier can be reused after all threads reach the barrier.

//Imagine a group of friends who want to start a game together.
//Each friend waits at the lobby until everyone joins, then the game starts.
//If someone leaves and rejoins, the process repeats.

//Super Simple Analogy:
//CompletableFuture → "I'll call you when I’m done." 📞
//CyclicBarrier → "Let's all meet here before starting." 🚦
//CountDownLatch → "Wait until 3...2...1... GO!" ⏱

//Feature	    CompletableFuture 🏎	                    CyclicBarrier 🚧	                                CountDownLatch ⏳
//Purpose	    Runs tasks asynchronously (non-blocking).	Makes threads wait at a barrier until all arrive.	Makes threads wait until a count reaches zero.
//Reusability	Yes ✅	                                    Yes ✅	                                            No ❌ (One-time use)
//Use Case	    When you need async computation (e.g., API calls, processing tasks).When multiple threads must start together (e.g., a race, multiplayer game).	When a thread must wait for others to finish (e.g., loading resources).
//Blocking?	    No ❌ (Non-blocking)	                    Yes ✅ (Threads wait at barrier)	                Yes ✅ (Threads wait for count)
//Example	    Downloading a file while processing another task.	Starting a game only when all players are ready.	Waiting for 5 files to load before showing a webpage.
