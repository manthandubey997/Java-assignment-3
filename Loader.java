package util;

/**
 * Simple Runnable to simulate a loading process.
 */
public class Loader implements Runnable {

    private final String message;

    public Loader(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            // print the initial message then simulate progress
            System.out.println(message);
            for (int i = 0; i < 3; i++) {
                Thread.sleep(400); // half-second-ish steps
                System.out.print("."); 
            }
            System.out.println(); // newline after dots
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
