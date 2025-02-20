package Java_Core.Multithreading._2_Synchronization._4_Static_Synchronization;

public class StaticSyncExample {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();

        user1.start();
        user2.start();
    }
}
