package novi.spring.helloworld;

import novi.spring.helloworld.model.Student;
import novi.spring.helloworld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {
    @Autowired
    private StudentRepository students;

    @Override
    public void run(String... args) throws Exception {
        students.save(new Student("Dennis"));
    }
}
