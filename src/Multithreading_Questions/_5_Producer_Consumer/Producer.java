package Multithreading_Questions._5_Producer_Consumer;

class Producer implements Runnable {
    private Buffer buffer;
    private String name;

    public Producer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) { // Produce 5 items
            buffer.produce(i, name);
            try {
                Thread.sleep((int)(Math.random() * 1000)); // Random delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
