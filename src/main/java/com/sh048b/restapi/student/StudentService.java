package com.sh048b.restapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student studentPayload) {
        Optional<Student> queriedStudent = studentRepository
                .findStudentByEmail(studentPayload.getEmail());
        if (queriedStudent.isPresent())
            throw new IllegalStateException("email token");
        return studentRepository.save(studentPayload);
    }

    public String deleteStudentById(Long studentId) {
        boolean res = studentRepository.existsById(studentId);
        System.out.println(studentId);
        if (!res) throw new IllegalStateException("Student not found");
        studentRepository.deleteById(studentId);
        return "Student deleted successfully";
    }

    @Transactional
    public Student updateStudentById(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + "does not exits"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }
        return student;
    }
}
