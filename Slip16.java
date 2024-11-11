// Write a Java Program to implement Observer Design Pattern for number conversion. 
// Accept a number in Decimal form and represent it in Hexadecimal, Octal and Binary. 
// Change the Number and it reflects in other forms also

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(int number);
}

// Subject Class
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int number;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setNumber(int number) {
        this.number = number;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(number);
        }
    }
}

// Concrete Observers
class HexadecimalObserver implements Observer {
    @Override
    public void update(int number) {
        System.out.println("Hexadecimal: " + Integer.toHexString(number).toUpperCase());
    }
}

class OctalObserver implements Observer {
    @Override
    public void update(int number) {
        System.out.println("Octal: " + Integer.toOctalString(number));
    }
}

class BinaryObserver implements Observer {
    @Override
    public void update(int number) {
        System.out.println("Binary: " + Integer.toBinaryString(number));
    }
}

// Main Class named Slip16
public class Slip16 {
    public static void main(String[] args) {
        Subject subject = new Subject();

        // Attach observers
        subject.addObserver(new HexadecimalObserver());
        subject.addObserver(new OctalObserver());
        subject.addObserver(new BinaryObserver());

        // Set a number to trigger updates
        System.out.println("Setting number to 42");
        subject.setNumber(42);

        System.out.println("\nSetting number to 255");
        subject.setNumber(255);
    }
}

// output

// Setting number to 42
// Hexadecimal: 2A
// Octal: 52
// Binary: 101010

// Setting number to 255
// Hexadecimal: FF
// Octal: 377
// Binary: 11111111