package com.martha.springdemo.student;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDao {
    private final List<Student> STUDENTS = new ArrayList<Student>();

    public Student save(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public List<Student> findAllStudents(){
        return STUDENTS;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream()
                .filter(student ->email.equals(student.getEmail()))
                .findFirst()
                .orElse(null);

    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if(studentIndex>-1){
            STUDENTS.set(studentIndex, student);
        }
        return student;
    }

    public void delete(String email) {
        var student = findByEmail(email);
        if(student != null){
            STUDENTS.remove(student);
        }

    }
}
