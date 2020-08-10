package novi.spring.helloworld.controller;

import novi.spring.helloworld.model.Student;
import novi.spring.helloworld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository students;

    @GetMapping("/api/student")
    public ResponseEntity<?> getStudent() {
        Optional<Student> _student = students.findById(1);
        if(_student.isPresent()) {
            Student student = _student.get();
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.badRequest().body("no student found");
        }
    }

    @GetMapping("/api/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id) {
        Optional<Student> _student = students.findById(id);
        if(_student.isPresent()) {
            Student student = _student.get();
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.badRequest().body("no student found");
        }
    }
}
