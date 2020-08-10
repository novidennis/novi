package novi.spring.repository;

import novi.spring.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findByName(String name);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);
}