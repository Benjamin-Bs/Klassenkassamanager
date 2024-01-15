package at.htlhl.klassenkassamanagerweb.controllers;

import at.htlhl.klassenkassamanagerweb.models.Class;
import at.htlhl.klassenkassamanagerweb.models.Student;
import at.htlhl.klassenkassamanagerweb.models.User;
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

    @GetMapping(value = "/{name}/Classes", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all Classes of a User")
    public ArrayList<Class> getClassesFromUser(@PathVariable String name) throws SQLException {
        return classRepository.getClassesByUserName(name);
    }

    @GetMapping(value = "/{id}/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a User by id")
    public ArrayList<Student> getUserById(@PathVariable int id) throws SQLException {
        return null;
    }

    @PostMapping(value = "/", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a User")
    public Student addUser(@RequestBody User user) throws SQLException {
        return null;
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edit a User by id")
    public Class editUserById(@PathVariable int id,  @RequestBody User user) throws SQLException {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a User by id")
    public Class deleteUserById(@PathVariable int id) throws SQLException {
        return null;
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

