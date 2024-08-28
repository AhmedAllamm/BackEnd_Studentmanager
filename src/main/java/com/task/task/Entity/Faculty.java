package com.task.task.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "faculties")
@Data
public class Faculty {
    @Id
    @SequenceGenerator(
            name = "faculty_id_sequence",
            sequenceName = "faculty_id_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "faculty_id_sequence"
    )
    @Column(name = "faculty_id")
    private Integer id;
    @Column(name = "faculty_name")
    private String name;


    public Faculty(){}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
