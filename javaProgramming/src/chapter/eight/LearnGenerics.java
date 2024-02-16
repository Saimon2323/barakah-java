package chapter.eight;

/**
 * Author: Muhammad Saimon
 * Since Feb 14, 2024 8:50 AM
 */

public class LearnGenerics<A> {

    private A aObj;

    public LearnGenerics(A obj) {
        aObj = obj;
    }

    public A getaObj() {
        return aObj;
    }

    public void showType() {
        System.out.println("\nName: " + aObj.getClass().getName()); // java.lang.Integer
        System.out.println("TypeName: " + aObj.getClass().getTypeName()); // java.lang.Integer
        System.out.println("CanonicalName: " + aObj.getClass().getCanonicalName()); // java.lang.Integer
        System.out.println("PackageName: " + aObj.getClass().getPackageName()); // java.lang
        System.out.println("SimpleName: " + aObj.getClass().getSimpleName()); // Integer
        System.out.println("Value: " + getaObj());
    }

    public static void main(String[] args) {

        LearnGenerics<Integer> intObj = new LearnGenerics<>(23);
        intObj.showType();

        LearnGenerics<String> strObj = new LearnGenerics<>("Afifa");
        strObj.showType();

        LearnGenerics<Double> dblObj = new LearnGenerics<>(23.94);
        dblObj.showType();

        // Type Parameter Can't be a primitive type. Generics only works on Reference Type.
//        LearnGenerics<int> intObj = new LearnGenerics<>(23);
//        intObj.showType();
    }
}
