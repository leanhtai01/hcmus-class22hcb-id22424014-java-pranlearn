package vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.repository;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.domain.Student;

public class StudentFileRepository {
    private static final Logger LOGGER = getLogger(lookup().lookupClass());
    private static final String DATA_FILE_NAME = "student.dat";

    private List<Student> students;

    public StudentFileRepository() throws ClassNotFoundException {
        // try to load students data
        try (var reader = new ObjectInputStream(new FileInputStream(DATA_FILE_NAME))) {
            @SuppressWarnings("unchecked")
            List<Student> rawData = (List<Student>) reader.readObject();
            this.students = rawData;
        } catch (IOException exception) {
            LOGGER.warn("Data not found!");
            this.students = new ArrayList<>();
        }
    }

    public void writeDataToFile() throws IOException {
        try (var writer = new ObjectOutputStream(new FileOutputStream(DATA_FILE_NAME))) {
            writer.writeObject(students);
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
