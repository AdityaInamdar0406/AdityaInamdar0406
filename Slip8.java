// //Write a Java Program to implement State Pattern for Gumball Machine. 
// Create instance variable that holds current state from there, we just need to handle all 
// actions, behaviors and state transition that can happen 

// State interface
interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

// Gumball Machine Context
class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State currentState;
    int count = 0;

    public GumballMachine(int count) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        this.count = count;
        if (count > 0) {
            currentState = noQuarterState;
        } else {
            currentState = soldOutState;
        }
    }

    public void insertQuarter() {
        currentState.insertQuarter();
    }

    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    public void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    void setState(State state) {
        currentState = state;
    }

    State getSoldOutState() {
        return soldOutState;
    }

    State getNoQuarterState() {
        return noQuarterState;
    }

    State getHasQuarterState() {
        return hasQuarterState;
    }

    State getSoldState() {
        return soldState;
    }
}

// No Quarter State
class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You inserted a quarter.");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter.");
    }

    public void turnCrank() {
        System.out.println("You turned, but there's no quarter.");
    }

    public void dispense() {
        System.out.println("You need to pay first.");
    }
}

// Has Quarter State
class HasQuarterState implements State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You can't insert another quarter.");
    }

    public void ejectQuarter() {
        System.out.println("Quarter returned.");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public void turnCrank() {
        System.out.println("You turned the crank...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("No gumball dispensed.");
    }
}

// Sold State
class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball.");
    }

    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank.");
    }

    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}

// Sold Out State
class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out.");
    }

    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet.");
    }

    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs.");
    }

    public void dispense() {
        System.out.println("No gumball dispensed.");
    }
}

// Client code
public class GumballMachineTest {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(3);

        System.out.println("\n-- Testing Gumball Machine --");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("\n-- Insert another quarter --");
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();

        System.out.println("\n-- Insert and turn crank again --");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("\n-- Try another one --");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("\n-- Try inserting in sold-out state --");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}



// Output :

// Testing Gumball Machine --
// You inserted a quarter.
// You turned the crank...
// A gumball comes rolling out the slot...

// -- Insert another quarter --
// You inserted a quarter.
// Quarter returned.

// -- Insert and turn crank again --
// You inserted a quarter.
// You turned the crank...
// A gumball comes rolling out the slot...

// -- Try another one --
// You inserted a quarter.
// You turned the crank...
// A gumball comes rolling out the slot...
// Oops, out of gumballs!

// -- Try inserting in sold-out state --
// You can't insert a quarter, the machine is sold out.
// You turned, but there are no gumballs.
// No gumball dispensed.