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

/**
 * Controller class for managing user-related operations in the Klassenkassa Manager application.
 * This includes retrieving classes associated with a user, creating, editing, and deleting users.
 */
@RestController
@RequestMapping("/klassenkassa-manager/User")
public class UserController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    /**
     * Retrieves all classes associated with a user.
     *
     * @param name The username for which classes are to be retrieved.
     * @return ArrayList of Class objects associated with the specified user.
     * @throws SQLException if there is a database access error.
     */
    @GetMapping(value = "/{name}/Classes", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all Classes of a User")
    public ArrayList<Class> getClassesFromUser(@PathVariable String name) throws SQLException {
        return classRepository.getClassesByUserName(name);
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return ArrayList of Student objects representing the user with the specified ID.
     * @throws SQLException if there is a database access error.
     */
    @GetMapping(value = "/{id}/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a User by id")
    public ArrayList<Student> getUserById(@PathVariable int id) throws SQLException {
        return null;
    }

    /**
     * Creates a new user.
     *
     * @param user The User object containing information about the user to be created.
     * @return Student object representing the newly created user.
     * @throws SQLException if there is a database access error.
     */
    @PostMapping(value = "/", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a User")
    public Student addUser(@RequestBody User user) throws SQLException {
        return null;
    }

    /**
     * Edits an existing user by their ID.
     *
     * @param id   The ID of the user to be edited.
     * @param user The User object containing updated information.
     * @return Class object representing the edited user's associated class.
     * @throws SQLException if there is a database access error.
     */
    @PatchMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edit a User by id")
    public Class editUserById(@PathVariable int id, @RequestBody User user) throws SQLException {
        return null;
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to be deleted.
     * @return Class object representing the deleted user's associated class.
     * @throws SQLException if there is a database access error.
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a User by id")
    public Class deleteUserById(@PathVariable int id) throws SQLException {
        return null;
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

    /**
     * Sets the ClassRepository for the controller.
     *
     * @param classRepository The ClassRepository to be set.
     */
    @Autowired
    public void setClassRepository(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }
}
