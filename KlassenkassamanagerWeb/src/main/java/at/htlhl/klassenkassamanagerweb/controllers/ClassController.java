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
@RequestMapping("/klassenkassa-manager/Class")
public class ClassController {

    StudentRepository studentRepository = new StudentRepository();
    ClassRepository classRepository = new ClassRepository();

    @GetMapping(value = "/{id}/Students", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all Students of Class")
    public ArrayList<Student> getStudentsFromClass(@PathVariable int id) throws SQLException {
        return studentRepository.getStudentsByArg("classId", id);
    }

    @GetMapping(value = "/{id}/Properties", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Properties of Class")
    public Class getPropertiesFromClass(@PathVariable int id) throws SQLException {
        return classRepository.getClassById(id);
    }

    @PostMapping(value = "/{id}/Student", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a Students in a Class")
    public Student addStudentToClass(@PathVariable int id, @RequestBody Student student) throws SQLException {
        return studentRepository.addStudent(id, student);
    }

    @PostMapping(value = "/", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a Class")
    public Class addClass(@RequestBody Class classObject) throws SQLException {
        return null;
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edit a Class by id")
    public Class editClassById(@PathVariable int id,  @RequestBody Class classObject) throws SQLException {
        return classRepository.getClassById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a Class by id")
    public Class deleteClassById(@PathVariable int id) throws SQLException {
        return classRepository.getClassById(id);
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
