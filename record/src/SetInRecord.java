import java.util.HashSet;
import java.util.Set;

/**
 * @Author Muhammad Saimon
 * @since Dec 09, 2024 12:34 AM
 */

public class SetInRecord {
    public static void main(String[] args) {
        Set<StudentClass> setOfClass = new HashSet<>();

        StudentClass s1 = new StudentClass("50", "Noyon", 3.80f);
        StudentClass s2 = new StudentClass("50", "Noyon", 3.80f);

        // How does set actually compare
        // At first, Set compares hashcode of class. if it matches, then set check equals(). If it matches, set will not add that value.
        setOfClass.add(s1);
        setOfClass.add(s2);

        // the contains of s1 and s2 are same. Still 2 sets (s1, s2) are added. As here Set compares reference not contains.
        // But, if you override hashCode() and equals() then 1 is added in set instead 2.
        // For detailed explanation see How-hashSet-works.png
        System.out.println("Set of Class : " + setOfClass);
        System.out.println("Size of setClass : " + setOfClass.size());

        System.out.println("===================================");

        Set<StudentRecord> setOfRecord = new HashSet<>();

        StudentRecord r1 = new StudentRecord("60", "Hasan", 3.60f);
        StudentRecord r2 = new StudentRecord("60", "Hasan", 3.60f);

        setOfRecord.add(r1);
        setOfRecord.add(r2);

        // the contains of r1 and r2 are same and like class, Set in Record doesn't add this twice.
        System.out.println("Set of Record : " + setOfRecord);
        System.out.println("Size of setRecord : " + setOfRecord.size());

    }
}
