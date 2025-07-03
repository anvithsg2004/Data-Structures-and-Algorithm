package DSA.LLD._5_Highest_Asked_Design_Patterns._6_State_Pattern;

interface State {
    void pressButton(Fan fan);
}

class FanOnState implements State {
    public void pressButton(Fan fan) {
        System.out.println("Turning fan OFF...");
        fan.setState(new FanOffState());
    }
}

class FanOffState implements State {
    public void pressButton(Fan fan) {
        System.out.println("Turning fan ON...");
        fan.setState(new FanOnState());
    }
}

class Fan {
    private State state;

    public Fan() {
        state = new FanOffState(); // initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressButton() {
        state.pressButton(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();

        fan.pressButton(); // Output: Turning fan ON...
        fan.pressButton(); // Output: Turning fan OFF...
        fan.pressButton(); // Output: Turning fan ON...
    }
}
