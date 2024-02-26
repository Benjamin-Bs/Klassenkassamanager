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

/**
 * Controller class for managing user-related operations in the Klassenkassa Manager application.
 * This includes retrieving classes associated with a user, creating, editing, and deleting users.
 */
@RestController
@RequestMapping("/klassenkassa-manager/User")
public class UserController {

    StudentRepository studentRepository = new StudentRepository();
    ClassRepository classRepository = new ClassRepository();
    UserRepository userRepository = new UserRepository();

    @GetMapping(value = "/isUser", produces = "text/plain")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a Student by id")
    public String isUser(@RequestParam String username, @RequestParam String password) throws SQLException {
        boolean userExists = userRepository.isUser(new User(username, password));
        return Boolean.toString(userExists); // Convert boolean to string representation
    }

    @GetMapping(value = "/Id", produces = "text/plain")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a Student by id")
    public String getIdByUser(@RequestParam String username, @RequestParam String password) throws SQLException {
        int userId;
        try {
            userId = userRepository.getIdByUser(new User(username, password));
        }catch (SQLException e){
            return "-1";
        }
        return Integer.toString(userId);
    }

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
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a User by id")
    public User getUserById(@PathVariable int id) throws SQLException {
        return userRepository.getUserById(id);
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
    public void addUser(@RequestBody User user) throws SQLException {
        userRepository.addUser(user);
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
    public User editUserById(@PathVariable int id,  @RequestBody User user) throws SQLException {
        return userRepository.updateUserById(id, user);
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
    public void deleteUserById(@PathVariable int id) throws SQLException {
        userRepository.deleteUserById(id);
    }


    /**
     * Sets the StudentRepository for the controller.
     *
     * @param studentRepository The StudentRepository to be set.
     */
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    /**
     * Sets the ClassRepository for the controller.
     *
     * @param classRepository The ClassRepository to be set.
     */
    @Autowired
    public void setClassRepository(ClassRepository classRepository){
        this.classRepository = classRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }


}

