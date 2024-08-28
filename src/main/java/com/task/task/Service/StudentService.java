package com.task.task.Service;

import com.task.task.Entity.Student;
import com.task.task.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setStudentLevel(studentDetails.getStudentLevel());
            student.setFaculty(studentDetails.getFaculty());
            return studentRepository.save(student);
        } else {
            return null;
        }
    }
    public void deleteStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else return;
    }
}
