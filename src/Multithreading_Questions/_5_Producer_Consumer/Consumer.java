package Multithreading_Questions._5_Producer_Consumer;

class Consumer implements Runnable {
    private Buffer buffer;
    private String name;

    public Consumer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) { // Consume 5 items
            buffer.consume(name);
            try {
                Thread.sleep((int)(Math.random() * 1500)); // Random delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
