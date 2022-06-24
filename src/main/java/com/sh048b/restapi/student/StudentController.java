package com.sh048b.restapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping()
    public Student postStudent(@RequestBody Student studentPayload) {
        return studentService.saveStudent(studentPayload);
    }

    @DeleteMapping(path = "{student_id}")
    public String deleteStudent(@PathVariable("student_id") Long studentId) {
        return studentService.deleteStudentById(studentId);
    }

    @PutMapping(path = "{studentId}")
    public Student updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        return studentService.updateStudentById(studentId, name, email);
    }
}
