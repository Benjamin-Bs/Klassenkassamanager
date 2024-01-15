package at.htlhl.klassenkassamanagerweb.controllers;

import at.htlhl.klassenkassamanagerweb.models.Student;
import at.htlhl.klassenkassamanagerweb.repositories.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;


@RestController
@RequestMapping("/klassenkassa-manager/Student")
public class StudentsController {

    StudentRepository studentRepository = new StudentRepository();

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Student by ID")
    public Student getStudentFromId(@PathVariable int id) throws SQLException {
        return studentRepository.getStudentById(id);
    }


    @PatchMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edit a Students by id")
    public Student editStudentById(@PathVariable int id, @RequestBody Student student) throws SQLException {
        return studentRepository.updateStudent(id, student);
    }

    @DeleteMapping(value = "/{id}", produces = "text/plain")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a Student by id")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) throws SQLException {
        studentRepository.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
}
