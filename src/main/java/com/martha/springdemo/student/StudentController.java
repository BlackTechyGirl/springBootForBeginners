package com.martha.springdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {


    //tightly coupled application
    //private StudentService service = new StudentService();

//    dependency injection: field injection
//    @Autowired
//    private StudentService service = new StudentService();

//    constructor injection: Recommended to use
    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;

    }


    @PostMapping
    private Student save(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }


    @GetMapping
    public List<Student> findAllStudents(){
        return service.findAllStudents();
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }


    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") String email){
        service.delete(email);

    }
}
