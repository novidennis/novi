package novi.spring.helloworld.repository;

import novi.spring.helloworld.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
