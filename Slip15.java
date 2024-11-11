// Q.1 Write a Java Program to implement Facade Design Pattern for Home Theater 


// Subsystem Classes
class Amplifier {
    void on() {
        System.out.println("Amplifier is ON");
    }

    void off() {
        System.out.println("Amplifier is OFF");
    }

    void setVolume(int level) {
        System.out.println("Amplifier volume set to " + level);
    }
}

class DvdPlayer {
    void on() {
        System.out.println("DVD Player is ON");
    }

    void off() {
        System.out.println("DVD Player is OFF");
    }

    void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    void stop() {
        System.out.println("Stopping DVD Player");
    }
}

class Projector {
    void on() {
        System.out.println("Projector is ON");
    }

    void off() {
        System.out.println("Projector is OFF");
    }

    void wideScreenMode() {
        System.out.println("Projector set to widescreen mode");
    }
}

class Screen {
    void down() {
        System.out.println("Screen is DOWN");
    }

    void up() {
        System.out.println("Screen is UP");
    }
}

class TheaterLights {
    void dim(int level) {
        System.out.println("Theater Lights dimmed to " + level + "%");
    }

    void on() {
        System.out.println("Theater Lights are ON");
    }
}

// Facade Class
class HomeTheaterFacade {
    private Amplifier amp;
    private DvdPlayer dvd;
    private Projector projector;
    private Screen screen;
    private TheaterLights lights;

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, Projector projector, Screen screen, TheaterLights lights) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.off();
    }
}

// Main Test Class named Slip15
public class Slip15 {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, screen, lights);

        // Start watching a movie
        homeTheater.watchMovie("Inception");

        // End the movie
        homeTheater.endMovie();
    }
}

// Output

// Get ready to watch a movie...
// Theater Lights dimmed to 10%
// Screen is DOWN
// Projector is ON
// Projector set to widescreen mode
// Amplifier is ON
// Amplifier volume set to 5
// DVD Player is ON
// Playing movie: Inception
// Shutting movie theater down...
// Theater Lights are ON
// Screen is UP
// Projector is OFF
// Amplifier is OFF
// Stopping DVD Player
// DVD Player is OFF