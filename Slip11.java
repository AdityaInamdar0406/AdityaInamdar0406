// //Write a java program to implement Adapter pattern to design Heart Model to Beat 
// Model



interface BeatModel
{
	void start();
	void stop();
	int getBeatRate();
}

class HeartModel
{
	int heartRate = 70;

	public int getHeartRate()
	{
		return heartRate;
	}
}

class HeartBeatModel implements BeatModel
{
	HeartModel heartModel;

	HeartBeatModel(HeartModel heartModel)
	{
		this.heartModel = heartModel;
	}

	public void start()
	{
		System.out.println("Heart Model Started");
	}

	public void stop()
	{
		System.out.println("Heart Model Stopped");
	}

	public int getBeatRate()
	{
		return heartModel.getHeartRate();
	}
}

public class Slip11
{
	public static void main(String[] args) 
	{
		BeatModel beatModel = new HeartBeatModel(new HeartModel());
		beatModel.start();

		System.out.println("Rate : " + beatModel.getBeatRate());
		beatModel.stop();	
	}
}


// Output : 

// Heart Model Started
// Rate : 70
// Heart Model Stopped