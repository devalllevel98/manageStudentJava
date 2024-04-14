package org.example.studentmanager.rest;
import org.example.studentmanager.dao.StudentDAO;
import org.example.studentmanager.entity.Student;
import org.example.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudent(){
       return this.studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        if(student != null){
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        student.setId(0);
        student = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
        Student exitStudent = studentService.getStudentById(id);
        if(exitStudent != null){
            exitStudent.setFirstName(student.getFirstName());
            exitStudent.setLastName(student.getLastName());
            exitStudent.setEmail(student.getEmail());
            studentService.updateStudent(exitStudent);
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        Student exitStudent = studentService.getStudentById(id);
        if(exitStudent != null){
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
