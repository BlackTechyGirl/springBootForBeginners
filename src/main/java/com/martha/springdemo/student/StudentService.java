package com.martha.springdemo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> findAllStudents(){
        return List.of(
                new Student(
                        "Martha",
                        "Danladi",
                        LocalDate.now(),
                        "marthadanladi653@gmail.com",
                        26
                ),
                new Student(
                        "Mart",
                        "Danladi",
                        LocalDate.now(),
                        "marthadanladi653@gmail.com",
                        26
                )
        );
    }

}
