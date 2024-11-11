// //Write a Java Program to implement an Adapter design pattern in mobile charger. 
// Define two classes – Volt (to measure volts) and Socket (producing constant volts of 
// 120V). Build an adapter that can produce 3 volts, 12 volts and default 120 volts. 
// Implements Adapter pattern using Class Adapter


class Volt
{
    int volts;
    public Volt(int volts) 
    {
    	this.volts = volts;
    }
    public int getVolts()
    {
        return volts;
    }
}

class Socket
{
    public Volt getVolt()
    {
        return new Volt(120);
    }
}

class VoltAdapter extends Socket
{
    public Volt getVolt(int volts)
	{
        	if (volts == 3) return new Volt(3);
        	else if (volts == 12) return new Volt(12);
        	else return getVolt(); // Default 120V
    	}
}

public class Slip13
{
    public static void main(String[] args) 
    {
        VoltAdapter adapter = new VoltAdapter();
        System.out.println("3V Output : " + adapter.getVolt(3).getVolts() + "V");
        System.out.println("12V Output: " + adapter.getVolt(12).getVolts() + "V");
        System.out.println("Default Output: " + adapter.getVolt(0).getVolts() + "V");    
    }
}


// Output : 

// 3V Output : 3V
// 12V Output: 12V
// Default Output: 120V