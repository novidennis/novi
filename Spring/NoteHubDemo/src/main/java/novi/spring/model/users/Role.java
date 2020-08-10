package novi.spring.model.users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Roles name;

    public Role() {

    }

    public Role(Roles name) {
        this.name = name;
    }

    public String getName() {
        return name.name();
    }
}