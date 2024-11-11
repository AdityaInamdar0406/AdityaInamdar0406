// //Write a JAVA Program to implement built-in support (java.util.Observable) Weather 
// station with members temperature, humidity, pressure and methods 
// mesurmentsChanged(), setMesurment(), getTemperature(), getHumidity(), 
// getPressure() 



import java.util.Observable;

class WeatherStation extends Observable
{
    float temperature,humidity,pressure;

    public void setMeasurements(float temperature,float humidity,float pressure)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

    public void measurementsChanged()
    {
        setChanged();
        notifyObservers();
    }

    public float getTemperature()
    {
        return temperature;
    }

    public float getHumidity()
    {
        return humidity;
    }

    public float getPressure()
    {
        return pressure;
    }

    public static void main(String[] args) 
    {
        WeatherStation station = new WeatherStation();
        station.addObserver((observable,arg) ->
        {
            WeatherStation ws = (WeatherStation) observable;
            System.out.println("Temperature : " + ws.getTemperature());
            System.out.println("Humidity : " + ws.getHumidity());
            System.out.println("Pressure : " + ws.getPressure());
        });    
        station.setMeasurements(1, 2, 3);
    }
}


// Output : 

// Temperature : 1.0
// Humidity : 2.0
// Pressure : 3.0