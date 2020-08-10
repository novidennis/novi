package novi.spring.repository;

import novi.spring.model.notes.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Integer> {
    Optional<Tag> findByName(String name);
    boolean existsByName(String name);
}
