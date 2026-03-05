package DSA.LLD._2_Behavioral_Design_Patterns._4_Command;

import DSA.LLD._2_Behavioral_Design_Patterns._4_Command.Command.Command;
import DSA.LLD._2_Behavioral_Design_Patterns._4_Command.Command.LightOffCommand;
import DSA.LLD._2_Behavioral_Design_Patterns._4_Command.Command.LightOnCommand;
import DSA.LLD._2_Behavioral_Design_Patterns._4_Command.Invoker.RemoteControl;
import DSA.LLD._2_Behavioral_Design_Patterns._4_Command.Receiver.Light;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();

        Command onCommand = new LightOnCommand(light);
        Command offCommand = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(onCommand);
        remote.pressButton();   // Light is ON

        remote.setCommand(offCommand);
        remote.pressButton();   // Light is OFF
    }
}
