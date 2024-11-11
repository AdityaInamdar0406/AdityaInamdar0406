//Write a Java Program to implement Singleton pattern for multithreading
public class Slip2 {
    // Private constructor to prevent instantiation
    private Slip2() {}

    // Static inner helper class responsible for holding the Singleton instance
    private static class SingletonHelper {
        // Singleton instance, created only once and is thread-safe
        private static final Slip2 INSTANCE = new Slip2();
    }

    // Method to return the Singleton instance
    public static Slip2 getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public static void main(String[] args) {
        // Runnable task that tries to access the Singleton instance
        Runnable task = new Runnable() {
            public void run() {
                // Each thread will print the instance's hashcode to confirm they are the same
                System.out.println(Slip2.getInstance().hashCode());
            }
        };

        // Creating multiple threads to test Singleton behavior
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
    }
}


// Output :
// Instance ID (Memory Address): 139595724113696
// Instance ID (Memory Address): 139595724113696
// Instance ID (Memory Address): 139595724113696
