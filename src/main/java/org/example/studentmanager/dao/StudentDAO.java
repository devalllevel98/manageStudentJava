package org.example.studentmanager.dao;
import org.example.studentmanager.entity.Student;
import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();//get all
    public Student getById(int id);//getid
    public Student save(Student student);//save student
    public Student updateStudent(Student student);//update
    public void deleteById(int id);//delete student


}
