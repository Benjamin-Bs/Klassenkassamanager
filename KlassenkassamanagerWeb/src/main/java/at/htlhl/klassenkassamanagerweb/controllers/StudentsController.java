package at.htlhl.klassenkassamanagerweb.controllers;

import at.htlhl.klassenkassamanagerweb.models.Student;
import at.htlhl.klassenkassamanagerweb.repositories.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


@RestController
@RequestMapping("/klassenkassa-manager/Students")
public class StudentsController {

    StudentRepository studentRepository = new StudentRepository();

    @GetMapping(value = "", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get latest temperature")
    public Student findLatest() throws SQLException {
        return studentRepository.getStudentById(1);
    }
}
