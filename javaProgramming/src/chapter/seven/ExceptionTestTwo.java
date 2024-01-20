package chapter.seven;

/**
 * Author: Muhammad Saimon
 * Since 1/21/24 1:51 AM
 */

public class ExceptionTestTwo {

    public static void main(String[] args) throws Exception {

        try {
            methodA();
            methodB();
            doNotCallMe();
        } catch (XyzException ex) {
            System.out.println("1st Catch Exception occurred: " + ex.getMessage());
        }
        catch (Exception e) {
            throw e;
        } finally {
            System.out.println("Finally block");
        }
        System.out.println("End of main method");
    }

    private static void methodA() {
        System.out.println("Inside methodA");
    }

    private static void methodB() throws XyzException {
        System.out.println("Inside methodB");
        throw new XyzException();
    }

    private static void doNotCallMe() throws Exception {
        System.out.println("Inside doNotCallMe");
        throw new Exception("You can't call this method");
    }
}
