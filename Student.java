package model;

public class Student extends Person {
    private Integer rollNo;   // wrapper used intentionally
    private String course;
    private Double marks;     // wrapper used intentionally
    private char grade;

    public Student() {}

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    public Integer getRollNo() { return rollNo; }
    public String getCourse() { return course; }
    public Double getMarks() { return marks; }
    public void setMarks(Double marks) { this.marks = marks; calculateGrade(); }
    public void setCourse(String course) { this.course = course; }
    public void setEmail(String email) { this.email = email; }
    public void setName(String name) { this.name = name; }

    private void calculateGrade() {
        if (marks == null) { grade = 'D'; return; }
        double m = marks.doubleValue();
        if (m >= 90.0) grade = 'A';
        else if (m >= 75.0) grade = 'B';
        else if (m >= 60.0) grade = 'C';
        else grade = 'D';
    }

    @Override
    public void displayInfo() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }
}
