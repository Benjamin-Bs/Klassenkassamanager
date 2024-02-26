package at.htlhl.klassenkassamanagerweb.controllers;

import at.htlhl.klassenkassamanagerweb.models.Class;
import at.htlhl.klassenkassamanagerweb.models.Student;
import at.htlhl.klassenkassamanagerweb.repositories.ClassRepository;
import at.htlhl.klassenkassamanagerweb.repositories.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Api for Class
 */
@RestController
@RequestMapping("/klassenkassa-manager/Class")
public class ClassController {

    StudentRepository studentRepository = new StudentRepository();
    ClassRepository classRepository = new ClassRepository();

    /**
     * Get Mapping of the students
     *
     * @param id Takes the Class Id
     * @return
     * @throws SQLException
     */
    @GetMapping(value = "/{id}/Students", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all Students of Class")
    public ArrayList<Student> getStudentsFromClass(@PathVariable int id) throws SQLException {
        return studentRepository.getStudentsByArg("classId", id);
    }

    /**
     * Get Mapping of the properties
     *
     * @param id Takes the class id
     * @return
     * @throws SQLException
     */
    @GetMapping(value = "/{id}/Properties", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Properties of Class")
    public Class getPropertiesFromClass(@PathVariable int id) throws SQLException {
        return classRepository.getClassById(id);
    }

    /**
     * Post Mapping of the students
     *
     * @param id
     * @param student
     * @return
     * @throws SQLException
     */
    @PostMapping(value = "/{id}/Student", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a Students in a Class")
    public Student addStudentToClass(@PathVariable int id, @RequestBody Student student) throws SQLException {
        return studentRepository.addStudent(id, student);
    }

    /**
     * @param classObject
     * @return
     * @throws SQLException
     */
    @PostMapping(value = "/", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a Class")
    public Class addClass(@RequestBody Class classObject) throws SQLException {
        Class returnClass = classRepository.addClass(classObject);
        //studentRepository.addStudent(returnClass.getId(), new  Student(25, classObject.getOwnerId(), "FIRSTNAME", "LASTNAME", 0, 0));
        return returnClass;
    }

    /**
     * @param id
     * @param classObject
     * @return
     * @throws SQLException
     */
    @PatchMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edit a Class by id")
    public Class editClassById(@PathVariable int id, @RequestBody Class classObject) throws SQLException {
        return classRepository.updateStudent(id, classObject);
    }

    /**
     * To delete the the class
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @DeleteMapping(value = "/{id}", produces = "text/plain")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a Class by id")
    public ResponseEntity<String> deleteClassById(@PathVariable int id) throws SQLException {
        classRepository.deleteClassById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * @param studentRepository
     */
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * @param classRepository
     */
    @Autowired
    public void setClassRepository(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }
}
