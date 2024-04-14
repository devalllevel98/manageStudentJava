package org.example.studentmanager.service;

import org.example.studentmanager.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student Student);
    public void deleteStudentById(int id);

}
