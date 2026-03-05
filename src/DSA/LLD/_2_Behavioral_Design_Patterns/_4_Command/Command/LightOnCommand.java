package DSA.LLD._2_Behavioral_Design_Patterns._4_Command.Command;

import DSA.LLD._2_Behavioral_Design_Patterns._4_Command.Receiver.Light;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
