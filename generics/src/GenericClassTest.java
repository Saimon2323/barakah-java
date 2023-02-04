/**
 * @Author Muhammad Saimon
 * @since Dec 12/26/21 5:25 PM
 */

// There are two types in Java. Primitive type(int, double, long etc) and Reference Type(Integer, Double, Long etc)
// Generic only works with Reference Type.
// Ex: Generic<int> integerGeneric = new Generic<int>(88); is NOT VALID

public class GenericClassTest {
    public static void main(String[] args) {
        Generic<Integer> integerGeneric; // It is a Reference of Integer

        // create object and assign in 'integerGeneric' Reference
        integerGeneric = new Generic<Integer>(88);

        integerGeneric.showType();
        int intVal = integerGeneric.getObj();
        System.out.println("Value: " + intVal);

        //--------------------------------

        Generic<String> stringGeneric = new Generic<String>("Generic Hasan");
        stringGeneric.showType();
        String str = stringGeneric.getObj();
        System.out.println("Value: " + str);


        System.out.println("##############################################################");

        // Multiple Type Parameterize
        Tuple<String, Integer> nameAndNo = new Tuple<String, Integer>("Hasan", 23);


        Tuple<String, Tuple<String, Integer>> companyAndNameAndNo;
        companyAndNameAndNo = new Tuple<String, Tuple<String, Integer>>("Exabyting", nameAndNo);

        nameAndNo.showType();
        companyAndNameAndNo.showType();
    }
}
