package novi.spring.model.notes;

import novi.spring.model.users.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Tag() {}

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
