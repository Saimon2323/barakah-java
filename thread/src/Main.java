//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Create a new thread
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running");
        });

        // Start the thread
        thread.start();
    }
}