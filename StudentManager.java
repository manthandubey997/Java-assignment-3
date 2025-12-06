package service;

import model.Student;
import exceptions.StudentNotFoundException;
import util.Loader;

import java.util.HashMap;

public class StudentManager implements RecordActions {

    private final HashMap<Integer, Student> map = new HashMap<>();

    @Override
    public void addStudent(Student s) throws IllegalArgumentException {
        // validation and duplicate prevention
        if (s == null) throw new IllegalArgumentException("Student object is null.");

        Integer roll = s.getRollNo();
        String name = s.getName();
        String course = s.getCourse();
        Double marks = s.getMarks();

        if (roll == null) throw new IllegalArgumentException("Roll number is required.");
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name is required.");
        if (course == null || course.trim().isEmpty()) throw new IllegalArgumentException("Course is required.");
        if (marks == null) throw new IllegalArgumentException("Marks are required.");
        if (marks < 0.0 || marks > 100.0) throw new IllegalArgumentException("Marks must be between 0 and 100.");

        if (map.containsKey(roll)) {
            throw new IllegalArgumentException("Duplicate roll number: " + roll);
        }

        // simulate loading using a loader thread
        Thread loaderThread = new Thread(new Loader("Loading....."));
        loaderThread.start();
        try {
            loaderThread.join(); // wait until loading finishes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // add after loading simulation completes
        map.put(roll, s);
        System.out.println("Student saved successfully.");
    }

    @Override
    public void deleteStudent(Integer rollNo) throws StudentNotFoundException {
        if (map.remove(rollNo) == null) {
            throw new StudentNotFoundException("Student with roll " + rollNo + " not found.");
        }
        System.out.println("Student with roll " + rollNo + " deleted.");
    }

    @Override
    public void updateStudent(Integer rollNo, Student newDetails) throws StudentNotFoundException {
        if (!map.containsKey(rollNo)) {
            throw new StudentNotFoundException("Student with roll " + rollNo + " not found.");
        }
        // basic validation could be repeated or delegated
        map.put(rollNo, newDetails);
        System.out.println("Student updated.");
    }

    @Override
    public Student searchStudent(Integer rollNo) throws StudentNotFoundException {
        Student s = map.get(rollNo);
        if (s == null) throw new StudentNotFoundException("Student with roll " + rollNo + " not found.");
        return s;
    }

    @Override
    public void viewAllStudents() {
        if (map.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student s : map.values()) {
            s.displayInfo();
            System.out.println("-----------------------");
        }
    }
}
