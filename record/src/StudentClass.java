import java.io.Serializable;
import java.util.Objects;

/**
 * @Author Muhammad Saimon
 * @since Dec 07, 2024 2:24 PM
 */

public class StudentClass implements Serializable {

    private final String id;

    private final String name;

    private final float cgpa;

    public StudentClass(String id, String name, float cgpa) {

        if (cgpa < 0.00f || cgpa > 4.00f) {
            throw new IllegalArgumentException("Invalid CGPA %.2f".formatted(cgpa));
        }

        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        System.out.println("equals(): Checking Set Checking Logic");
//        if (o == null || getClass() != o.getClass()) return false;
//        StudentClass that = (StudentClass) o;
//        return Float.compare(cgpa, that.cgpa) == 0 && Objects.equals(id, that.id) && Objects.equals(name, that.name);
//    }
//
//    @Override
//    public int hashCode() {
//        System.out.println("hashCode(): Checking Set Checking Logic");
//        return Objects.hash(id, name, cgpa);
//    }
}
