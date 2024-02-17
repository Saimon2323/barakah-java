package chapter.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Muhammad Saimon
 * Since 2/17/24 10:49 AM
 */

/*
* Wildcard Arguments
* Type parameters
* extents (Upper Bounded wildcard)
* super (Lower Bounded wildcard)
* */
public class WildcardArguments {

    public static void printList(List<Object> lst) {
        // accept list of Object only
        // not list of subclasses of Object

        for (Object o : lst) {
            System.out.print(o + ", ");
        }
        System.out.println();

    }

    public static void printList2(List<?> lst) {
        // now accept list of subclasses of Object

        for (Object o : lst) {
            System.out.print(o + ", ");
        }
        System.out.println();

    }

    public static <T> void printList3(List<T> lst) {
        // now accept list of subclasses of Object

        for (T o : lst) {
            System.out.println(o);
        }
        System.out.println();
    }


    // <T extends Number> means ? mark a ashte hobe oisob class jara Number er subclass. Only Number class er subclass gula ke process korbe.
    // this is known as Upper bounded wildcard
    public static void printListOfNumberOnly(List<? extends Number> lst) {

        for (Object o : lst) {
            System.out.print(o + ", ");
        }
        System.out.println();

    }

    public static void printListOfIntegerAndItsSuper(List<? super Integer> lst) {

        // works only for Integer and Its super class Number
        // doesn't work Double, Float, Long etc.
        // this is known as Lower bounded wildcard

        for (Object o : lst) {
            System.out.print(o + ", ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        List<Object> objList = new ArrayList<>();
        objList.add(55);
        objList.add("Hasan");
        objList.add(10.5);
        objList.add('A');
        printList(objList);

/*
        // jodi public static void printList(List<Object> lst) e evabe List<Object> thake, tahole Object chara onno
        // kichu like String, Integer etc kaj korbe na jodi o sob class Object er subclass. But Generics er khetre
        // Hierarchy kaj kore na.
        // so printList() method sob kichu accept korte hole Generics er Wildcard Arguments use korte hobe. i.e (List<?> list)
        // PrintList2() method a otai dekhanu hoyeche
        // etar solution Type Parameters diyeo kora possible. i.e <T> printList3(List<T> list)

        List<String> strList = new ArrayList<>();
        strList.add("One");
        printList(strList);

        List<Integer> intList = new ArrayList<>();
        intList.add(5);
        printList(intList);
*/

        List<String> strList = new ArrayList<>();
        strList.add("One");
        printList2(strList);
        printList3(strList);
        // printListOfNumberOnly(strList); Not Possible
        // printListOfNumberOnly2(strList); Not possible


        List<Integer> intList = new ArrayList<>();
        intList.add(5);
        printList2(intList);
        printList3(intList);
        printListOfNumberOnly(intList);
        printListOfIntegerAndItsSuper(intList);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(5.10);
        printList2(doubleList);
        printList3(doubleList);
        printListOfNumberOnly(doubleList);
//        printListOfNumberOnly2(doubleList); not possible

        List<Number> numberList = new ArrayList<>();
        numberList.add(12);
        numberList.add(12.5);
        numberList.add(123456L);
        printListOfNumberOnly(numberList);
        printListOfIntegerAndItsSuper(numberList);

        List<Float> floatList = new ArrayList<>();
        floatList.add(23.5f);
        printListOfNumberOnly(floatList);
//        printListOfNumberOnly2(floatList); Not possible
    }
}
