package com.task.task.Controller;

import com.task.task.Entity.Faculty;
import com.task.task.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")

public class FacultyController {
    @Autowired
    private FacultyService facultyService;
//    private Faculty updateFaculty;

    @PostMapping("/add")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
//       System.out.println(" student  == "+ student.getFaculty().getId());
        return facultyService.createFaculty(faculty);
    }

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyService.getAll();
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Integer id) {
        return facultyService.getFacultyById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Integer id, @RequestBody Faculty facultyDetails) {
        Faculty updatedFaculty = facultyService.updateFaculty(id, facultyDetails);
        if (updatedFaculty != null) {
            return ResponseEntity.ok(updatedFaculty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        if (facultyService.getFacultyById(id) != null) {
            facultyService.deleteFaculty(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
