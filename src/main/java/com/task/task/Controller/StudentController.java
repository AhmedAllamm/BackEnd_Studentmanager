package com.task.task.Controller;

import com.task.task.Entity.Student;
import com.task.task.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student) {
//       System.out.println(" student  == "+ student.getFaculty().getId());
        return studentService.createStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id)
    {
     return studentService.getStudentById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        if (studentService.getStudentById(id) != null) {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
