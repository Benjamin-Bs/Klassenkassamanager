package at.htlhl.klassenkassamanagerweb.controllers;

import at.htlhl.klassenkassamanagerweb.models.Student;
import at.htlhl.klassenkassamanagerweb.repositories.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;


@RestController
@RequestMapping("/klassenkassa-manager")
public class StudentsController {

    StudentRepository studentRepository = new StudentRepository();

    @GetMapping(value = "/Student/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get student")
    public Student getStudentFromId(@PathVariable int id) throws SQLException {
        return studentRepository.getStudentById(id);
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
}
