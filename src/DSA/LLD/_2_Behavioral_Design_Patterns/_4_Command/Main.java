package DSA.LLD._2_Behavioral_Design_Patterns._4_Command;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();

        Command on = new TurnOnCommand(light);
        Command off = new TurnOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(on);
        remote.pressButton();  // Light is ON

        remote.setCommand(off);
        remote.pressButton();  // Light is OFF
    }
}
