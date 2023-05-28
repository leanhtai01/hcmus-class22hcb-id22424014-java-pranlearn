package vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.repository;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;

import vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.domain.Student;

public class StudentFileRepository {
    private static final Logger LOGGER = getLogger(lookup().lookupClass());
    private static final String DATA_FILE_NAME_BIN = "student.dat";

    private List<Student> students;

    public StudentFileRepository() throws ClassNotFoundException {
        // try to load students data
        try (var reader = new ObjectInputStream(new FileInputStream(DATA_FILE_NAME_BIN))) {
            @SuppressWarnings("unchecked")
            List<Student> rawData = (List<Student>) reader.readObject();
            this.students = rawData;
        } catch (IOException exception) {
            LOGGER.warn("Data not found!");
            this.students = new ArrayList<>();
        }
    }

    public void writeDataToBinFile() throws IOException {
        try (var writer = new ObjectOutputStream(new FileOutputStream(DATA_FILE_NAME_BIN))) {
            writer.writeObject(students);
        }
    }

    public void importDataFromCSVFile(String fileName) throws IOException {
        List<Student> data = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Path.of(fileName))) {
            lines.forEach(line -> {
                String[] tokens = line.split(",");
                data.add(new Student(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3], tokens[4]));
            });
        }

        students = data;
    }

    public void exportDataToCSVFile(String fileName) throws IOException {
        try (var writer = new PrintWriter(fileName, StandardCharsets.UTF_8)) {
            this.students.stream().forEach(student -> writer.println("%s,%s,%f,%s,%s".formatted(
                    student.getId(),
                    student.getName(),
                    student.getGrade(),
                    student.getAddress(),
                    student.getNote())));
        }
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(String id) {
        return students.get(students.indexOf(new Student(id)));
    }

    public boolean add(Student student) {
        if (students.contains(student))
            return false;

        students.add(student);

        return true;
    }

    public boolean update(Student updatedStudent) {
        for (Student student : students) {
            if (student.equals(updatedStudent)) {
                student.setName(updatedStudent.getName());
                student.setGrade(updatedStudent.getGrade());
                student.setAddress(updatedStudent.getAddress());
                student.setNote(updatedStudent.getNote());

                return true;
            }
        }
        
        return false;
    }

    public boolean deleteById(String id) {
        Student deletedStudent = new Student(id);

        return students.contains(deletedStudent) && students.remove(deletedStudent);
    }
}
