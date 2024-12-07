import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author Muhammad Saimon
 * @since Dec 08, 2024 12:26 AM
 */

public class RecordSerializeAndDeserializeCheck {
    public static void main(String[] args) {
        StudentRecord studentRecord = new StudentRecord("102", "Muhammad Hasan", -3.52f);

        serialize(studentRecord);

        // In Record, deserialization is done through Canonical Constructor.
        // At first, We serialize studentRecord object without putting validation in construction.
        // then put validation in constructor, and try to deserialize that faulty serialized file.
        // Error occurred. IT doesn't deserialize because it went to Canonical Construction and found Validation
        StudentRecord deserialized = (StudentRecord) deserialize();
        System.out.println("After Deserialization: " + deserialized);
    }

    // To serialize any class or record, that class or record must have to implements Serializable, otherwise it will throw Exception
    public static void serialize(Object obj) {
        try (FileOutputStream fos = new FileOutputStream("record/src/serialized-student-data.ser");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
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
