package DSA.LLD._2_Behavioral_Design_Patterns._4_Command.Command;

import DSA.LLD._2_Behavioral_Design_Patterns._4_Command.Receiver.Light;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
