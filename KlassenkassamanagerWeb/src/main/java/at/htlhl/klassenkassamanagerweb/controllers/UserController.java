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
@RequestMapping("/klassenkassa-manager/User")
public class UserController {

    StudentRepository studentRepository = new StudentRepository();
    ClassRepository classRepository = new ClassRepository();

    @GetMapping(value = "/{id}/Classes", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get students of class")
    public ArrayList<Class> getClassesFromUser(@PathVariable int id) throws SQLException {
        return classRepository.getClassesByUserId(id);
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

