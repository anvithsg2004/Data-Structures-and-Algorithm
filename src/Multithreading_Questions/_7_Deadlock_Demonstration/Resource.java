package Multithreading_Questions._7_Deadlock_Demonstration;

public class Resource {
    private String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
