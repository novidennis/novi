package novi.spring.model.notes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import novi.spring.model.users.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JsonBackReference
    private Note note;

    @ManyToOne()
    @JsonBackReference
    private User user;

    private Date date;

    public Like() {}

    public Like(Note note, User user, Date date) {
        this.note = note;
        this.user = user;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }
}
