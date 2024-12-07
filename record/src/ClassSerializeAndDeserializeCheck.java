import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author Muhammad Saimon
 * @since Dec 08, 2024 12:23 AM
 */

public class ClassSerializeAndDeserializeCheck {
    public static void main(String[] args) {
        StudentClass studentClass = new StudentClass("101", "Abid", 3.58f);

        serialize(studentClass);

        // In Class, deserialization is done by reflection API. It doesn't go to that Class Constructor.
        // At first, We serialize studentClass object without putting validation in construction.
        // then put validation in constructor, and try to deserialize that faulty serialized file.
        // it deserialized perfectly because it didn't go to constructor that's why validation check failed
        // This problem is solved by Record
        StudentClass deserialized = (StudentClass) deserialize();
        System.out.println("After Deserialization: " + deserialized);

    }

    // To serialize any class or record, that class or record must have to implements Serializable, otherwise it will throw Exception
    public static void serialize(Object obj) {
        try (FileOutputStream fos = new FileOutputStream("record/src/serialized-student-data.ser");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Object deserialize() {
        try (FileInputStream fis = new FileInputStream("record/src/serialized-student-data.ser");
             ObjectInputStream in = new ObjectInputStream(fis)) {
            return in.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
