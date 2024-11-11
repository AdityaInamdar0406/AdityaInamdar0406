//Write a Java Program to implement undo command to test Ceiling fan.



interface Command 
{
    void execute();
    void undo();
}

class CeilingFan 
{
    String state = "OFF";

    void high() 
    {
        state = "HIGH";
    }

    void off() 
    {
        state = "OFF";
    }

    String getState() 
    {
        return state;
    }
}

class CeilingFanCommand implements Command 
{
    CeilingFan fan;
    String previousState;

    CeilingFanCommand(CeilingFan fan) 
    {
        this.fan = fan;
    }

    public void execute(String newState) 
    {
        previousState = fan.getState(); 
        if ("HIGH".equals(newState)) 
        {
            fan.high();
        } 
        else 
        {
            fan.off();
        }
    }

    // Default execute method for the Command interface
    public void execute() 
    {
        // No action here; it's used only to match the Command interface
    }

    public void undo() 
    {
        if ("HIGH".equals(previousState)) 
        {
            fan.high();
        } 
        else 
        {
            fan.off();
        }
    }
}

public class Slip7 
{
    public static void main(String[] args) 
    {
        CeilingFan fan = new CeilingFan();
        CeilingFanCommand command = new CeilingFanCommand(fan);

        command.execute("HIGH");
        System.out.println("State: " + fan.getState());

        command.execute("OFF");
        System.out.println("State: " + fan.getState());

        command.undo();
        System.out.println("State: " + fan.getState());
    }
}

// Output:

// State: HIGH
// State: OFF
// State: HIGH
