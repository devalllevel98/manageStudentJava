package org.example.studentmanager.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.studentmanager.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        String jpql = "SELECT s FROM Student s";
        return entityManager.createQuery(jpql, Student.class).getResultList();
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }


    @Override
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        student = entityManager.merge(student);
        entityManager.flush();
        return student;
    }

    @Override
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }
}
