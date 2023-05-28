package vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 9082532603621712690L;

    private String id;
    private String name;
    private double grade;
    private String address;
    private String note;

    public Student() {
        id = "unknown id";
        name = "unknown name";
        grade = 0.0;
        address = "unknown address";
        note = "unknown note";
    }

    public Student(String id) {
        this.id = id;
        name = "unknown name";
        grade = 0.0;
        address = "unknown address";
        note = "unknown note";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;

        if (getClass() != otherObject.getClass())
            return false;

        Student other = (Student) otherObject;

        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, grade, address, note);
    }
}
