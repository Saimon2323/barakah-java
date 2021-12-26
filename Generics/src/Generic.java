/**
 * @Author Muhammad Saimon
 * @since Dec 12/26/21 6:46 PM
 */


public class Generic<T> { // This is Type Parameterize. Here T is Type Parameter
    private T obj;  // Declare a Type variable

    public Generic(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    // this method will print what will be the Type of 'obj' object in RunTime
    public void showType() {
        String type = obj.getClass().getName();
        System.out.println("Type of T is: " + type);
    }
}
