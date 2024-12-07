/**
 * @Author Muhammad Saimon
 * @since Dec 07, 2024 2:24 PM
 */

public class StudentClass {

    private final String id;

    private final String name;

    private final float cgpa;

    public StudentClass(String id, String name, float cgpa) {
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
