package DSA.LLD._2_Behavioral_Design_Patterns._6_State;

public class OnState implements State {
    public void pressButton(Fan fan) {
        System.out.println("Fan is turning OFF");
        fan.setState(new OffState());
    }
}
