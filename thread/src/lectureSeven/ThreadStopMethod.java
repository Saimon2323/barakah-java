package lectureSeven;

/**
 * @Author Muhammad Saimon
 * @since Sep 25, 2024 7:52 PM
 */
// Thread.stop() method is deprecated and should not be used.
public class ThreadStopMethod {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();


        Thread.sleep(5000);

        System.out.println("Status before stop: " + thread.isAlive() + " " + thread.getState());

        thread.stop();

        Thread.sleep(10);

        System.out.println("Status after stop: " + thread.isAlive() + " " + thread.getState());
    }
}
