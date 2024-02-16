package chapter.eight;

/**
 * Author: Muhammad Saimon
 * Since 2/14/24 9:25 AM
 */

public class MultipleGenerics<H, A> {
    private H key;
    private A value;

    public MultipleGenerics(H key, A value) {
        this.key = key;
        this.value = value;
    }

    public MultipleGenerics() {
    }

    public void put(H hObj, A aObj) {
        this.key = hObj;
        this.value = aObj;
    }

    public A get(H key) {
        return value;
    }

    public H getKey() {
        return key;
    }

    public A getValue() {
        return value;
    }

    public void showTypes() {
        System.out.println("Type of Object H: " + key.getClass().getName());
        System.out.println("Value of H: " + getKey());
        System.out.println("Type of Object A: " + value.getClass().getName());
        System.out.println("Value of A: " + getValue());
    }


    public static void main(String[] args) {


        MultipleGenerics<String, String> couple = new MultipleGenerics<>();
        couple.put("Abid", "Afifa");
        couple.put("Hasan", "Afid");

        System.out.println("Result: " + couple.get("Abid"));
        System.out.println("Result: " + couple.get("Hasan"));
        couple.showTypes();

        MultipleGenerics<String, Integer> ages = new MultipleGenerics<>();
        ages.put("Abid", 29);

        System.out.println("\nAge Result: " + ages.get("Abid"));
        ages.showTypes();
    }
}
