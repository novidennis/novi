package novi.spring.model.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import novi.spring.model.notes.Comment;
import novi.spring.model.notes.Like;
import novi.spring.model.notes.Note;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Getter
    @Setter
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @Getter
    @Setter
    @JsonIgnore
    private String email;

    @NotBlank
    @Size(max = 120)
    @Getter
    @JsonIgnore
    private String password;

    @Getter
    @Setter
    @ManyToMany()
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private List<Role> roles = new ArrayList<>();

    @Getter
    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Note> notes = new ArrayList<>();

    @Getter
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    @Getter
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Like> likes = new ArrayList<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}