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

    public void updateStudent(Student student) {
        if (!repository.update(student)) {
            System.console().writer().println("Student with ID: '%s' isn't exists!".formatted(student.getId()));
        } else {
            System.console().writer().println("Updated successfully!");
        }
    }

    public void deleteStudent(String id) {
        if (!repository.deleteById(id)) {
            System.console().writer().println("Student with ID: '%s' isn't exists!".formatted(id));
        } else {
            System.console().writer().println("Deleted successfully!");
        }
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public List<Student> getStudentsAscendingById() {
        return repository.findAll().stream().sorted(Comparator.comparing(Student::getId)).toList();
    }

    public boolean isStudentExists(String id) {
        return repository.isStudentExists(id);
    }

    public void saveData() throws IOException {
        repository.writeDataToBinFile();
    }
}
