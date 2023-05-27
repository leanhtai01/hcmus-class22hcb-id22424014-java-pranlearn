package vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.domain;

public class Student {
    private String id;
    private String name;
    private double grade;
    private String note;

    public Student() {
    }

    public Student(String id, String name, double grade, String note) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
