package Java_Core.Multithreading._7_Exceuters_Framework._1_Without_Exceutor_Framework;

public class Main {

    public static long factorial(int n) {

        int result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        return result;

    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total Time : " + (System.currentTimeMillis() - startTime));
    }

}
