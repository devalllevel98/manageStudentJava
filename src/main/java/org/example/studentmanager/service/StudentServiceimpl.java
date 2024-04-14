package org.example.studentmanager.service;

import jakarta.transaction.Transactional;
import org.example.studentmanager.dao.StudentDAO;
import org.example.studentmanager.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService{
    private StudentDAO studentDao;
    @Autowired
    public StudentServiceimpl(StudentDAO studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentDao.deleteById(id);
    }
}
