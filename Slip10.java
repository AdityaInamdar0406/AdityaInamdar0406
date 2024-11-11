// //Write a Java Program to implement Strategy Pattern for Duck Behavior. Create 
// instance variable that holds current state of Duck from there, we just need to handle 
// all Flying Behaviors and Quack Behavior


interface FlyBehavior
{
    void fly();
}

interface  QuackBehavior
{
    void quack();
}

class FlyWithWings implements FlyBehavior
{
    public void fly()
    {
        System.out.println("Fly With Wings");
    }
}

class CannotFly implements FlyBehavior
{
    public void fly()
    {
        System.out.println("Cannot Fly");
    }
}

class QuackLoudly implements QuackBehavior
{
    public void quack()
    {
        System.out.println("Quack Louder");
    }
}

class CannotQuack implements QuackBehavior
{
    public void quack()
    {
        System.out.println("Cannot Quack");
    }
}

class Duck
{
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    Duck(FlyBehavior flyBehavior,QuackBehavior quackBehavior)
    {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void performFly()
    {
        flyBehavior.fly();
    }

    public void performQuack()
    {
        quackBehavior.quack();
    }
}

public class Slip10
{
    public static void main(String[] args) 
    {
        Duck a = new Duck(new FlyWithWings(),new QuackLoudly());
        Duck b = new Duck(new CannotFly(),new CannotQuack());

        a.performFly();
        a.performQuack();

        b.performFly();
        b.performQuack();    
    }
}


// Output :

// Fly With Wings
// Quack Louder
// Cannot Fly
// Cannot Quack