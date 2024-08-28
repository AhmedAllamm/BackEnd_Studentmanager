package com.task.task.Service;

import com.task.task.Entity.Faculty;
import com.task.task.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

        public  List<Faculty> getAll(){
            return facultyRepository.findAll();
        }
        public Faculty getFacultyById(Integer id){
            return facultyRepository.findById(id).orElse(null);
        }
        public Faculty createFaculty(Faculty faculty) {
            return facultyRepository.save(faculty);
        }
//
        public Faculty updateFaculty(Integer id, Faculty facultyDetails) {
            Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
            if (optionalFaculty.isPresent()) {
                Faculty faculty = optionalFaculty.get();
                faculty.setName(facultyDetails.getName());
                faculty.setId(facultyDetails.getId());
                return facultyRepository.save(faculty);
            } else {
                return null;
            }
        }
        public void deleteFaculty(Integer id) {
            if (facultyRepository.existsById(id)) {
                facultyRepository.deleteById(id);
            } else return;
        }
    }



