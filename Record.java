package service;

import model.Student;
import exceptions.StudentNotFoundException;

public interface RecordActions {
    void addStudent(Student s) throws IllegalArgumentException;
    void deleteStudent(Integer rollNo) throws StudentNotFoundException;
    void updateStudent(Integer rollNo, Student newDetails) throws StudentNotFoundException;
    Student searchStudent(Integer rollNo) throws StudentNotFoundException;
    void viewAllStudents();
}
