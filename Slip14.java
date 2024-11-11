// Command Interface
interface Command {
    void execute();
}

// Receiver classes
class Light {
    void on() { System.out.println("Light is ON"); }
    void off() { System.out.println("Light is OFF"); }
}

class GarageDoor {
    void up() { System.out.println("Garage Door is UP"); }
    void down() { System.out.println("Garage Door is DOWN"); }
}

class Stereo {
    void on() { System.out.println("Stereo is ON"); }
    void off() { System.out.println("Stereo is OFF"); }
    void setCD() { System.out.println("Stereo is set to CD mode"); }
    void setVolume(int volume) { System.out.println("Stereo volume set to " + volume); }
}

// Concrete Command classes
class LightOnCommand implements Command {
    private Light light;
    LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.on(); }
}

class LightOffCommand implements Command {
    private Light light;
    LightOffCommand(Light light) { this.light = light; }
    public void execute() { light.off(); }
}

class GarageDoorUpCommand implements Command {
    private GarageDoor garageDoor;
    GarageDoorUpCommand(GarageDoor garageDoor) { this.garageDoor = garageDoor; }
    public void execute() { garageDoor.up(); }
}

class StereoOnWithCDCommand implements Command {
    private Stereo stereo;
    StereoOnWithCDCommand(Stereo stereo) { this.stereo = stereo; }
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(10);
    }
}

// Invoker class
class RemoteControl {
    private Command slot;
    void setCommand(Command command) { slot = command; }
    void pressButton() { slot.execute(); }
}

// Main Client Class
public class Slip14 {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        
        // Creating receivers
        Light livingRoomLight = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        // Creating commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command garageUp = new GarageDoorUpCommand(garageDoor);
        Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);

        // Using remote control with different commands
        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();

        remote.setCommand(garageUp);
        remote.pressButton();

        remote.setCommand(stereoOnWithCD);
        remote.pressButton();
    }
}
