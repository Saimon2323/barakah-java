/**
 * @Author Muhammad Saimon
 * @since Dec 07, 2024 5:09 PM
 */

// StudentRecord(String id, String name, float cgpa) - this is Record Header
// here, StudentRecord is Record name and (id, name, cgpa) these are component list
public record StudentRecord(String id, String name, float cgpa) {

    // There are 2 types of Constructor in Record. Canonical Constructor and Compact Constructor

    // Compiler create AllArgConstructor. This is called 'Canonical Constructor' in Record,
    // but Sometimes we have to create or override this Canonical Constructor to add validation or other purposes
    // 1. Component List name must have to keep same.
    // 2. all components must have to set precisely. (this.id = id, ....)
    // If you don't wanna do 1 & 2, then You should convert this Canonical to Compact Constructor. Compiler will 1 & 2 for you.
    public StudentRecord(String id, String name, float cgpa) {

        if (cgpa < 0.00f || cgpa > 4.00f) {
            throw new IllegalArgumentException("Invalid CGPA %.2f".formatted(cgpa));
        }

        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

/*
    // This is Compact Constructor. All you have to do just put your validation and other stuff, compiler will do the rest.
    public StudentRecord {
        if (cgpa < 0.00f || cgpa > 4.00f) {
            throw new IllegalArgumentException("Invalid CGPA %.2f".formatted(cgpa));
        }
    }

*/

    // You can create only one constructor. Either Canonical or Compact.
    // If you want to create other constructor like NoArgConstructor, you have to point Compact or Canonical Constructor.
    // For Example

    public StudentRecord() {
        this("103", "Miad", 3.80f);
    }











    // Compiler would create Getter method like this for all component
    // but you can override it but you can't change ReturnType and access modifier
    public String name() {
        return "StudentName: " + this.name;
    }

    // You can pass parameters on default method. But this won't change the default name() method.
    // then there will be 2 methods like method overloading
    // If you call with parameter, name(String lastName) will be called. Otherwise, default name() method will be called.
    public String name(String lastName) {
        return this.name + " " + lastName;
    }

    // You can add other methods as well
    public String getEmail() {
        return this.name.toLowerCase() + "@example.com";
    }
}



// When we run this class, Compiler make all the fields final add 5 things in Class behind the scene
// - AllArgConstructor, All Getter, ToString, Equal and HashCode.
// As record is also a class. After compilation, compiler turned into it a class and
// add 'final' before it as it is immutable. And extends 'Record' Class
// For example: public final class StudentRecord extends Record {}
// To See this, go to /out/production/record/ and type "javap -v -p StudentRecord.class" [here -v means verbose and -p means to see private field of this class]
