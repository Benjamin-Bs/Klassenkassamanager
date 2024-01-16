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
/**
 * Controller class for handling Student-related operations in the Klassenkassa Manager application.
 * This includes retrieving a student by ID, editing a student, and deleting a student.
 */
@RestController
@RequestMapping("/klassenkassa-manager/Student")
public class StudentsController {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Retrieves a student by their ID.
     *
     * @param id The ID of the student to be retrieved.
     * @return Student object representing the student with the specified ID.
     * @throws SQLException if there is a database access error.
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Student by ID")
    public Student getStudentFromId(@PathVariable int id) throws SQLException {
        return studentRepository.getStudentById(id);
    }

    /**
     * Edits an existing student by their ID.
     *
     * @param id      The ID of the student to be edited.
     * @param student The Student object containing updated information.
     * @return Student object representing the edited student.
     * @throws SQLException if there is a database access error.
     */
    @PatchMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edit a Students by id")
    public Student editStudentById(@PathVariable int id, @RequestBody Student student) throws SQLException {
        return studentRepository.updateStudent(id, student);
    }

    /**
     * Deletes a student by their ID.
     *
     * @param id The ID of the student to be deleted.
     * @return ResponseEntity indicating the success of the deletion operation.
     * @throws SQLException if there is a database access error.
     */
    @DeleteMapping(value = "/{id}", produces = "text/plain")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a Student by id")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) throws SQLException {
        studentRepository.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Sets the StudentRepository for the controller.
     *
     * @param studentRepository The StudentRepository to be set.
     */
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
