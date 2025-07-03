package DSA.LLD._2_Behavioral_Design_Patterns._6_State;

public class Fan {
    private State state;

    public Fan() {
        this.state = new OffState(); // Initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressButton() {
        state.pressButton(this);
    }
}
