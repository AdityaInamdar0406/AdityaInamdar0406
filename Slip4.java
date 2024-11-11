// //Write a Java Program to implement Factory method for Pizza Store with createPizza(), 
// orederPizza(), prepare(), Bake(), cut(), box(). Use this to create variety of pizza’s
// like NyStyleCheesePizza, ChicagoStyleCheesePizza etc


abstract class Pizza
{
    public void prepare()
    {
        System.out.println("Preparing : " + getClass().getSimpleName());
    }

    public void bake()
    {
        System.out.println("Baking : " + getClass().getSimpleName());
    }

    public void cut()
    {
        System.out.println("Cutting : " + getClass().getSimpleName());
    }

    public void box()
    {
        System.out.println("Boxing : " + getClass().getSimpleName());
    }
}

class NyStyleCheesePizza extends Pizza{}
class ChicagoStyleCheesePizza extends Pizza{}

abstract class PizzaStore
{
    public Pizza orderPizza()
    {
        Pizza pizza = createPizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
    abstract Pizza createPizza();
}

class NyPizzaStore extends PizzaStore
{
    public Pizza createPizza()
    {
        return new NyStyleCheesePizza();
    }
}

class ChicagoPizzaStore extends PizzaStore
{
    public Pizza createPizza()
    {
        return new ChicagoStyleCheesePizza();
    }
}

public class Slip4
{
    public static void main(String[] args)
    {
        PizzaStore ny = new NyPizzaStore(); 
        PizzaStore ch = new ChicagoPizzaStore();

        ny.orderPizza();
        ch.orderPizza();   
    }
}


// Output :

// Preparing : NyStyleCheesePizza
// Baking : NyStyleCheesePizza
// Cutting : NyStyleCheesePizza
// Boxing : NyStyleCheesePizza
// Preparing : ChicagoStyleCheesePizza
// Baking : ChicagoStyleCheesePizza
// Cutting : ChicagoStyleCheesePizza
// Boxing : ChicagoStyleCheesePizza