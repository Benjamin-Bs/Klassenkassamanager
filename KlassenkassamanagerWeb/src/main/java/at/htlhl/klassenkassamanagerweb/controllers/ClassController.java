package at.htlhl.klassenkassamanagerweb.controllers;

import at.htlhl.klassenkassamanagerweb.models.Class;
import at.htlhl.klassenkassamanagerweb.models.Student;
import at.htlhl.klassenkassamanagerweb.repositories.ClassRepository;
import at.htlhl.klassenkassamanagerweb.repositories.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/klassenkassa-manager/Class")
public class ClassController {

    StudentRepository studentRepository = new StudentRepository();
    ClassRepository classRepository = new ClassRepository();

    @GetMapping(value = "/{id}/Students", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get students of class")
    public ArrayList<Student> getStudentsFromClass(@PathVariable int id) throws SQLException {
        return studentRepository.getStudentsByArg("classId", id);
    }

    @GetMapping(value = "/{id}/Properties", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get students of class")
    public Class getPropertiesFromClass(@PathVariable int id) throws SQLException {
        return classRepository.getClassById(id);
    }


    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setClassRepository(ClassRepository classRepository){
        this.classRepository = classRepository;
    }
}
