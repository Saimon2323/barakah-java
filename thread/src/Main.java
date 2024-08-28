import java.util.concurrent.Callable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("ThreadGroup");
        Thread.currentThread().getThreadGroup().list();

        System.out.println("ThreadGroup details with parent");
        Thread.currentThread().getThreadGroup().getParent().list();
    }
}