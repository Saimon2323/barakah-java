import java.io.Serializable;

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
}
