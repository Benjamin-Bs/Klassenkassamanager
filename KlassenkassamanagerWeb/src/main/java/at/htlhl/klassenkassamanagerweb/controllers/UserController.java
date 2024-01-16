package at.htlhl.klassenkassamanagerweb.controllers;

import at.htlhl.klassenkassamanagerweb.models.Class;
import at.htlhl.klassenkassamanagerweb.models.Student;
import at.htlhl.klassenkassamanagerweb.models.User;
import at.htlhl.klassenkassamanagerweb.repositories.ClassRepository;
import at.htlhl.klassenkassamanagerweb.repositories.StudentRepository;
import at.htlhl.klassenkassamanagerweb.repositories.UserRepository;
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
    UserRepository userRepository = new UserRepository();

    @GetMapping(value = "/{name}/Classes", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all Classes of a User")
    public ArrayList<Class> getClassesFromUser(@PathVariable String name) throws SQLException {
        return classRepository.getClassesByUserName(name);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a User by id")
    public User getUserById(@PathVariable int id) throws SQLException {
        return userRepository.getUserById(id);
    }

    @PostMapping(value = "/", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a User")
    public void addUser(@RequestBody User user) throws SQLException {
        userRepository.addUser(user);
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edit a User by id")
    public User editUserById(@PathVariable int id,  @RequestBody User user) throws SQLException {
        return userRepository.updateUserById(id, user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a User by id")
    public void deleteUserById(@PathVariable int id) throws SQLException {
        userRepository.deleteUserById(id);
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setClassRepository(ClassRepository classRepository){
        this.classRepository = classRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

}

