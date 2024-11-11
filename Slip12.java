// //Write a Java Program to implement Decorator Pattern for interface Car to define the 
// assemble() method and then decorate it to Sports car and Luxury Car



interface Car 
{
    String assemble();
}

class BasicCar implements Car
{
    public String assemble()
    {
        return "Basic Car";
    }
}

abstract class CarDecorator implements Car
{
    Car car;

    CarDecorator(Car car)
    {
        this.car = car;
    }
}

class SportsCar extends CarDecorator
{
    SportsCar(Car car)
    {
        super(car);
    }

    public String assemble()
    {
        return car.assemble() + "with Sports Features";
    }
}

class LuxuryCar extends CarDecorator
{
    LuxuryCar(Car car)
    {
        super(car);
    }

    public String assemble()
    {
        return car.assemble() + "with Luxury Features";
    }
}

public class Slip12
{
    public static void main(String[] args) 
    {
        Car car1 = new SportsCar(new BasicCar());
        System.out.println(car1.assemble());

        Car car2 = new LuxuryCar(new BasicCar());
        System.out.println(car2.assemble());

        Car car3 = new SportsCar(new LuxuryCar(new BasicCar()));    
        System.out.println(car3.assemble());
    }
}


// Output : 

// Basic Carwith Sports Features
// Basic Carwith Luxury Features
// Basic Carwith Luxury Featureswith Sports Features