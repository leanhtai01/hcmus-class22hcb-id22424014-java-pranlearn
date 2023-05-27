package vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.domain.Student;

public class StudentRepository {
    private List<Student> students;

    public StudentRepository() throws IOException {
        this.students = new ArrayList<>();
        try (var fis = new FileInputStream("src/main/java/resources/application.properties")) {
            var properties = new Properties();
            properties.load(fis);
        }
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(String id) {
        return students.get(students.indexOf(new Student(id)));
    }

    public boolean save(Student student) {
        if (students.contains(student))
            return false;

        students.add(student);

        return true;
    }

    public boolean deleteById(String id) {
        Student deletedStudent = new Student(id);

        return students.contains(deletedStudent) && students.remove(deletedStudent);
    }
}
