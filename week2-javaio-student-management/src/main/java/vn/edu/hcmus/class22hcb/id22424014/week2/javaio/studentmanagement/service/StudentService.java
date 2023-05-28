package vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.domain.Student;
import vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.repository.StudentFileRepository;

public class StudentService {
    private final StudentFileRepository repository;

    public StudentService() throws ClassNotFoundException {
        repository = new StudentFileRepository();
    }

    public void addStudent(Student student) {
        if (!repository.add(student)) {
            System.console().writer().println("Student with ID: '%s' is already exists!".formatted(student.getId()));
        }
    }

    public List<Student> getStudentsAscendingById() {
        repository.findAll().sort(Comparator.comparing(Student::getId));
        return repository.findAll();
    }

    public void saveData() throws IOException {
        repository.writeDataToBinFile();
    }
}
