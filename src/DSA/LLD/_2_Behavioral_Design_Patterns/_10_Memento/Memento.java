package DSA.LLD._2_Behavioral_Design_Patterns._10_Memento;

public class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
